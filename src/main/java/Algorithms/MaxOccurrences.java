package Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petr on 30.3.14.
 */
public class MaxOccurrences {
    public static void main(String... args) {
        int A[] = new int[]{5, 4, 7, 4, 2, 7, 7};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 7

        Map<Integer, Integer> countStorage = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; ++i) {
            //System.out.println(A[i]);

            if (!countStorage.containsKey(A[i])) {
                countStorage.put(A[i], 1);
            } else {
                Integer count = countStorage.get(A[i]);
                countStorage.put(A[i], ++count);
            }
        }

        int maxKey = 0;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : countStorage.entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());

            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
