package lab1;

public class Task6 {

	public static void DisplayLogic(final User user) {
		System.out.println("hashCode of " + user + " = " + user.hashCode());
		final User copy = new User(user);
		System.out.println("equals of copy = " + user.equals(copy));
		final User notCopy = new User(new User("Arsen", "Lisnychuk", 18, "lisnychukarsenw@gmail.com"));
		System.out.println("equals of not copy = " + user.equals(notCopy));
	}

	public static void main(final String[] args) {
		final User user = new User("arsen", "Lisnychuk", 18, "lisnychukarsenw@gmail.com");
		DisplayLogic(user);
	}


}
