package io.akessler.day12;

import io.akessler.AdventUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Day12 {

    private static final int SEARCH_ID = 0;

    private static Map<Integer, Node> idNodeMap;

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(12);

        idNodeMap = new HashMap<>();
        for (String line : lines) {
            String[] words = line.split(" ");
            int id = Integer.parseInt(words[0]);
            List<Integer> neighbors = new ArrayList<>();
            for (int i = 2; i < words.length; i++) {
                String word = words[i];
                if (word.charAt(word.length() - 1) == ',') {
                    word = word.substring(0, word.length() - 1);
                }
                neighbors.add(Integer.parseInt(word));
            }
            Node n = new Node(id, neighbors);
            idNodeMap.put(id, n);
        }

        // start with search id for part 1
        // then after just get arbitrary node to traverse for part 2
        int answer1 = calculateGraphCardinality(idNodeMap.get(SEARCH_ID));

        System.out.println(String.format("Size containing id %d: %d",SEARCH_ID, answer1));

        int totalGroups = 1; // start at 1 since did graph with SEARCH_ID
        while(!idNodeMap.isEmpty()) {
            Node n = (Node) idNodeMap.values().toArray()[0];
            calculateGraphCardinality(n);
            totalGroups++;
        }

        System.out.println("Total Groups: " + totalGroups);
    }

    private static int calculateGraphCardinality(Node root) {

        Stack<Node> nodeStack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        nodeStack.push(root);
        visited.add(root);

        while (!nodeStack.isEmpty()) {
            Node n = nodeStack.pop();
            for (Integer i : n.neighbors) {
                Node neighbor = idNodeMap.get(i);
                if (!visited.contains(neighbor)) {
                    nodeStack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        idNodeMap.values().removeAll(visited);

        return visited.size();
    }
}
