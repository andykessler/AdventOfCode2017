package io.akessler.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

    private static final String FILE_NAME = "src/main/res/day5/input.txt";

    private static boolean part2 = true;

    public static void main(String[] args) {
        String line;
        List<Integer> sequence = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                sequence.add(Integer.parseInt(line));
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        int steps = 0;
        int i=0;
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
