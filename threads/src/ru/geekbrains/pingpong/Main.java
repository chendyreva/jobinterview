package ru.geekbrains.pingpong;

public class Main {
    int steps = 20;
    public static void main(String[] args) {
        PingPong pingPong1 = new PingPong();
        PingPong pingPong2 = new PingPong();
        Thread thread1 = new Thread(pingPong1);
        Thread thread2 = new Thread(pingPong2);
        thread1.start();
        thread2.start();
    }
}