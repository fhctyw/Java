package lab2.task3;

import lab2.task2.Group;
import lab2.task2.Subject;
import lab2.task2.Task2;
import lab2.task2.University;
import lab2.task3.service.SubjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task3 {

    public static void main(final String[] args) {

        final University university = Task2.createUniversity();
        System.out.println(university);
        final SubjectService ss = new SubjectService(university);
        ss.addSubject("IT-21", "PE");
        System.out.println(university);

    }
}
