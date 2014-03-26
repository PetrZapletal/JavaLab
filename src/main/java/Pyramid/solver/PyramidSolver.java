package Pyramid.solver;

import Pyramid.data.Pyramid;

/**
 *  Represents the API of a problem solver.
 *  Refer to {@link Pyramid.data.Pyramid} for problem description.
 */
public interface PyramidSolver {
    long pyramidMaximumTotal(Pyramid pyramid);
}
