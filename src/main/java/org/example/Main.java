package org.example;

import dao.StudentDAO;
import model.Student;
import util.HibernateSession;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        for (int i = 1; i <= 5; i++) {
            dao.addStudent(new Student(
                    "Student " + i,
                    "student" + i + "@example.com"
            ));
        }

        // Получение всех студентов
        System.out.println("Все студенты:");
        dao.getAllStudents().forEach(System.out::println);

        // Обновление студента
        Student student = dao.getStudentById(2L);
        if (student != null) {
            student.setEmail("new.email@example.com");
            dao.updateStudent(student);
        }

        // Удаление студента
        dao.deleteStudent(3L);

        // Получение одного студента
        System.out.println("\nСтудент с ID 4:");
        System.out.println(dao.getStudentById(4L));

        HibernateSession.shutdown();

    }
}