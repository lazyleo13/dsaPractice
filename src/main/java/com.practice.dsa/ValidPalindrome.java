package src.main.java.com.practice.dsa;

public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        System.out.println("String is a palindrome : "+ isPalindrome(s));

    }

    public static boolean isPalindrome(String s){

        String newString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int left = 0;
        int right = newString.length()-1;

        while(left < right){
            if(newString.charAt(left) != newString.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }


}
