package lab2.task3.service;

import lab2.task2.University;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateService extends Service {
    public DateService(final University university) {
        super(university);
    }

    public void addDate(final String nameGroup, final String nameSubject, final LocalDate date) {
        getSubjectByName(nameGroup, nameSubject).getDates().add(date);
    }

    public void addDate(final String nameGroup, final String nameSubject, final String date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        addDate(nameGroup, nameSubject, LocalDate.parse(date, formatter));
    }
}
