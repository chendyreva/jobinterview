package ru.geekbrains.mycollection;

public class ArrayListCustomApp {
    public static void main(String... a) {
        ArrayListCustom<Integer> list = new ArrayListCustom<Integer>();
        //Добавить элементы в пользовательский ArrayList
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        //отобразим собственный ArrayList
        list.display();
        System.out.println("\nэлемент по индексу в пользовательском ArrayList > " + 1 + " = " + list.get(1));
        //Удалим элемент из пользовательского ArrayList
        System.out.println("элемент удален c индексом  " + 1 + " = "
                + list.remove(1));
        //снова отобразим собственный ArrayList
        System.out
                .println("\nснова отобразим собственный ArrayList после удаления по индексу 1");
        list.display();

    }
}