package io.akessler.day11;

import io.akessler.AdventUtility;

import java.util.HashMap;
import java.util.Map;

public class Day11 {

    public static void main(String[] args) {
        String line = AdventUtility.readInput(11).get(0);
        String[] directions = line.split(",");

        int maxDistance = 0;
        Map<HexDirection, Integer> map = new HashMap<>();
        for(HexDirection dir : HexDirection.values()) {
            map.put(dir, 0);
        }

        for(String d : directions) {
            HexDirection dir = HexDirection.valueOf(d.toUpperCase());
            map.put(dir, map.get(dir) + 1);
            int dist = calculateTotalDistance(map);
            if(dist > maxDistance) {
                maxDistance = dist;
            }
        }

        System.out.println("Total Distance: " + calculateTotalDistance(map));
        System.out.println("Max Distance: " + maxDistance);
    }

    private static int calculateTotalDistance(Map<HexDirection, Integer> map) {
        // Normalize distance by doubling weight of direct N/S movement
        // For example, NE is 1 unit North + 1 unit East. Whereas, N is 2 units North.
        int north = (2 * map.get(HexDirection.N)) + map.get(HexDirection.NE) + map.get(HexDirection.NW);
        int south = (2 * map.get(HexDirection.S)) + map.get(HexDirection.SE) + map.get(HexDirection.SW);
        int east = map.get(HexDirection.NE) + map.get(HexDirection.SE);
        int west = map.get(HexDirection.NW) + map.get(HexDirection.SW);

        int dy = north - south;
        int dx = east - west;
        int remY = Math.max(0, Math.abs(dy) - Math.abs(dx));

        return Math.abs(dx) + (remY /  2);
    }
}
