package ru.geekbrains.pingpong;

class PingPong implements Runnable {

    private static String value = "ping";
    private int steps = 10;
    static Object obj = new Object();

    public void run(){
        try {
            while (steps != 0){
                synchronized (obj){
                    System.out.println(value);
                    changeValue();
                    obj.notify();
                    obj.wait();
                }
                steps--;
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void changeValue(){
        if (value.equals("ping")) {
            value = "pong";
        }else
            value = "ping";
    }
}

