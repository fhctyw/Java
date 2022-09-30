package lab2.task4;

import lab2.task2.Task2;
import lab2.task2.University;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Task4 {
    public static void main(final String[] args) {
        final University university = Task2.createUniversity();
        System.out.println(university);
        final Journal journal = new Journal("Laiba Walsh", university);
        journal.changeMarkBySubjectName("Be a Computer", 100);

        System.out.println("all marks all student = ");
        Journal.getAllMarksAllStudents(university).forEach((k, v) -> System.out.println(k.getFullName() + " " + v));
        System.out.println();
        System.out.println("all marks one student = " + Journal.getMarksByStudent(university, "Laiba Walsh"));
        System.out.println();
        System.out.println("all marks one subject = " + Journal.getMarksBySubject(university, "Collecting data"));
    }
}
