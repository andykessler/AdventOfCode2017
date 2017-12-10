package io.akessler.day2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Day2 {

    private static final String FILE_NAME = "src/main/res/day2/input.txt";

    public static void main(String[] args) {
        String line = null;
        int sum1 = 0;
        int sum2 = 0;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null){
                String[] vals = line.split("\t");
                sum1 += maxDiff(vals);
                sum2 += maxEvenDivisibile(vals);
            }
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println(sum1);
        System.out.println(sum2);
    }

    public static int maxDiff(String[] vals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String s : vals) {
            int val = Integer.parseInt(s);
            if(val < min) {
                min = val;
            }
            if(val > max) {
                max = val;
            }
        }
        // Assumes vals is at least length 1
        return max - min;
    }

    public static int maxEvenDivisibile(String[] vals) {
        int maxDivis = Integer.MIN_VALUE;
        // we will use duplicate comparisons to switch divisor
        for(String n : vals) {
            for(String d : vals) {
                if(n.equals(d)) continue;
                int num = Integer.parseInt(n); // numerator
                int div = Integer.parseInt(d); // denominator
                if(num % div == 0) {
                    int quotient =  num / div;
                    if(quotient > maxDivis) {
                        maxDivis = quotient;
                    }
                }
            }
        }
        return  maxDivis;
    }
}
