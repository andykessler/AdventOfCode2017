package io.akessler.day10;

import io.akessler.AdventUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Day10 {

    private static final int LENGTH = 256;

    private static final int[] LENGTH_SUFFIX = {17,31,73,47,23};

    public static void main(String[] args) {
        String line = AdventUtility.readInput(10).get(0);

//        String[] words = line.split(",");
//        // TODO extract this to a "part1" method
//        int[] lengths1 = new int[words.length];
//        for(int i=0; i<lengths1.length; i++) {
//            lengths1[i] = Integer.parseInt(words[i]);
//        }

        // TODO extract this to a "part2" method
        int[] lengths2 = new int[line.length() + LENGTH_SUFFIX.length];
        for(int i=0; i<line.length(); i++) {
            lengths2[i] = (int) line.charAt(i);
        }
        for(int i=0; i<LENGTH_SUFFIX.length; i++) {
            lengths2[line.length() + i] = LENGTH_SUFFIX[i];
        }

        List<Integer> seq = new ArrayList<>();
        for(int i=0; i<LENGTH; i++) {
            seq.add(i);
        }

        int currPosition = 0;
        int skipSize = 0;
        for(int r = 0; r < 64; r++) {
            for(Integer i : lengths2) {
                int reverseEnd = currPosition + i;
                if(reverseEnd > LENGTH) {
                    reverseEnd %= LENGTH;

                    // if I was trying to be efficient I wouldn't do these copies,
                    // instead would just swap index values myself
                    List<Integer> sub = new ArrayList<>(seq.subList(currPosition, LENGTH));
                    sub.addAll(new ArrayList<>(seq.subList(0, reverseEnd)));
                    Collections.reverse(sub);

                    Iterator<Integer> it = sub.iterator();
                    for(int j=currPosition; it.hasNext(); j++) {
                        if(j >= LENGTH) j %= LENGTH;
                        seq.set(j, it.next());
                    }
                }
                else {
                    Collections.reverse(seq.subList(currPosition, reverseEnd));
                }
                currPosition = (reverseEnd + skipSize) % LENGTH;
                skipSize++;
            }
        }

//        seq.forEach(i -> System.out.println(i));

        String output = "";
        for(int i=0; i<16; i++) {
            int blockStart = i * 16;
            int xor = seq.get(blockStart);
            for(int j=1; j<16; j++) {
                xor ^= seq.get(blockStart + j);
            }
            String hex = Integer.toHexString(xor);
            if(hex.length() != 2) {
                hex = "0" + hex;
            }
            output += hex;
        }

        System.out.println(output);
    }
}