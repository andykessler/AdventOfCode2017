package io.akessler.day01;

import io.akessler.AdventUtility;

public class Day1 {

    public static void main(String[] args) {

        String line = AdventUtility.readInput(1).get(0);

        int answer1 = puzzle1(line);
        int answer2 = puzzle2(line);

        System.out.println(String.format("Puzzle 1 : %d", answer1));
        System.out.println(String.format("Puzzle 2 : %d", answer2));
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