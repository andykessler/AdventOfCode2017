package io.akessler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AdventUtility {

    private static final int MIN_DAY = 1;

    private static final int MAX_DAY = 25;

    private static final String FILE_PATH_TEMPLATE = "src/main/res/day%d/input.txt";
    // FIXME There is a better way to do this instead of 2 separate templates
    private static final String FILE_PATH_TEMPLATE_LT10 = "src/main/res/day0%d/input.txt"; // for days less than 10
    //    private static final String FILE_PATH_TEMPLATE = "src/main/res/day%d/example.txt";

    public static List<String> readInput(int day) {
        if(day < MIN_DAY || day > MAX_DAY) {
            return null; // error
        }
        String template = day < 10 ? FILE_PATH_TEMPLATE_LT10 : FILE_PATH_TEMPLATE;
        List<String> lines = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(String.format(template, day));
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
