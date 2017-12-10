package io.akessler.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Day6 {

    private static final String FILE_NAME = "src/main/res/day6/input.txt";

    public static void main(String[] args) {
        String line;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split("\t");
                int[] vals = new int[words.length];
                for(int i=0; i<words.length; i++){
                    vals[i] = Integer.parseInt(words[i]);
                    System.out.println(vals[i]);

                }

                Set<String> history = new HashSet<>();
                do {
                    history.add(valsToString(vals));
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
                } while(!history.contains(valsToString(vals)));

                int cycles = history.size();
                int cycleLength = cycles - part2(valsToString(vals), line);

                System.out.println(history.size());
                System.out.println(cycleLength);
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String valsToString(int[] vals) {
        StringBuilder builder = new StringBuilder();
        for(int v : vals) {
            builder.append(v).append('\t');
        }
        String result =  builder.toString();
        System.out.println(result);
        return result;
    }

    private static int part2(String cycleStart, String line) {
        // duplicating code xD
        String[] words = line.split("\t");
        int[] vals = new int[words.length];
        for(int i=0; i<words.length; i++){
            vals[i] = Integer.parseInt(words[i]);
            System.out.println(vals[i]);

        }

        Set<String> history = new HashSet<>();
        do {
            history.add(valsToString(vals));
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
        } while(!cycleStart.equals(valsToString(vals)));
        return history.size();
    }

}
