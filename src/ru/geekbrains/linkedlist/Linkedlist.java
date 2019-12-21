package ru.geekbrains.linkedlist;

import java.util.LinkedList;

public class Linkedlist{

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<String>();

        // добавляем в список ряд элементов
        cities.add("Moscow");
        cities.add("Novosibirsk");
        cities.add("Koltsovo");
        cities.addLast("Yekaterinburg"); // добавляем на последнее место
        cities.addFirst("Magadan"); // добавляем на первое место
        cities.add(1, "Omsk"); // добавляем элемент по индексу 1

        System.out.printf("List has %d elements and we add one new: \n ", cities.size());
        System.out.println(cities.get(1));
        cities.set(1, "Saint-Petersburg");
        for (String city : cities) {

            System.out.println(city);
        }
        // проверка на наличие элемента в списке
        if (cities.contains("Novosibirsk")) {

            System.out.println("List contains Novosibirsk");
        }

        cities.remove("Novosibirsk");
        cities.removeFirst(); // удаление первого элемента
        cities.removeLast(); // удаление последнего элемента
        System.out.println("Вывод после удаления первого и последнего элемента:");
        System.out.printf("List has %d elements: \n ", cities.size());
        for (String city : cities) {

            System.out.println(city);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");



        LinkedList<Person> people = new LinkedList<Person>();
        people.add(new Person("Mike"));
        people.add(new Person("Sasha"));
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));


        for(Person p : people){

            System.out.println(p.getName());
        }
        Person first = people.getFirst();
        System.out.println("Выводим 1 элемент: ");
        System.out.println(first.getName()); // вывод первого элемента
        people.remove(1); // удаление второго элемента
        System.out.println("Вывод после удаления 2 элемента:");

        for(Person p : people){

            System.out.println(p.getName());
        }
    }
}
class Person{

    private String name;
    public Person(String value){

        name=value;
    }
    String getName(){return name;}
    }
