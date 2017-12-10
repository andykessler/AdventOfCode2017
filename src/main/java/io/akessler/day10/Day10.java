package io.akessler.day10;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day10 {

    private static final String FILE_NAME = "src/main/res/day10/input.txt";

    public static void main(String[] args) {
        String line;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}