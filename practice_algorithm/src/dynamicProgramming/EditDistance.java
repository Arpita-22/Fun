package dynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println("horse");
        System.out.println(minDistance("horse", "ros"));

    }

    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if(n1 == 0 && n2 == 0) {
            return n1;
        }

        if(n1 == 0) {
            return n2;
        }

        if(n2 == 0) {
            return n1;
        }

        int [][] memo = new int[n1 + 1][n2 + 1];


        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if(i == 0) {
                    memo[i][j] = j;
                }else if (j == 0) {
                    memo[i][j] = i;
                }else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    int replace = memo[i - 1][j - 1];
                    int insert = memo[i][j - 1];
                    int delete = memo[i - 1][j];

                    memo[i][j] = 1 + Arrays.stream(new int[] {replace, insert, delete}).min().getAsInt();
                }
            }
        }

        return memo[n1][n2];

    }
}
