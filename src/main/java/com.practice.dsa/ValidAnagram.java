package src.main.java.com.practice.dsa;

import java.util.*;

public class ValidAnagram {


    public static void main(String[] args) {

      //  boolean result1 = isAnagram("anagram","nagaram");
        boolean result = isAnagram2("anagram","nagaram");

        System.out.println(result);
    }



    public static boolean isAnagram(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> strA = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (strA.containsKey(ch))
                strA.put(ch, strA.get(ch) + 1);
            else
                strA.put(ch, 1);
        }

        for (char chT : t.toCharArray()) {
            if (strA.containsKey(chT) && strA.get(chT) > 0) {
                strA.put(chT, strA.get(chT) - 1);
            } else return false;
        }

        for (Integer i : strA.values()) {
            if (i > 0) return false;
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return false;
        if (s.length() != t.length()) return false;

        char[] strA = s.toCharArray();
        char[] strB = t.toCharArray();
        Arrays.sort(strA);
        Arrays.sort(strB);

        return Arrays.equals(strA,strB);
    }
}
