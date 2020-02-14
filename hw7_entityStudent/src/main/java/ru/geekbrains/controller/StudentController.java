package ru.geekbrains.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.domain.Student;
import ru.geekbrains.repository.StudentRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class StudentController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Inject
    private StudentRepository studentRepository;

    private Student student;

    private List<Student> students;

    public void preLoadStudents(ComponentSystemEvent componentSystemEvent) throws SQLException {
        this.students = studentRepository.findAll();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public String createStudent() {
        this.student = new Student();
        return "/student.xhtml?faces-redirect=true";
    }

    public String saveStudent() throws SQLException {
        if (student.getId() == null) {
            studentRepository.insert(student);
        } else {
            studentRepository.update(student);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public String editStudent(Student student) {
        this.student = student;
        return "/student.xhtml?faces-redirect=true";
    }
}