package io.akessler.day02;

import io.akessler.AdventUtility;

import java.util.List;

public class Day2 {

    public static void main(String[] args) {

        List<String> lines = AdventUtility.readInput(2);

        int sum1 = 0;
        int sum2 = 0;

        for(String line : lines) {
            String[] vals = line.split("\t");
            sum1 += maxDiff(vals);
            sum2 += maxEvenDivisibile(vals);
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
        // assumes vals is at least length 1
        return max - min;
    }

    public static int maxEvenDivisibile(String[] vals) {
        int maxDivis = Integer.MIN_VALUE;
        for(int i=0; i<vals.length; i++){
            // j=i+1 to prevent self and repeated comparisons
            for(int j=i+1; j<vals.length; j++){
                int num = Integer.parseInt(vals[i]); // numerator
                int div = Integer.parseInt(vals[j]); // denominator
                if(div > num) {  // make sure dividing by smaller
                    int temp = div;
                    div = num;
                    num = temp;
                }
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
