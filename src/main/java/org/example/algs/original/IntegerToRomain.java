package org.example.algs.original;

public class IntegerToRomain {

    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {
        System.out.println(new IntegerToRomain().solution(950));
    }

    public String solution(int number){

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < numbers.length && number > 0; i++){
            int temp = numbers[i];

            while (number >= temp){
                number -= temp;
                result.append(str[i]);
            }
        }
        return result.toString();
    }
}
