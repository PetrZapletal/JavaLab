package Algorithms;

//Complexity O(n^2)
public class MaximumAdjacent {

    public static void main(String[] argv) {

        int[] a = {4, 2, 0, 1, 5, 7};

        int storeA = 0, storeB = 0;

        //int[] a = {-5, 9, 8, 3, 2, -3, 2 ,20 ,4 ,5 ,6 ,7 ,8 , 10};
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + ", ");
        }

        System.out.println();

        int max = 0;

        for (int i = 0; i < a.length - 1; ++i) {
            boolean isAdjacent = false;
            //System.out.println("base: " + a[i]);

            if (a[i] < a[i + 1]) {
                int j = i + 1;
                while (j < a.length){

                    //System.out.printf("i:%d j:%d\n", i , j);

                    //LF 1st vec change
                    if(!isAdjacent && a[j - 1] > a[j]){
                        isAdjacent = true;
                    }

                    if(isAdjacent){ //count delta
                        int delta = StrictMath.abs(a[i] - a[j]);
                        System.out.printf("[%d][%d]:%d\n", a[i], a[j], delta);
                        if(max < delta) {
                            max = delta;
                            storeA = a[i];
                            storeB = a[j];
                        }
                    }
                    ++j;
                }
            } else if (a[i] > a[i + 1]) {
                int j = i + 1;
                while (j < a.length){
                    //LF 1st vec change
                    if(!isAdjacent && a[j - 1] < a[j]){
                        isAdjacent = true;
                    }

                    if(isAdjacent){ //count delta
                        int delta = StrictMath.abs(a[i] - a[j]);
                        System.out.printf("[%d][%d]:%d\n", a[i], a[j], delta);
                        if(max < delta) {
                            max = delta;
                            storeA = a[i];
                            storeB = a[j];
                        }
                    }
                    ++j;
                }
            } else {
                ++i;
            }
        }

        System.out.printf("MaxAdj[%d][%d] -> %d", storeA, storeB, max);
    }
}