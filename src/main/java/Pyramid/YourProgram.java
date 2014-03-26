package Pyramid;

import Pyramid.data.Pyramid;
import Pyramid.data.PyramidGenerator;
import Pyramid.data.impl.RandomPyramidGenerator;
import Pyramid.solver.PyramidSolver;
import Pyramid.solver.impl.YourSolver;

public class YourProgram {
    public static void main(String[] args) {
        // let's have bigger data
        final PyramidGenerator generator = new RandomPyramidGenerator(1000, 10000);
        final Pyramid pyramid = generator.generatePyramid();
        
        //System.out.println(pyramid);

        final PyramidSolver solver = new YourSolver();

        System.out.println("Maximum path sum for this pyramid is :");
        System.out.println(solver.pyramidMaximumTotal(pyramid));
    }
    
}
