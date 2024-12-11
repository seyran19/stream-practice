package org.example.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;


///  moskva slezam ne verit!
public class Number_26 {

    public static void main(String[] args) {

        String st = "mmmooossskkkvvvaaa  sssllleeezzzaammm nnneeee vvveeerrriiitt!!";

        String s1 = Arrays.stream(st.split(" "))
                .map(s -> Arrays.stream(s.split(""))
                        .distinct()
                        .reduce((a, b) -> a + b).orElse(""))
                .reduce((a, b) -> a + b + " ").orElse("");


        System.out.println(s1);
        System.out.println(modified(st));


    }

    public static String modified(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        LinkedHashMap<Character, String> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && s.charAt(i) != ' ') {
                map.put(s.charAt(i), "");
                stringBuilder.append(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                map.clear();

                stringBuilder.append(s.charAt(i));

            }
        }

        return Arrays.stream(stringBuilder.toString().split(" "))
                .peek(System.out::println)
                .map( sb -> sb.strip())
                .reduce((a, b) -> a  +   b + " ").orElse("");

    }
}
