package lab1;

import java.util.Objects;

public class Room {
    private double area;
    private TypeRoom typeRoom;
    private String color;
    private int numberOfDoors;
    private int numberOfWindows;

    public Room(final double area, final TypeRoom typeRoom, final String color, final int numberOfDoors, final int numberOfWindows) {
        this.area = area;
        this.typeRoom = typeRoom;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.numberOfWindows = numberOfWindows;
    }

    public double getArea() {
        return area;
    }

    public void setArea(final double area) {
        this.area = area;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(final TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(final int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(final int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Room room = (Room) o;
        return Double.compare(room.area, area) == 0 && numberOfDoors == room.numberOfDoors && numberOfWindows == room.numberOfWindows && typeRoom == room.typeRoom && color.equals(room.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, typeRoom, color, numberOfDoors, numberOfWindows);
    }

    public void buildWindow() {
        numberOfWindows++;
    }

    public void destroyWindow() throws Exception {
        numberOfWindows--;
        if (numberOfWindows < 0) {
            throw new Exception("Can not destroy window");
        }
    }

    public void buildDoor() {
        numberOfDoors++;
    }

    public void destroyDoor() throws Exception {
        numberOfDoors--;
        if (numberOfDoors < 0) {
            throw new Exception("Can not destroy window");
        }
    }

    public void paintRoom(final String color) {
        setColor(color);
    }

    public void changeTypeRoom(final TypeRoom type) {
        setTypeRoom(type);
    }

    public void increaseArea(final double area) throws Exception {
        if (area < 0) {
            throw new Exception("area can't be negative");
        }
        setArea(this.area + area);
    }

    public void decreaseArea(final double area) throws Exception {
        if (area < 0) {
            throw new Exception("area can't be negative");
        }
        final var finalArea = this.area - area;
        if (finalArea < 0) {
            throw new Exception("area can't be negative");
        }
        setArea(finalArea);
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", typeRoom=" + typeRoom +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfWindows=" + numberOfWindows +
                '}';
    }
}
