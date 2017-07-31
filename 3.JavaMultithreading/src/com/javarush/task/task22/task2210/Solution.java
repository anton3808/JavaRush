package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] test = getTokens("level22.lesson13.task01", ".");
        for (String s : test) {
            System.out.println(s);
        }
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] res = new String[st.countTokens()];
        for (int i = 0; i < res.length && st.hasMoreTokens(); i++) {
            res[i] = st.nextToken();
        }
        return res;
    }
}
