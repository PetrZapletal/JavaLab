package Pyramid;

import org.junit.Assert;
import org.junit.Test;

import Pyramid.solver.PyramidSolver;

import Pyramid.data.Pyramid;
import Pyramid.data.PyramidGenerator;
import Pyramid.data.impl.RandomPyramidGenerator;
import Pyramid.solver.impl.NaivePyramidSolver;
import Pyramid.solver.impl.YourSolver;

public class YourSolverTest {
	
    @Test    
    /*
     * Simple test with known pyramid and known result. 
     */
    public void testPyramidMaximumTotal() {
    {
            final PyramidSolver solver = new YourSolver();
            final Pyramid pyramid = new Pyramid(new int [][]
                {
                    {  59,  207,   98, 95},
                    {  87,    1,   70,  0},
                    {  36,   41,    0,  0},
                    {  23,    0,    0,  0},
                });

            final long total = solver.pyramidMaximumTotal(pyramid);
            System.out.println(pyramid);
            System.out.println();
            System.out.printf("Total:    %d\n", total);
            System.out.printf("Expected: %d\n", 353);
            System.out.println();
            Assert.assertEquals(353, total);
        }
    }
    
    @Test
    /*
     * Tests if algorithm is able to avoid local optimum.  
     */
    public void testGreedyAlgorithm(){
        final PyramidSolver solver = new YourSolver();
        final Pyramid pyramid = new Pyramid(new int [][]
            {
                {  1,  1,   100},
                {  2,  1,   0},
                {  1,  0,   0}
            });

        final long total = solver.pyramidMaximumTotal(pyramid);
        System.out.println(pyramid);
        System.out.println();
        System.out.printf("Total:    %d\n", total);
        System.out.printf("Expected: %d\n", 102);
        System.out.println();
        Assert.assertEquals(102, total);    	
    }
    
    @Test
    /*
     * Comparison of both implementations. Results are compared and elapse time is counted.  
     */
    public void testSolverComparison(){
        final PyramidSolver bruteForceSolver = new NaivePyramidSolver();
        final PyramidSolver dynamicSolver = new YourSolver();

        final PyramidGenerator generator = new RandomPyramidGenerator(30, 10000);
        final Pyramid pyramid = generator.generatePyramid();
        
        long startTime = System.nanoTime();
        final long bruteForceTotal = bruteForceSolver.pyramidMaximumTotal(pyramid);
        
        System.out.println("Naive Pyramide Solver");
        System.out.printf("Total:    %d\n", bruteForceTotal);
        System.out.printf("Nanos:    %d\n", System.nanoTime() - startTime);
        System.out.println();
        
		startTime = System.nanoTime();
        final long dynamicTotal = dynamicSolver.pyramidMaximumTotal(pyramid);
        
        System.out.println("Dynamic Pyramide Solver");
        System.out.printf("Total:    %d\n", dynamicTotal);
        System.out.printf("Nanos:    %d\n", System.nanoTime() - startTime);
        System.out.println();      
        
        Assert.assertEquals(bruteForceTotal, dynamicTotal);
    }
}
