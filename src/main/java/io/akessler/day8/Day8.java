package io.akessler.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {

    private static final String FILE_NAME = "src/main/res/day8/input.txt";


    public static void main(String[] args) {
        Register register = new Register();

        String line;
        List<Command> commandList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
               commandList.add(new Command(register, line)); // passing register every time?
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        for(Command c : commandList) {
            c.execute();
        }

        System.out.println(register.getLargestVal());
        System.out.println(register.getAllTimeMax());
    }
}