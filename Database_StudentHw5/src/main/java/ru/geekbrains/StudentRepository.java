package ru.geekbrains;

import ru.geekbrains.entities.Student;

public class StudentRepository extends DaoRepository<Student, Long> {
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
