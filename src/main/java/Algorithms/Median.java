package Algorithms;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by petr on 30.3.14.
 */

/*
 * Computes median array-style
 */
public class Median {

    public static void main (String ... args){
        int A[] = new int[] {5, 4 ,7 ,4 ,2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 7

        TreeSet<Integer> sortedInput = new TreeSet<Integer>();

        for(int i = 0; i < A.length; ++i){
            //System.out.println(A[i]);
            sortedInput.add(A[i]);
        }

        int index;
        if(A.length % 2 == 0){
            index = A.length /2;
        } else {
            index = (A.length - 1) / 2;
        }

        Iterator<Integer> iter = sortedInput.iterator();
        int currIdx = 0;
        Integer median = new Integer(-1);

        while(iter.hasNext() && currIdx < index){
            median = iter.next();
            ++currIdx;
        }

        return median;
    }
}
