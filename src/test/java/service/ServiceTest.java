package service;

import console.UI;
import domain.Grade;
import domain.Homework;
import domain.Student;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import repository.GradeXMLRepository;
import repository.HomeworkXMLRepository;
import repository.StudentXMLRepository;
import validation.GradeValidator;
import validation.HomeworkValidator;
import validation.StudentValidator;
import validation.Validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ServiceTest {

    private static Service serviceBefore;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Homework> homeworkValidator = new HomeworkValidator();
        Validator<Grade> gradeValidator = new GradeValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "students.xml");
        HomeworkXMLRepository fileRepository2 = new HomeworkXMLRepository(homeworkValidator, "homework.xml");
        GradeXMLRepository fileRepository3 = new GradeXMLRepository(gradeValidator, "grades.xml");

        serviceBefore = new Service(fileRepository1, fileRepository2, fileRepository3);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void findAllStudents() {
        Iterable<Student> students = serviceBefore.findAllStudents();
        List<Student> gotStudents = new ArrayList<>();
        students.forEach(gotStudents::add);

        List<Student> expectedStudents = new ArrayList <>();
        expectedStudents.add(new Student("1", "Laci", 234));
        expectedStudents.add(new Student("2", "Maria", 222));
        expectedStudents.add(new Student("4", "Ion", 227));
        expectedStudents.add(new Student("90", "John", 532));


        Assertions.assertEquals(expectedStudents, gotStudents);
    }

    @org.junit.jupiter.api.Test
    void findAllHomework() {
    }

    @org.junit.jupiter.api.Test
    void findAllGrades() {
    }

    @org.junit.jupiter.api.Test
    void saveStudent() {
//        Student s = new Student("90", "John", 532);
//        int result = serviceBefore.saveStudent(s.getID(), s.getName(), s.getGroup());
//        Assertions.assertEquals(result, 0);
//        serviceBefore.deleteStudent("90");
    }

    @org.junit.jupiter.api.Test
    void saveHomework() {
    }

    @org.junit.jupiter.api.Test
    void saveGrade() {
    }

    @org.junit.jupiter.api.Test
    void deleteStudent() {
    }

    @org.junit.jupiter.api.Test
    void deleteHomework() {
    }

    @org.junit.jupiter.api.Test
    void updateStudent() {
    }

    @org.junit.jupiter.api.Test
    void updateHomework() {

    }

    @org.junit.jupiter.api.Test
    void extendDeadline() {
    }

    @org.junit.jupiter.api.Test
    void createStudentFile() {
    }
}