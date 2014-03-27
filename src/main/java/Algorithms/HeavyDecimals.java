package Algorithms;


import org.junit.Assert;

public class HeavyDecimals {

    public static final int LOWER_BOUND = 9480;
    public static final int UPPER_BOUND = 9495;
    public static final double THRESHOLD = 0.7;

    public static void main(String[] args) {
        System.out.println("No. of Heavies:" + getHeavyDecimal(LOWER_BOUND, UPPER_BOUND, THRESHOLD));
    }

    public static int getHeavyDecimal(int lower, int upper, double threshold) {

        Assert.assertTrue(lower < upper && lower > 0);
        Assert.assertTrue(threshold > 0.0 && threshold < 1.0);

        int count = 0;

        //first number
        int length = 1 + (int) (Math.log10(lower));
        int prev = sumDigits(lower);
        //System.out.printf("Sum [%d]: %d -> heavy: %f \n", lower, prev, (float) prev / length);
        if (((float) prev / length) > threshold) count++;

        //rest of the sequence
        ++lower;
        while (lower <= upper) {
            prev = sumDigits(prev, lower);
            length = 1 + (int) (Math.log10(lower));//TODO optimize
            if (((float) prev / length) > threshold) count++;

            //System.out.printf("Sum [%d]: %d -> heavy: %f \n", n, prev, (float) prev / length);
            ++lower;
        }

        return count;
    }

    public static int sumDigits(int prevSum, long n) {
        while (n > 0 && n % 10 == 0) {
            prevSum -= 9;
            n /= 10;
        }
        return prevSum + 1;
    }

    public static int sumDigits(long n) {
        int sum = 0;
        do {
            sum += n % 10;
            n /= 10;
        } while (n > 0);
        return sum;
    }
}
