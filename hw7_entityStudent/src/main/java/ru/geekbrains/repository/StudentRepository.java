package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.domain.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class StudentRepository {
    private static final Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    @Inject
    private UserTransaction userTransaction;
    private Student student;


    @Transactional
    public void insert(Student student) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into student(name , age) values (?, ?);")) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.execute();
        }
    }

    @Transactional



    public List<Student> findAll() throws SQLException {
        List<Student> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select * from student");

            while (rs.next()) {
                res.add(new Student(rs.getLong(1), rs.getString(2), rs.getInt(3)));
            }
        }
        return res;
    }

    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Transactional
    public void delete(Student student) {
        em.remove(em.contains(student) ? student : em.merge(student));
    }

    @Transactional
    public Student findById(long id) {
        return em.find(Student.class, id);
    }


    private final Connection conn;

    public StudentRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }




    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists student (id int auto_increment primary key, name varchar (25), name varchar(50), age int);");
        }
    }
}
