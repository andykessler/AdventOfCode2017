package io.akessler.day4;

import io.akessler.AdventUtility;

import java.util.*;

public class Day4 {

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(4);

        int answer1 = part1(lines);
        int answer2 = part2(lines);

        System.out.println(answer1);
        System.out.println(answer2);
    }


    private static int part1(List<String> lines) {
        int validCount = 0;
        for(String line : lines) {
            String[] words = line.split(" ");
            Set<String> seenWords = new HashSet<>();
            boolean duplicate = false;
            for (String w : words) {
                if (seenWords.contains(w)) {
                    duplicate = true;
                    break;
                }
                else {
                    seenWords.add(w);
                }
            }
            if (!duplicate) {
                validCount++;
            }
        }
        return validCount;
    }

    private static int part2(List<String> lines) {
        int validCount = 0;
        for(String line : lines) {
            line = line.toLowerCase();
            String[] words = line.split(" ");
            Map<String, int[]> map = new HashMap<>();
            for(String w : words) {
                int[]  charCount = new int[26];
                for(char c : w.toCharArray()) {
                    charCount[c - 'a'] += 1;
                }
                map.put(w, charCount);
            }
            boolean foundAnagram = false;
            for(int i=0; i<words.length; i++) {
                for(int j=i+1; j<words.length; j++){
                    // can check length as heuristic, compare letter counts if equal
                    boolean foundDiff = false;
                    for(int k=0; k<26; k++) {
                        if(map.get(words[i])[k] != map.get(words[j])[k]){
                            foundDiff = true;
                            break;
                        }
                    }
                    if(!foundDiff) {
                        foundAnagram = true;
                        break;
                    }
                }
                if(foundAnagram) {
                    break;
                }
            }
            if(!foundAnagram) {
                validCount++;
            }
        }
        return validCount;
    }
}
