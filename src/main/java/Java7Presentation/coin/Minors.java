package Java7Presentation.coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Minors {

	public class ExceptionalClass {
		public void doSomething() throws ArithmeticException, IOException,
				IndexOutOfBoundsException {
			return;
		}
	}

	public class SwitchClass {
		public final String[] days = { "Mon", "Tue", "Wed" };

		public void doSomething() {

			String day = days[getRnd()];

			switch (day) {
			case "Mon":
				System.out.println("Monday");
				break;
			case "Tue":
				System.out.println("Tuesday");
				break;
			case "Wed":
				System.out.println("Wednesday");
				break;
			}
		}

		private Integer getRnd() {
			return new Random().nextInt(days.length);
		}
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Minors outer = new Minors();
		ExceptionalClass ec = outer.new ExceptionalClass();

		try {
			ec.doSomething();
		} catch (ArithmeticException | IndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SwitchClass sc = outer.new SwitchClass();
		for (int i = 0; i < 5; ++i)
			sc.doSomething();

		// Diamond operator
		List<String> l1 = new ArrayList<String>();
		List<List<List<Object>>> l2 = new ArrayList<List<List<Object>>>();

		// -->
		List<String> l3 = new ArrayList<>();
		List<List<List<Object>>> l4 = new ArrayList<>();

		// --??-->
		// var l5 = new ArrayList<String> ...
	}

}
