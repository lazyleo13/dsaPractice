package src.main.java.com.practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class EncodeDecodeString {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Hello","World");
        //encodeDecodeString(input);
        List<String> output = encodedDecoded(input);
        System.out.println(output);
    }

    public static List<String> encodedDecoded(List<String> str){
        String encodedStr = encodeString(str);
        return decodedString(encodedStr);
    }

    public static List<String> encodeDecodeString(List<String> input){
        List<String> output = new ArrayList<>();
        String inter = "";
        ListIterator<String> iterator = input.listIterator();

        while(iterator.hasNext()){
            inter= inter.concat(iterator.next());
            if(iterator.hasNext()) inter = inter.concat(":");
        }

        String[] result = inter.split(":");
        for(String s: result){
            output.add(s);
        }

        return output;
    }

    public static String encodeString (List<String> str){
        StringBuilder encodedStr = new StringBuilder();
        for(String s:str){
            encodedStr.append(s.length()).append("#").append(s);
        }
        return encodedStr.toString();
    }
    //5#hello5#world
    public static List<String> decodedString(String str){
        int i = 0;
        List<String> resultList = new ArrayList<>();
        while( i < str.length()){
            int j =i;
            if(str.charAt(j) != '#'){
                j++;
            }
            int indexOfHash = j;
            int lengthOfStr = Integer.parseInt(String.valueOf(str.charAt(j-1)));
            String decodedStr = str.substring(indexOfHash+1,indexOfHash+lengthOfStr+1);
            resultList.add(decodedStr);
            i = indexOfHash+lengthOfStr+1;
        }
        return resultList;
    }
}
