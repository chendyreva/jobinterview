package ru.geekbrains.arraylist;

import java.util.ArrayList;

public class Arraylist{

    public static void main(String[] args) {

        ArrayList<String> cars = new ArrayList<String>();
        // добавим в список ряд элементов
        cars.add("Alfa Romeo");
        cars.add("Audi");
        cars.add("Bentley");
        cars.add("BMW");
        cars.add(1, "Bugatti"); // добавляем элемент по индексу 1
        System.out.println("We get  object № 2:");

        System.out.println(cars.get(1));// получаем 2-й объект
        cars.set(1, "Porsche"); // установка нового значения для 2-го объекта

        System.out.printf("ArrayList has %d elements: \n", cars.size());
        for(String person : cars){

            System.out.println(person);
        }
        // проверяем наличие элемента
        if(cars.contains("Porsche")){

            System.out.println("ArrayList contains Porsche");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        cars.remove("Bugatti");
        // удаление по индексу
        cars.remove(0);
        System.out.println("We deleted some elements and now we have: ");
        System.out.printf("ArrayList has %d elements: \n", cars.size());

        Object[] peopleArray = cars.toArray();
        for(Object person : peopleArray){

            System.out.println(person);
        }
    }
}