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

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(12);
        Map<Integer, Node> idNodeMap = new HashMap<>();
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

        Node rootNode = idNodeMap.get(SEARCH_ID);

        Stack<Node> nodeStack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        nodeStack.push(rootNode);
        visited.add(rootNode);

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

        System.out.println(visited.size());
    }
}
