package org.example.algs.original;

public class Palindrome {

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i -1)){
                return false;
            }
        }

        return true;
    }
}
