package lab2.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task2 {
    public static University createUniversity() {

        final List<Group> groups = new ArrayList<>();
        final String groupName1 = "AN-11";
        final String spec1 = "Analyst";
        final List<Student> students1 = Stream.of(
                new Student("Makayla Obrien", spec1, groupName1),
                new Student("Yousuf Alexander", spec1, groupName1),
                new Student("Mariam Almond", spec1, groupName1),
                new Student("Amar Bird", spec1, groupName1)
        ).collect(Collectors.toList());
        groups.add(new Group(groupName1, students1, Stream.of(
                new Subject("Data Analyse", new HashMap<Student, Integer>(){{
                    put(students1.get(0), 30);
                    put(students1.get(1), 45);
                    put(students1.get(2), 40);
                    put(students1.get(3), 40);
                }}, Stream.of(
                        LocalDate.of(2022, 9, 6),
                        LocalDate.of(2022, 9, 9)
                    ).collect(Collectors.toList())
                ),
                new Subject("Collecting data", new HashMap<Student, Integer>(){{
                    put(students1.get(0), 33);
                    put(students1.get(1), 46);
                    put(students1.get(2), 41);
                    put(students1.get(3), 50);
                }}, Stream.of(
                        LocalDate.of(2022, 9, 6),
                        LocalDate.of(2022, 9, 9)
                ).collect(Collectors.toList())),
                new Subject("Physical Education", new HashMap<Student, Integer>(){{
                    put(students1.get(0), 60);
                    put(students1.get(1), 64);
                    put(students1.get(2), 80);
                    put(students1.get(3), 35);
                }}, Stream.of(
                        LocalDate.of(2022, 9, 10),
                        LocalDate.of(2022, 9, 20)
                ).collect(Collectors.toList())
                )
        ).collect(Collectors.toList())
        ));

        final String groupName2 = "IT-21";
        final String spec2 = "Information systems and technologies";
        final List<Student> students2 = Stream.of(
                new Student("Edgar Frank", spec2, groupName2),
                new Student("Taliyah Riddle", spec2, groupName2),
                new Student("Laiba Walsh", spec2, groupName2),
                new Student("Gladys Pugh", spec2, groupName2)
        ).collect(Collectors.toList());
        groups.add(new Group(groupName2, students2, Stream.of(
                new Subject("Be a Computer", new HashMap<Student, Integer>(){{
                    put(students2.get(0), 99);
                    put(students2.get(1), 46);
                    put(students2.get(2), 60);
                    put(students2.get(3), 70);
                }}, Stream.of(
                        LocalDate.of(2022, 9, 2),
                        LocalDate.of(2022, 9, 12),
                        LocalDate.of(2022, 9, 14)
                        ).collect(Collectors.toList())
                ),
                new Subject("Java Enjoyers", new HashMap<Student, Integer>(){{
                    put(students2.get(0), 100);
                    put(students2.get(1), 100);
                    put(students2.get(2), 100);
                    put(students2.get(3), 100);
                }}, Stream.of(
                        LocalDate.of(2022, 9, 2),
                        LocalDate.of(2022, 9, 13)
                ).collect(Collectors.toList()))
        ).collect(Collectors.toList())
        ));

        /*final String groupName2 = "AN-12";
        final List<Student> students2 = Stream.of(
                new Student("Kamron Burnett", spec1, groupName2),
                new Student("Mohsin Leblanc", spec1, groupName2),
                new Student("Pearce Devine", spec1, groupName2),
                new Student("Traci Pace", spec1, groupName2)
        ).toList();

        groups1.add(new Group(groupName2, students2, Stream.of(
                new Subject("Data Analyse", new HashMap<>(){{
                    put(students2.get(0), 30);
                    put(students2.get(1), 45);
                    put(students2.get(2), 40);
                    put(students2.get(3), 40);
                }}, new ArrayList<>()),
                new Subject("Collecting data", new HashMap<>(){{
                    put(students2.get(0), 33);
                    put(students2.get(1), 46);
                    put(students2.get(2), 41);
                    put(students2.get(3), 50);
                }}, new ArrayList<>()),
                new Subject("Providing consultations", new HashMap<>(){{
                    put(students2.get(0), 30);
                    put(students2.get(1), 45);
                    put(students2.get(2), 40);
                    put(students2.get(3), 40);
                }}, new ArrayList<>())).toList()
        ));*/

        return new University("Quinnipiac University", groups);
    }

    public static void main(final String[] args) {
        final University university = createUniversity();
        System.out.println(university);
    }
}
