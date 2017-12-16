package io.akessler.day08;

import io.akessler.AdventUtility;

import java.util.List;

public class Day8 {

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(8);

        Register register = new Register();
        for(String line : lines) {
            Command c = new Command(register, line); // passing register every time?
            c.execute();
        }

        System.out.println(register.getLargestVal());
        System.out.println(register.getAllTimeMax());
    }
}