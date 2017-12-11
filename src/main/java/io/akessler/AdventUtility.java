package io.akessler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AdventUtility {

    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 25;
    private static final String FILE_PATH_TEMPLATE = "src/main/res/day%d/input.txt";

    public static List<String> readInput(int day) {
        if(day < MIN_DAY || day > MAX_DAY) {
            return null; // error
        }
        List<String> lines = new ArrayList<>();
        String line = null;
        try {
            FileReader fileReader = new FileReader(String.format(FILE_PATH_TEMPLATE, day));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return lines;
    }

}
