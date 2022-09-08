package lab1;

import java.util.List;

public class Task10 {

    public static void main(final String[] args) throws Exception {

        final House house = new House(List.of(
                new Room(3.5, TypeRoom.LIVING_ROOM, "Blue", 2, 1),
                new Room(2.5, TypeRoom.KITCHEN, "White", 3, 2),
                new Room(4, TypeRoom.BEDROOM, "White", 1, 2),
                new Room(1, TypeRoom.RESTROOM, "Gray", 1, 0),
                new Room(3, TypeRoom.CHILD_ROOM, "Pink", 1, 1)
        ), "Shevchenko 5");

        System.out.println(house);
        System.out.println("Start building");
        house.getRooms().get(4).paintRoom("Light gray");
        System.out.println("paint room");
        house.getRooms().get(4).increaseArea(0.2);
        System.out.println("increase area of room");
        house.getRooms().get(4).buildWindow();
        System.out.println("build a new window");
        System.out.println("End building");
        System.out.println(house);
    }

}
