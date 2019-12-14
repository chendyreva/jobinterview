package ru.geekbrains.polymorphism;

public class Square extends Figure {
    void colour(){
        System.out.println("Colour of square is black");
    }

    void form() {
        System.out.println("Form of square is square ");
    }

    @Override
    void size() {
        System.out.println("Size of square is big");
    }

    public static void main(String[] args) {
        Figure s = new Square();
        s.colour();
        s.form();
        s.size();
    }

}