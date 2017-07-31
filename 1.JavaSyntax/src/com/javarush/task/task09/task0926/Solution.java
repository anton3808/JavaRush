package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2};
        int[] arr2 = {2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 5, 1, 3};
        int[] arr4 = {};
        list.add(arr);
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
