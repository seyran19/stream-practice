package org.example.algs.original;

class LongestPalindromicSubstring {

    private static int beginning;
    private static int length;


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdc"));
    }


    public static String longestPalindrome(String s) {

        if (s.length() < 2){
            return s;
        }

        for (int i = 0; i < s.length(); i++){
            check(s, i, i); // нечетный стринг
            check(s, i, i + 1); // четный
        }

        return s.substring(beginning, length + beginning);

    }

    private static void check(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }

        if (end - start > length){
            length = end - start - 1;
            beginning = start + 1;
        }
    }
}
