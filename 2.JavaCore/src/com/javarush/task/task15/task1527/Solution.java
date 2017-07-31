package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //s = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";

        //get tokens arrays key=value (obj=3.14 name=Amigo)
        String params = s.substring(s.indexOf("?") + 1);
        String[] splitParts;
        splitParts = params.split("&");

        //Split every item in splitParts array by "=" and put to Map as key and value
        LinkedHashMap<String, String> paramters = new LinkedHashMap<String, String>();
        for (int i = 0; i < splitParts.length; i++) {
            int posEqualChar = splitParts[i].indexOf("=");
            if (posEqualChar < 0) { //no param, only key exist
                paramters.put(splitParts[i], null);
                continue;
            }
            String key = splitParts[i].substring(0, posEqualChar);
            String value = splitParts[i].substring(posEqualChar + 1);
            paramters.put(key, value);
        }

        //key printing
        for (String key : paramters.keySet()) {
            System.out.print(key + " ");
        }

        //print alert
        System.out.println();
        String objParameter = paramters.get("obj");
        if (objParameter == null) {
            return;
        }

        try {
            alert(Double.parseDouble(objParameter));
        } catch (NumberFormatException e) {
            alert(objParameter);
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
