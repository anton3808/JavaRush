package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public int x , y , z, a;
    public static void main(String[] args) {

    }

    public Solution(){}
    Solution(int x, int y, int z){}
    protected Solution(int x, int y){}
    private Solution(int x){}
}

