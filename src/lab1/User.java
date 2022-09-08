package lab1;

public class User {

    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public User(final String firstName, final String lastName, final int age, final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public User(final User user) {
        firstName = user.firstName;
        lastName = user.lastName;
        age = user.age;
        email = user.email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return age + (firstName.hashCode()) + (lastName.hashCode()) + (email.hashCode());
    }

    @Override
    public boolean equals(final Object obj) {
        final User u = (User) obj;
        return (firstName.equals(u.firstName) && lastName.equals(u.lastName) && age == u.age && email.equals(u.email));
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
