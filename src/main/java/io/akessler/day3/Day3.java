package io.akessler.day3;

public class Day3 {

    private static int INPUT_VAL = 265149;
    public static void main(String[] args) {
        int x=1;
        while(Math.pow(x,2)<=INPUT_VAL) {
            x+=2;
        }
        x-=2; // correct extra increment that broke while condition
        System.out.println(x);

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
            if(INPUT_VAL < minRange + (sideLength * i)) {
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
        dist += Math.abs(INPUT_VAL - mid);
        System.out.println(dist);


        // start part 2

    }
}
