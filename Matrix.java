package com.company;
import java.util.ArrayList;
import java.util.List;


class Matrix {

    int m;
    int n;
    public int[][] intMatrix;

    Matrix(String matrixAsString) {

        String[] rows = matrixAsString.split("\\n");

        m = rows.length;
        n = rows[0].split(" ").length;
        intMatrix = new int[m][n];

        int num = 0;
        String[] numbers;

        for (int i = 0; i < rows.length; i++) {
            numbers = rows[i].split(" ");
            for (int j = 0; j < numbers.length; j++) {
                num = 0;
                for (int k = 0; k < numbers[j].length(); k++) {
                    num = num * 10 + (numbers[j].charAt(k) - '0');
                }
                intMatrix[i][j] = num;
            }
        }

    }

    Matrix(List<String> matrixAsList) {

        m = matrixAsList.size();
        n = matrixAsList.get(m-1).split(" ").length;
        intMatrix = new int[m][n];

        int num = 0;
        String[] numbers;

        for (int i = 0; i < m; i++) {
            numbers = matrixAsList.get(i).split(" ");
            for (int j = 0; j < numbers.length; j++) {
                num = 0;
                for (int k = 0; k < numbers[j].length(); k++) {
                    num = num * 10 + (numbers[j].charAt(k) - '0');
                }
                intMatrix[i][j] = num;
            }
        }

    }


    int[] getRow(int rowNumber) {
        return intMatrix[rowNumber-1];
    }


    int[] getColumn(int columnNumber) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }


    int getLargestProduct(int len) {
        int largest = 0;
        int product;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n-len; j++) {
                product = 1;
                for (int k = 0; k < len; k++) {
                    product *= intMatrix[i][j+k];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        for (int i = 0; i < m-len; i++) {
            for (int j = 0; j < n; j++) {
                product = 1;
                for (int k = 0; k < len; k++) {
                    product *= intMatrix[i+k][j];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        for (int i = 0; i < m-len; i++) {
            for (int j = 0; j < n-len; j++) {
                product = 1;
                for (int k = 0; k < len; k++) {
                    product *= intMatrix[i+k][j+k];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        for (int i = len-1; i < m; i++) {
            for (int j = 0; j < n-len; j++) {
                product = 1;
                for (int k = 0; k < len; k++) {
                    product *= intMatrix[i-k][j+k];
                }
                if (product > largest) {
                    largest = product;
                }
            }
        }

        return largest;

    }
}