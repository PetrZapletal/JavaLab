package Pyramid.solver.impl;

import Pyramid.data.Pyramid;
import Pyramid.solver.PyramidSolver;

/**
 * Main problem with NaivePyramideSolver implementation is that
 * all overlapping paths through the pyramid must be evaluated. 
 * Therefore, NaivePyramideSolver has exponential complexity in time,
 * 2^n solutions must be tested, where n is number of rows.
 */

/**
 * YourSolver is implemented as a typical example of 'dynamic programming'.
 * 
 * Algorithm works this way
 * 
 * Start with pyramid below
 * 
 *	[00059] [00207] [00098] [00095] 
 *	    [00087] [00001] [00070] 
 *	        [00036] [00041] 
 *	            [00023] 
 * 
 * First row is reduced, larger value of all tuples are added to path element underneath.
 * 
 *	[00059] [00207] [00098] [00095] 
 *	    [00294] [00208] [00168] -> 294 = 87 + Max(59, 207), ...
 *	        [00036] [00041] 
 *	            [00023] 
 * 
 * After few iterations the pyramid looks like:
 * 
 * [00059] [00207] [00098] [00095] 
 *   [00294] [00208] [00168] 
 *       [00330] [00249] 
 *           [00353] -> maximum path
 *
 *  And maximum path is stored in the peak element.
 *  Algorithm reuses input data structure, but can be easily modified not to do that.
 *  Algorithm has linear complexity which is major improvement in comparison to 
 *  NaivePyramideSolver implementation.
 */


public class YourSolver implements PyramidSolver {

	@Override
	public long pyramidMaximumTotal(Pyramid pyramid) {
		for (int i = 0; i < pyramid.getRows(); i++) {
			for (int j = 0; j < pyramid.getRows() - 1 - i; j++) {
				int val = Math.max(pyramid.get(i, j), pyramid.get(i, j + 1));
				pyramid.set(i + 1, j, pyramid.get(i + 1, j) + val);
			}
		}
		return pyramid.get(pyramid.getRows() - 1, 0);
	}
}
