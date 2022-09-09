package lab2.task3;

import lab2.task2.Task2;
import lab2.task2.University;
import lab2.task3.service.DateService;
import lab2.task3.service.OutputConsoleService;
import lab2.task3.service.SubjectService;

import java.time.LocalDate;

public class Task3 {

    public static void main(final String[] args) {

        final University university = Task2.createUniversity();
        System.out.println(university);

        final SubjectService subjectService = new SubjectService(university);
        subjectService.addSubject("IT-21", "Physical Education");
        System.out.println(university);

        final DateService dateService = new DateService(university);
        dateService.addDate("IT-21", "Physical Education", "12.09.2022");
        System.out.println(university);

        final OutputConsoleService consoleService = new OutputConsoleService(university);
        consoleService.displayGroupStudentsByName("AN-11");
        System.out.println();
        consoleService.displayStudentsBySubject("Physical Education");
        System.out.println();
    }
}
