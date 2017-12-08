package io.akessler.day1;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {

    private static final String FILE_NAME = "src/main/res/day1/input.txt";

    public static void main(String[] args) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine(); // only reading the first line here
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println(String.format("Puzzle 1 : %d", puzzle1(line)));
        System.out.println(String.format("Puzzle 2 : %d", puzzle2(line)));
    }

    public static int puzzle1(String input) {
        int sum = 0;
        char prev = input.charAt(input.length()-1);
        for(int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if(curr == prev) {
                sum += (curr - '0'); // 48...57 (0...9)
            }
            prev = curr;
        }
        return sum;
    }

    public static int puzzle2(String input) {
        int sum = 0;
        int len = input.length();
        int mid = len / 2; // assume even number length
        for(int i = 0; i < input.length(); i++) {
            char half = input.charAt((i+mid) % len);
            char curr = input.charAt(i);
            if(curr == half) {
                sum += (curr - '0'); // 48...57 (0...9)
            }
        }
        return sum;
    }
}