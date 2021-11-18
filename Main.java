package com.company;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.File;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Scanner input = null;
        ArrayList<String> matrixLines = new ArrayList<String>();
        String newLine = null;

        try {
            input = new Scanner( new BufferedReader( new FileReader("P67.txt")));

            while( input.hasNext() ) {
                matrixLines.add(input.nextLine());
            }

        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();

        } finally {
            if (input != null) {
                input.close();
            }
        }

        MemoTable table = new MemoTable(matrixLines,2);
        System.out.println(table.maximumPathSum());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
