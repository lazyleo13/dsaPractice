package src.main.java.com.practice.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = new char[][] {  {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

     /*   char[][] board = new char[][] { {'.','.','.','.','.','.','5','.','.'},
                                        {'-','.','.','.','.','.','.','.','.'},
                                        {'.','.','.','.','.','.','.','.','.'},
                                        {'9','3','.','.','2','.','4','.','.'},
                                        {',','.','7','.','.','.','3','.','.'},
                                        {'.','.','.','.','.','.','.','.','.'},
                                        {'.','.','.','3','4','.','.','.','.'},
                                        {'.','.','.','.','.','3','.','.','.'},
                                        {'.','.','.','.','.','5','2','.','.'}}; */

        //System.out.println(isValidSudoku(board));
        System.out.println(isValidSudokuSingleIteration(board));

    }

    public static boolean isValidSudoku(char [][] board){

        int columns = board[0].length;
        int rows = board.length;

        Map<Character,Integer> mapColumn = new HashMap<>();
        //analyze each column
        for(int i=0; i<rows;i++){
            mapColumn = new HashMap<>();
            for(int j=0; j<columns;j++){
                if(board[i][j] != '.' && mapColumn.containsKey(board[i][j])){
                    return false;
                }else {
                    mapColumn.put(board[i][j], 1);
                }
            }
        }

        //analyze each row

        Map<Character,Integer> mapRow = new HashMap<>();
        for(int i=0; i<columns;i++){
            mapRow = new HashMap<>();
            for(int j=0; j<rows;j++){
                if(board[j][i] != '.' && mapRow.containsKey(board[j][i])){
                    return false;
                }else {
                    mapRow.put(board[j][i], 1);
                }
            }
        }

        //analyze each 3*3 block
        int m=0;
        int n=0;
        Map<Character,Integer> mapBlock = new HashMap<>();

        while( m < rows) {
            int i = m;
            while (n < columns) {
                for (int j = n; j < n + 3; j++) {
                    for (i = m; i < m + 3; i++) {
                        if (board[i][j] != '.' && mapBlock.containsKey(board[i][j])) {
                            return false;
                        } else {
                            mapBlock.put(board[i][j], 1);
                        }
                    }
                }
                n += 3;
                mapBlock = new HashMap<>();
            }
            m += 3;
            n=0;
            mapBlock = new HashMap<>();
        }

        return true;
    }

    public static boolean isValidSudokuSingleIteration(char[][] board){

        Set<Character>[] resCol = new HashSet[9];
        Set<Character>[] resRow = new HashSet[9];
        Set<Character>[] resBoxes = new HashSet[9];

        for(int i =0;i<9;i++){
            resCol[i] = new HashSet<>();
            resRow[i] = new HashSet<>();
            resBoxes[i] = new HashSet<>();
        }

        //prepare and analyze each row /col and box in a single iteration

        for(int i =0 ; i <9 ; i++){
            for(int j =0 ;j< 9;j++){
                char num = board[i][j];

                if(num == '.') continue;
                int box = ((i/3)*3) + (j/3); // (row/3)*3+ (col/3);

                if( resRow[i].contains(num) || resCol[j].contains(num) || resBoxes[box].contains(num)){
                    return false;
                }

                resRow[i].add(num);
                resCol[j].add(num);
                resBoxes[box].add(num);
            }
        }
        return true;
    }
}
