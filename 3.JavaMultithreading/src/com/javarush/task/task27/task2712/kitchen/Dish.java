package com.javarush.task.task27.task2712.kitchen;
public enum Dish {
    Fish, Steak, Soup, Juice, Water;
    public static String allDishesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        Dish[] dishes = Dish.values();
        stringBuilder.append(dishes[0]);
        for (int i = 1; i < dishes.length; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(dishes[i]);
        }
        String string = stringBuilder.toString();
        return string;
    }
}
