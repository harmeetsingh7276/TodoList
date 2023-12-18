package com.harmeet.springboot.TodoList;

import java.util.Map;
import java.util.TreeMap;

class HelloWorld {
    public static void main(String[] args) {
        String str = "t2e1st This i1s f1irs1t Here";
        System.out.println(decodedMessage(str));
    }

    public static String decodedMessage(String encodedString) {
        TreeMap<Integer, String> map = new TreeMap<>();
        String[] words = encodedString.split(" ");
       
        for (String word : words) {
            char[] characters = word.toCharArray();
            int key = 0;
            StringBuilder s = new StringBuilder();
           
            for (char c : characters) {
                if (Character.isDigit(c)) {
                    key += Character.getNumericValue(c);
                } else {
                    s.append(c);
                }
            }
           
            map.put(key, s.toString());
        }
       
        StringBuilder result = new StringBuilder();
       
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String word = entry.getValue();
            if (!word.isEmpty()) {
                result.append(word).append(" ");
            }
        }
       
        return result.toString().trim();
    }
}