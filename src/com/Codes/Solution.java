package com.Codes;

import java.util.*;
import java.lang.System;
import javax.swing.ImageIcon;

class Solution {

    static HashMap<Character, String> map = new HashMap<>();

    public static void main(String args[]) {
        initializeMap();
        System.out.println(new ImageIcon("").getIconWidth());
        System.exit(0);
        Scanner in = new Scanner(System.in);
        String L = in.next();
        int N = in.nextInt();
        String[] dic = new String[N];
        for (int i = 0; i < N; i++) {
            String W = in.next();
            dic[i] = decode(W);
        }
        System.out.println("Decoding complete! :)");
        long num = 0;
        long i = 0;
        for (String dic2 : dic) {
            for (String dic1 : dic) {
                String word = String.join("", dic);
                if (L.contains(word)) {
                    System.out.println("hari");
                }
                dic = shift(dic);
            }
        }
        System.out.println(num);
    }

    static String[] shift(String[] ar) {
        String first = ar[0];
        for (int i = 1; i < ar.length; i++) {
            ar[i - 1] = ar[i];
        }
        ar[ar.length - 1] = first;
        return ar;
    }

    static String decode(String enword) {
        String toMorse = "";
        for (char ch : enword.toCharArray()) {
            for (Map.Entry<Character, String> symbol : map.entrySet()) {
                Character key = symbol.getKey();
                if (key == ch) {
                    toMorse = toMorse.concat(map.get(ch));
                }
            }
        }
        return toMorse;
    }

    static String[] getRemainder(String morse, String charseq) {
        morse = morse.replace(charseq, " ");
        StringTokenizer token = new StringTokenizer(morse);
        String[] ret = new String[token.countTokens()];
        int idx = 0;
        while (token.hasMoreElements()) {
            ret[idx] = (String) token.nextElement();
            idx++;
        }
        System.out.println("geting remainders...");
        return ret;
    }

    static boolean isAMorse(String morse, String[] dictionary) {
        for (String dic : dictionary) {
            if (morse.replaceAll(" ", "").equals("")) {
                return true;
            } else if (morse.contains(dic)) {
                morse = morse.replaceAll(dic, " ");
            }
        }
        morse = morse.replaceAll(" ", "");
        System.out.println("Claculating is a morse symbol...");
        return morse.replaceAll(" ", "").equals("");
    }

    static void initializeMap() {
        map.put('A', ".-");
        map.put('B', "-...");
        map.put('C', "-.-.");
        map.put('D', "-..");
        map.put('E', ".");
        map.put('F', "..-.");
        map.put('G', "--.");
        map.put('H', "....");
        map.put('I', "..");
        map.put('J', ".---");
        map.put('K', "-.-");
        map.put('L', ".-..");
        map.put('M', "--");
        map.put('N', "-.");
        map.put('O', "---");
        map.put('P', ".--.");
        map.put('Q', "--.-");
        map.put('R', ".-.");
        map.put('S', "...");
        map.put('T', "-");
        map.put('U', "..-");
        map.put('V', "...-");
        map.put('W', ".--");
        map.put('X', "-..-");
        map.put('Y', "-.--");
        map.put('Z', "--..");
    }
}
