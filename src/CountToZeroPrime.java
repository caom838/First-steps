import java.util.HashMap;

/**
 * Created by schandramouli on 11/3/16.
 */
public class CountToZeroPrime {
    private static HashMap<Integer, Integer> memoizationMap = new HashMap<>();

    int n;

    public CountToZeroPrime(int n) {
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int checkIfPrime() {
        if (n <= 0) {
            return 0;
        }
        int flooredSqrt = ((int) Math.sqrt(n));
        int highestFactor = 0;

        for (int i = 2; i <= flooredSqrt; i++) {
            if (n % i == 0) {
                highestFactor = i;
            }
        }
        return highestFactor;
    }

    public static void main(String[] args) {
        // given a number N, find the min no of steps to make it zero.
        // when at N, if u can factorize N into a, b such that a =/= 1 =/= b,
        // you can do N = max(a,b), else you do N = N - 1
        // so 30 can be 5,6 => n becomes 6, then 6 => 2,3, so n becomes 3, then 3 steps to 0

        CountToZeroPrime countToZeroPrime1 = new CountToZeroPrime(603900);
        int stepCount = 0;

        while (countToZeroPrime1.n != 0) {
            int firstFactor = countToZeroPrime1.checkIfPrime();
            System.out.println(firstFactor);
            if (firstFactor == 0) {
                System.out.println("Unable to factorize");
                System.out.println("Setting " + (countToZeroPrime1.n - 1) + " as the next N");
                countToZeroPrime1.setN(countToZeroPrime1.n - 1);
            } else {
                // means we can get second factor, so start looping here
                int secondFactor = countToZeroPrime1.n / firstFactor;
                System.out.println("First: " + firstFactor +  " Second: " + secondFactor);
                System.out.println("Setting " + Math.max(firstFactor, secondFactor) + " as the next N");
                countToZeroPrime1.setN(Math.max(firstFactor, secondFactor));
            }
            stepCount++;
        }
        System.out.println(stepCount);
    }
}
