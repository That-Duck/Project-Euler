package com.company;

import java.util.List;

public class MemoTable {

    private int[][][] table;
    int m;
    int n;
    int o;


    MemoTable(List<String> matrixAsList, int dimensions) {

        m = matrixAsList.size();
        n = matrixAsList.get(m-1).split(" ").length;
        o = dimensions;
        table = new int[m][n][o];

        int num = 0;
        int j = 0;
        String[] numbers;

        for (int i = 0; i < m; i++) {
            numbers = matrixAsList.get(i).split(" ");
            j = 0;
            for (String s : numbers) {
                num = 0;
                for (int k = 0; k < s.length(); k++) {
                    num = num * 10 + (s.charAt(k) - '0');
                }
                table[i][j][0] = num;
                j++;
            }
        }
    }


    public int maximumPathSum() {
        table[0][0][1] = table[0][0][0];

        int layer = 1;
        int num = 0;
        int sum = 0;

        for (int i = 1; i < m; i++) {

            //The first and last elements of a layer only have one
            //possible predecessor.
            table[i][0][1] = table[i-1][0][1] + table[i][0][0];
            table[i][layer][1] = table[i-1][layer-1][1] + table[i][layer][0];

            //Now look at all the other elements in the layer and
            //determine which predecessor is bigger. Add the sum
            //value of the bigger predecessor to the value of the
            //current element to get its sum.
            for (int j = 1; j < layer; j++) {
                if(table[i-1][j-1][1] > table[i-1][j][1]) {
                    sum = table[i-1][j-1][1];
                } else {
                    sum = table[i-1][j][1];
                }
                table[i][j][1] = table[i][j][0] + sum;
            }

            layer++; //Each layer is one element bigger
        }

        for (int j = 0; j < n; j++) {
            if (table[m-1][j][1] > sum) {
                sum = table[m-1][j][1];
            }
        }

        return sum;
    }

}
