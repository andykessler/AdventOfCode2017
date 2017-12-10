package io.akessler.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day4 {

    private static final String FILE_NAME = "src/main/res/day4/input.txt";

    public static void main(String[] args) {
        String line;
        int validCount = 0;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(" ");
                Set<String> seenWords = new HashSet<>();
                boolean duplicate = false;
                for(String w : words) {
                    if(seenWords.contains(w)) {
                        duplicate = true;
                        break;
                    }
                    else {
                        seenWords.add(w);
                    }
                }
                if(!duplicate) {
                    validCount++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(validCount);

        // part 2
        part2(); // lol
    }

    private static void part2() {
        String line;
        int validCount = 0;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
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
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(validCount);
    }
}
