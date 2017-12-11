package io.akessler.day3;

import io.akessler.AdventUtility;

public class Day3 {

    public static void main(String[] args) {

        int inputValue = Integer.parseInt(AdventUtility.readInput(3).get(0));

        int x=1;
        while(Math.pow(x,2)<=inputValue) {
            x+=2;
        }
        x-=2; // correct extra increment that broke while condition

        int minRange = (int) Math.pow(x,2) + 1;
        int maxRange = (int) Math.pow(x+2,2);
        System.out.println(minRange);
        System.out.println(maxRange);

        int diff = (maxRange - minRange) + 1;
        System.out.println(diff);

        int sideLength = diff / 4;
        System.out.println(sideLength);

        int dir = 0;
        for(int i=1; i<=4; i++) {
            if(inputValue < minRange + (sideLength * i)) {
                dir = i;
                break;
            }
        }

        int dist = (x+2) / 2; // integer division
        int start = minRange + (sideLength * (dir - 1));
        int end = start + (sideLength - 1); // -1 cause we include start

        System.out.println(dist);
        System.out.println(start);
        System.out.println(end);

        int mid = start + (dist - 1);
        dist += Math.abs(inputValue - mid);
        System.out.println(dist);

        // start part 2
    }
}
