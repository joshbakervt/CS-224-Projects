public class Homework9 {

    public static void knapsack(int[] items, int[] values, int[] weights, int w) {
        // Global array: M[0...n][0..W]
        int n = weights.length;
        int[][] m = new int[n][w];

        // Initialize all values in m to 0
        for(int i = 0; i < w; i++) {
            m[0][i] = 0;
        }

        System.out.print("Array: ");
        for(int i = 0; i < w; i++) {
            System.out.print(m[0][i] + ", ");
        }
        System.out.println();

        // For all columns in array,
//        for(int i = 1; i < n; i++) {
//            // Until weight is full
//            for(int w0 = 0; w0 < w; w0++) {
//                if(weights[i] > w0) {
//                    System.out.println(weights[i] + " larger than " + w);
//                    // M[i, w] = M[i-1, w]
//                    m[i][w0] = m[i-1][w0];
//                }
//                else {
//                    System.out.println(weights[i] + " not larger than " + w);
//                    System.out.println("Setting m[" + i + ", " + w + "] to the ");
//                    System.out.println("max of " + m[i-1][w0] + " and " + values[i] + " + " + m[i-1][w0-weights[w0]]);
//                }
//            }
//        }
//        System.out.println("Iterating from i = 1 to n=" + n);
        for(int i = 0; i < n; i++) {
//            System.out.println("Iterating from w = 0 to " + w);
            for(int w0 = 0; w0 < w; w0++) {
//                System.out.println(i + ", " + w0);
//                System.out.println("Checking if weights[" + i + "] (" + weights[i] + ") is greater than " + w0);
                if(weights[i] > w0) {
//                    System.out.println("It is");
//                    System.out.println("Setting m[" + i + ", " + w0 + "] to m[" + (i-1) + ", " + w0 + "]");
//                    System.out.println("(aka setting " + m[i][w0] + " to " + m[i-1][w0] + ")");
                    if(i >= 1) {
                        m[i][w0] = m[i - 1][w0];
                    }
                    else {
                        m[i][w0] = m[0][w0];
                    }
//                    else {
//                        m[i][w0] = m[i - 1][w0];
//                    }
                }
                else {
//                    System.out.println("It is not");
//                    System.out.println("Setting m[" + i + ", " + w0 + "] to max(m[" + (i-1) + ", " + w0 + "], (" + values[i] + " + m[" + (i-1) + ", " + (w0 - weights[i])  + ")");
                    if(i >= 1) {
                        m[i][w0] = Math.max((m[i-1][w0]), (values[i] + (m[i-1][w0-weights[i]])));
                    }
                    else {
                        m[i][w0] = Math.max((m[i][w0]), (values[i] + (m[i][w0-weights[i]])));
                    }
                }
//                System.out.println("\n");
            }
            System.out.println("------------ PRINTING ARRAY ------------");
            for(int k = 0; k < (m[i].length); k++) {
                System.out.print(k + ", ");
            }
            System.out.println(m[i].length);
            for(int k = 0; k < (m[i].length-1); k++) {
                System.out.print(m[i][k] + ", ");
            }
            System.out.println(m[i][m.length-1]);
        }
//        System.out.println("1 to " + n);
//        for(int i = 1; i < n; i++) {
//            System.out.println("i : " + i);
//            for(int j = 0; j < w; j++) {
//                if(weights[i] > w) {
//                    System.out.println(weights[i] + " > " + w);
//                    System.out.println("Setting M[" + i +", " + j + "to M" + (i-1) + ", " + "j");
//                }
//            }
//        }

        // Given n items and a knapsack
        // s.t. item i weights wi > 0
        // and has value vi > 0
        // and the knapsack has the capacity of a total weight 0

        // Output the content of the memoization table M[0..n][0..W] each time
        // a row is filled

        // At the end of the program execution, output the items included in the
        // optimal set using post-processing

        // Post-processing: Trace the array M[0..n][0..W] backward recursively
        // starting with the last element M[n][W]

//        for w = 0 to W {
//            M[0, w] =w
//        }
//        for i = 1 to n {
//            for w = 0 to W {
//                if (wi > w) {
//                    M[i, w] =M[i - 1, w]
//                } else {
//                    M[i, w] =max(M[i - 1, w],
//                    vi + M[i - 1, w - wi])
//                }
//            }
//        }
        // When row is filled, output the content of the table

        // At the end of the program, output the items included
        // in the optimal set and the resulting maximum total value

        // Finding the optimal set
//         Find-Solution(j) {
//             if (j = 0) {
//                 return
//             }
//             else if (vj + M[p(j)] > M[j-1]) {
//                 output j;
//                 Find-Solution(p(j))
//             }
//             else {
//                 Find-Solution(j-1);
//             }
//        }


        // Of the included items

    }
    public static void main(String[] args) {
        // Program should output the items included in the optimal
        // set and the resulting maximum total value of the items
        // included
        int[] items = new int[]{1, 2, 3, 4, 5};
        int[] values = new int[]{1, 6, 18, 22, 28};
        int[] weights = new int[]{1, 2, 5, 6, 7};

        System.out.println("Running knapsack algorithm with W = 10");
        knapsack(items, values, weights, 10);

        System.out.println("Running knapsack algorithm with W = 11");
        knapsack(items, values, weights, 11);

    }
}
