package ru.geekbrains.polymorphism;
public class Triangle extends Figure {
    void colour(){
        System.out.println("Colour of triangle is orange");
    }

    void form() {
        System.out.println("Form of circle is triangular");
    }

    @Override
    void size() {
        System.out.println("Size of triangle is middle");
    }

    public static void main(String[] args) {
        Figure t = new Triangle();
        t.colour();
        t.form();
        t.size();
    }

}