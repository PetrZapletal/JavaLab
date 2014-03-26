package Pyramid.solver.impl;

import Pyramid.data.Pyramid;
import Pyramid.solver.PyramidSolver;

public class NaivePyramidSolver implements PyramidSolver {
	@Override
	public long pyramidMaximumTotal(Pyramid pyramid) {
		return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
	}

	private long getTotalAbove(int row, int column, Pyramid pyramid) {
		
		/**
		 * Recursion stopping condition was incorrect. For last row 
		 * algorithm returns zero instead of real value. This change ensures 
		 * that correct value is returned.
		 */		
		
		int myValue = pyramid.get(row, column);
		
		if (row == 0)
			return myValue;
		
		long left = myValue + getTotalAbove(row - 1, column, pyramid);
		long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);

		return Math.max(left, right);
	}
}