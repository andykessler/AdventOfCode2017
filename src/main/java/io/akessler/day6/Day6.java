package io.akessler.day6;

import io.akessler.AdventUtility;

import java.util.HashSet;
import java.util.Set;

public class Day6 {

    public static void main(String[] args) {
        String line = AdventUtility.readInput(6).get(0);

        String[] words = line.split("\t");
        int[] initValues = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            initValues[i] = Integer.parseInt(words[i]);
        }
        int[] values1 = initValues.clone();
        int[] values2 = initValues.clone();

        int cycles = part1(values1);
        int cycleLength = cycles - part2(values2, valuesToString(values1));

        System.out.println(cycles);
        System.out.println(cycleLength);

    }

    private static int part1(int[] vals) {
        Set<String> history = new HashSet<>();
        do {
            history.add(valuesToString(vals));
            distributeHighestResource(vals);
        } while(!history.contains(valuesToString(vals)));
        return history.size();
    }

    private static int part2(int[] vals, String cycleStart) {
        Set<String> history = new HashSet<>();
        do {
            history.add(valuesToString(vals));
            distributeHighestResource(vals);

        } while(!cycleStart.equals(valuesToString(vals)));
        return history.size();
    }

    private static void distributeHighestResource(int[] vals) {
        int max = Integer.MIN_VALUE;
        int maxi = -1;
        for (int i = 0; i < vals.length; i++) {
            int v = vals[i];
            if (v > max) {
                max = v;
                maxi = i;
            }
        }
        vals[maxi] = 0;
        int i = maxi + 1;
        int left = max;
        while (left > 0) {
            if (i >= vals.length) {
                i = 0;
            }
            vals[i] += 1;
            i++;
            left--;
        }
    }

    private static String valuesToString(int[] vals) {
        StringBuilder builder = new StringBuilder();
        for(int v : vals) {
            builder.append(v).append('\t');
        }
        return builder.toString();
    }
}
