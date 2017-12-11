package io.akessler.day3;

import io.akessler.AdventUtility;

public class Day3 {

    public static void main(String[] args) {
        int inputValue = Integer.parseInt(AdventUtility.readInput(3).get(0));

        int answer1 = manhattenDistance(inputValue);
        int answer2 = firstValueLargerThan(inputValue);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static int manhattenDistance(int inputValue) {
        int x=1;
        while(Math.pow(x,2)<=inputValue) {
            x+=2;
        }
        x-=2; // correct extra increment that broke while condition

        int minRange = (int) Math.pow(x,2) + 1;
        int maxRange = (int) Math.pow(x+2,2);
        int diff = (maxRange - minRange) + 1;
        int sideLength = diff / 4;

        int dir = 0;
        for(int i=1; i<=4; i++) {
            if(inputValue < minRange + (sideLength * i)) {
                dir = i;
                break;
            }
        }

        int dist = (x+2) / 2; // integer division
        int start = minRange + (sideLength * (dir - 1));
//        int end = start + (sideLength - 1); // -1 cause we include start
        int mid = start + (dist - 1);
        dist += Math.abs(inputValue - mid);

        return dist;
    }

    private static int firstValueLargerThan(int inputValue) {
        return -1;
    }
}
