package ru.geekbrains.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"ru.geekbrains.cinema"})
@EnableTransactionManagement
public class CinemaApplication {

   public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }
}
