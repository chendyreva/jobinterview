package ru.geekbrains.threadsafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
        private Lock lock = new ReentrantLock();
        private int count = 0;

        public int increment () {
            lock.lock();
            try {
                return ++count;
            } finally {
                lock.unlock();
            }
        }
    }
