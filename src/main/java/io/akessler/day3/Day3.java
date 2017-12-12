package io.akessler.day3;

import io.akessler.AdventUtility;

import java.awt.*;

public class Day3 {

    private static final int START_VALUE = 1;

    private static final int GRID_WIDTH = 51;

    private static final int GRID_HEIGHT = 51;

    public static void main(String[] args) {
        int inputValue = Integer.parseInt(AdventUtility.readInput(3).get(0));

        int answer1 = manhattanDistance(inputValue);
        int answer2 = firstValueLargerThan(inputValue);

        System.out.println("Part 1: " + answer1);
        System.out.println("Part 2: " + answer2);
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

    private static int firstValueLargerThan(int inputValue) {
        int x = GRID_WIDTH, y = GRID_HEIGHT;
        // center of 2d array, so can access with negative indices
        Point off = new Point((x / 2), (y / 2));
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        int[][] grid = new int[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++) {
                grid[i][j] = 0; // initialize grid to 0 (not needed?)
            }
        }
        grid[off.x][off.y] = START_VALUE;


        Direction dir = Direction.UP;
        int currValue = START_VALUE;
        int currX = 1;
        int currY = 0;
        int currStep = 1;
        int maxSteps = 2;

        while(currValue <= inputValue) {
            // lol, instead only add up those on the left+behind of current direction
            currValue = grid[currX + off.x + 1][currY + off.y]
                    + grid[currX + off.x - 1][currY + off.y]
                    + grid[currX + off.x][currY + off.y + 1]
                    + grid[currX + off.x][currY + off.y - 1]
                    + grid[currX + off.x + 1][currY + off.y + 1]
                    + grid[currX + off.x - 1][currY + off.y - 1]
                    + grid[currX + off.x + 1][currY + off.y - 1]
                    + grid[currX + off.x - 1][currY + off.y + 1];

            grid[currX + off.x][currY + off.y] = currValue;

            if(currStep == maxSteps) {
                dir = dir.next();
                currStep = 0;
                if(dir == Direction.UP) {
                    maxSteps += 2;
                    currX++;
                    currStep++;
                    continue;
                }
            }

            currX += dir.x;
            currY += dir.y;
            currStep++;
        }
        return currValue;
    }
}
