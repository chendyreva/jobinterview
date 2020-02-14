package ru.geekbrains.listener;

import ru.geekbrains.domain.Student;
import ru.geekbrains.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {

    public static final String DB_CONNECTION = "dbConnection";
    public static final String STUDENT_REPO = "student_repository";

    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initializing application");

        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String username = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            Connection conn = DriverManager.getConnection(jdbcConnectionString, username, password);
            sc.setAttribute(DB_CONNECTION, conn);

            StudentRepository studentRepository = new StudentRepository(conn);
            sc.setAttribute(STUDENT_REPO, studentRepository);

            if (studentRepository.findAll().isEmpty()) {
                studentRepository.insert(new Student(null, "Max",  17));
            }
        } catch (SQLException ex) {
            logger.error("", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}