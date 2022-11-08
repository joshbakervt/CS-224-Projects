import java.util.Arrays;

public class Homework9_2 {
    public static void printArray(int[][] m) {

        for(int k = 0; k < (m.length); k++) {
            for(int l = 0; l < m[k].length; l++) {
                System.out.format("%4d", m[k][l]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] buildArray(int i, int w) {
        int[][] m = new int[i][w+1];
        for(int j = 0; j < i; j++) {
            for(int k = 0; k < w; k++) {
                m[j][k] = 0;
            }
        }
        return m;
    }

    public static int knapsack(int[][] m, int[] values, int[] weights, int w) {
        int n = weights.length;
        for(int i = 1; i < n; i++) {
            for(int w0 = 0; w0 <= w; w0++) {
                if(weights[i] > w0) {
                    m[i][w0] = m[i-1][w0];
                }
                else {
                    m[i][w0] = Math.max( (m[i-1][w0]) , (values[i] + m[i-1][w0 - weights[i]]));
                }
            }
            printArray(m);
        }
        System.out.println("Finding optimal solution...");
        int j = m[n-1][w];
        // Start at greatest values, solution
        // Input table, i, w
        int[] solution = findSolution(m, j, (n-1), w);
        System.out.println("Solution: [" + solution[0] + ", " + solution[1] + "]");
        return j;
    }

    public static int[] findSolution(int[][] m, int j, int n, int w) {
        int[] returnVal = new int[2];
        if(m[n][w] < j) {
            returnVal[0] = -1;
            returnVal[1] = -1;
            return returnVal;
        }
        if(findSolution(m, j, (n-1), w)[0] == -1) {
            // We know we're at the first occurrence
            returnVal[0] = n-1;
            returnVal[1] = n;
            return returnVal;
        }
        else {
            return(findSolution(m, j, (n-1), w));
        }
    }
    public static void main(String[] args) {
        // Initialize, values, weights
        int[] values = new int[]{0, 1, 6, 18, 22, 28};
        int[] weights = new int[]{0, 1, 2, 5, 6, 7};
        // Initialize an array of size i x w
        int i = values.length;

        int w1 = 10;
        int[][] m10 = buildArray(i, w1);
        // Print the initial array for all rows
        System.out.println("Running knapsack problem with constraint W = 10");
        printArray(m10);
        int returnVal = knapsack(m10, values, weights, w1);
        System.out.println(returnVal);

        int w2 = 11;
        int[][] m11 = buildArray(i, w2);
        // Print the initial array for all rows
        System.out.println("Running knapsack problem with constraint W = 11");
        printArray(m11);
        returnVal = knapsack(m11, values, weights, w2);
        System.out.println(returnVal);
    }
}
