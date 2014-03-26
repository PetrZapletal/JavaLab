package Pyramid;

import Pyramid.data.Pyramid;
import Pyramid.data.PyramidGenerator;
import Pyramid.data.impl.RandomPyramidGenerator;
import Pyramid.solver.PyramidSolver;
import Pyramid.solver.impl.NaivePyramidSolver;

/**
 * TASK: This is your 1st task. Please look at the
 * {@link Pyramid.solver.impl.NaivePyramidSolver} and
 * <ul>
 * <li>describe or fix the bugs and problems. Comment your changes.
 * <li>describe or implement test scenarios you need to prove its correctness.
 * </ul>
 */
public class OurProgram {

	/**
	 * This doesn't get the correct number
	 */
	public static void main(String[] args) {
		final PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
		final Pyramid pyramid = generator.generatePyramid();

		System.out.println(pyramid);

		final PyramidSolver solver = new NaivePyramidSolver();

		// System.out.println("This result is wrong, do you know why ?");
		System.out.println(solver.pyramidMaximumTotal(pyramid));

		System.out.println();
	}
}