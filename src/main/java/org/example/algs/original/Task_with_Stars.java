package org.example.algs.original;

import java.util.Stack;

public class Task_with_Stars {

    public static void main(String[] args) {
        String s = "*asdq**swd1*";
        System.out.println(removeStars(s));

    }

    public static String removeStars(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == '*'){
                stack.pop();
            } else if (stack.isEmpty() && s.charAt(i) == '*') {
                continue;
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(Character c : stack){
            stringBuilder.append(c);
        }


        return stringBuilder.toString();
    }
}
