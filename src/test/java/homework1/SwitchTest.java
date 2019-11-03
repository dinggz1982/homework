package homework1;

public class SwitchTest {

	public static void main(String[] args) {

		String method = "delete11";
		switch (method) {
		case "add":
			System.out.println("add method");
			break;
		case "delete":
			System.out.println("delete method");
			break;
		case "edit":
			System.out.println("edit method");
			break;
		default:
			System.out.println("default method");
			break;
		}

	}
}
