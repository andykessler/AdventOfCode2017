package io.akessler.day05;

import io.akessler.AdventUtility;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    private static boolean part2 = true;

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(5);

        List<Integer> sequence = new ArrayList<>();
        for(String line : lines) {
            sequence.add(Integer.parseInt(line));
        }

        int steps = 0;
        int i = 0;
        while(i<sequence.size()) {
            int val = sequence.get(i);
            if(part2 && val >= 3) {
                sequence.set(i, val-1);
            }
            else {
                sequence.set(i, val+1);
            }
            i+=val;
            steps++;
        }

        System.out.println(steps);
    }
}
