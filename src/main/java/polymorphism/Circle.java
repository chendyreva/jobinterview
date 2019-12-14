package main.java.polymorphism;

public class Circle extends Figure {
    void colour(){
        System.out.println("Colour of circle is red");
    }

    void form() {
        System.out.println("Form of circle is round");
    }

    public static void main(String[] args) {
        Figure c = new Circle();
        c.colour();
        c.form();
    }

}
