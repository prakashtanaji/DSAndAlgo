class firstoddnumbersum {
    public static void main(String[] args) {
        /*
        Given an integer n (where n ≤ 1000), return the sum of the first n positive odd integers.
        */
        // Brute Force way is start from 1 and parse until n. At each step increase the counter by 2 
        // and add to sum.
        // Time Complexity is O(n) have to iterate though each item once.
        // Space Complexity is O(1). variable needed to maintain counter and sum variable

        // Optimized solution is O(1)
        // Given n = 2
        // If you were asked to find the sum of all the number until 2 x n = 4, its 4(4+1)/2 = 10
        // 1       2       3       4     but from this series you need just the odd numbers. If you notice
        // 1      (1+1)    3       (3+1) This is same as double of odd number and substract n
        // Hence just find [2n(2n+1)/2] - n

        int n = 45;

        // Assume there is no interger overflow
        int sum = ((2 * n*(2*n +1)/2) - n)/2;
        System.out.println("Sum of odd numbers is " + sum);

        // Burte Force way

        int result = 0;
        int counter = 1;
        for(int i=0; i<n; i++) {
            result+=counter;
            counter +=2;
        }

        System.out.println("Sum of odd numbers(Bruter force) is " + result);
    }
}