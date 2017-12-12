package io.akessler.day3;

import io.akessler.AdventUtility;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        int inputValue = Integer.parseInt(AdventUtility.readInput(3).get(0));

        int answer1 = manhattanDistance(inputValue);
        int answer2 = firstValueLargerThan(inputValue);

        System.out.println(answer1);
        System.out.println(answer2);
    }

    private static int manhattanDistance(int inputValue) {
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

    /* Example:
    147  142  133  122   59
    304    5    4    2   57
    330   10    1    1   54
    351   11   23   25   26
    362  747  806--->   ...
     */
    // Considering just creating struct that has pointers to each direction...
    // Or a list of lists for each layer, to easily do math through previous layers...
    private static int firstValueLargerThan(int inputValue) {
        List<Integer> sequence = new ArrayList<>();
        // hardcoding the first few values of sequence to avoid handling special cases
        sequence.add(1);  sequence.add(1);  sequence.add(2);
        sequence.add(4);  sequence.add(5);  sequence.add(10);
        sequence.add(11); sequence.add(23); sequence.add(25);

        int curr = 25;

        int x = 3;
        int minRange = (int) Math.pow(x,2) + 1;
        int maxRange = (int) Math.pow(x+2,2);
        int diff = (maxRange - minRange) + 1;
        int sideLength = diff / 4;
        int sideEnd = minRange + sideLength;

        int lastMinRange = 0, lastMaxRange = 0, lastSideLength = 1;

        int i = sequence.size();
        int side = 1;
        while(curr < inputValue) {
            int sum = curr; // always include last value in sum
            if(i == minRange) { // this is 1 away from a corner
                // add 1 other value to sum (1st one of the last layer)
                int index = lastMinRange - 1;
                sum += sequence.get(index);
            }
            else if(i == sideEnd - 1) { // this is 1 away from a corner
                // add 2 other values to sum (last layer's same corner + that one's prev)
                int index = lastMinRange + (sideLength * side) - 1;
                sum += sequence.get(index);
                sum += sequence.get(index - 1);
            }
            else if(i == sideEnd) { // this is a corner
                // add 1 other value to sum (last layer's same corner)
                int index = lastMinRange + (sideLength * side) - 1;
                sum += sequence.get(index);

                sideEnd += sideLength;
                side++;
                if(sideEnd > maxRange) { // start new layer, adjust values
                    // use these history values to interact with previous layer
                    lastMinRange = minRange;
                    lastMaxRange = maxRange;
                    lastSideLength = sideLength;

                    x += 2;
                    minRange = (int) Math.pow(x,2) + 1;
                    maxRange = (int) Math.pow(x+2,2);
                    diff = (maxRange - minRange) + 1;
                    sideLength = diff / 4;
                    sideEnd = minRange + sideLength;
                    side = 1;
                }
            }
            else { // this is all other cases
                // add 3 other values to sum
                // TODO
            }
            curr = sum;
            sequence.add(curr);
            i++;
        }
        return curr;
    }
}
