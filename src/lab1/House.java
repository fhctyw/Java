package lab1;

import java.util.List;
import java.util.Objects;

public class House {
    private List<Room> rooms;
    private String address;

    public House(final List<Room> rooms, final String address) {
        this.rooms = rooms;
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(final List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (final var room : rooms) {
            builder.append(room).append('\n');
        }
        builder.deleteCharAt(builder.length()-1);
        return "address='" + address + "'\n" + builder;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final House house = (House) o;
        return Objects.equals(rooms, house.rooms) && Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, address);
    }
}
