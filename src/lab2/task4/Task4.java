package lab2.task4;

import lab2.task2.Task2;
import lab2.task2.University;

public class Task4 {
    public static void main(final String[] args) {
        final University university = Task2.createUniversity();
        System.out.println(university);
        final Journal journal = new Journal("Laiba Walsh", university);
        journal.changeMarkBySubjectName("Be a Computer", 100);

        System.out.println("all marks all student = " + Journal.getAllMarksAllStudents(university));
        System.out.println("all marks one student = " + Journal.getMarksByStudent(university, "Laiba Walsh"));
        System.out.println("all marks one subject = " + Journal.getMarksBySubject(university, "Collecting data"));
    }
}
