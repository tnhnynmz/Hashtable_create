
import java.util.Scanner;

public class Menu {
	public Scanner sc = new Scanner(System.in);
	public float loadFactor() {
		System.out.print("Please Select Load Factor :" + "\n1-)0.5" + "\t2-)0.7" + "\n");
		float loadFactor = 0;
		String input;
		while (loadFactor == 0) {
			input = sc.nextLine();
			if (input.equals("1"))
				loadFactor = 0.5f;
			else if (input.equals("2"))
				loadFactor = 0.7f;
			else
				System.out.println("You Can Choose Either 1 or 2...");
		}
		return loadFactor;
	}
	public int function() {
		System.out.print("Please Select Hash Function :" + "\n1-)YHF" + "\t2-)PAF" + "\n");
		String input;
		int function = -1;
		while (function == -1) {
			input = sc.nextLine();
			if (input.equals("1"))
				function = 1;
			else if (input.equals("2"))
				function = 2;
			else
				System.out.println("You Can Choose Either 1 or 2...");
		}
		return function;
	}
}
