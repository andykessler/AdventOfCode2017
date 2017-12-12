package io.akessler.day7;

import io.akessler.AdventUtility;

import java.util.*;

public class Day7 {

    private static Map<String, Node> nodeMap;


    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(7);

        nodeMap = new HashMap<>();

        for(String line : lines) {
            // example data: "mxemqqb (267) -> iuuouds, qqmvd"
            String[] words = line.split(" ");

            Node n = new Node();
            n.name = words[0];

            String weight = words[1];
            weight = weight.substring(1, weight.length() - 1);
            n.weight = Integer.parseInt(weight);

            if(words.length >= 4) { // has at least "->" + 1 child
                for(int i=3; i<words.length; i++) {
                    String w = words[i];
                    if(w.charAt(w.length()-1) == ',') {
                        w = w.substring(0,w.length()-1);
                    }
                    n.childrenNames.add(w);
                }
            }
            nodeMap.put(n.name, n);
        }

        // part 1
        String currKey = (String) nodeMap.keySet().toArray()[0];
        Node curr = nodeMap.get(currKey);
        boolean done;
        do {
            done = true; // assume last loop until proven otherwise
            for(String k : nodeMap.keySet()){
                Node v = nodeMap.get(k);
                if(v.childrenNames.contains(currKey)){
                    curr.parentName = v.name;
                    currKey = k;
                    curr = v;
                    done = false;
                }
            }
        } while(!done);

        System.out.println("Root node is: " + curr.name);

        // part 2
        // curr should already be the root of the tree.
        sumCheckWeights(curr);
    }

    private static int sumCheckWeights(Node root) {
        if(root == null) {
            return 0;
        }

        int sum = 0;
        List<Integer> weights = new ArrayList<>();
        for(String childName : root.childrenNames) {
            Node child = nodeMap.get(childName);
            weights.add(sumCheckWeights(child));
        }

        Map<Integer, Integer> weightCount = new HashMap<>();
        for(int i=0; i<weights.size(); i++){
            int w = weights.get(i);
//            if(w == Integer.MIN_VALUE) return w; // hack to stop calculating
            sum += w;
            weightCount.put(w, weightCount.getOrDefault(w, 0) + 1);
        }

        int herringWeight = -1;
        int normalWeight = -1;
        for(Integer i : weightCount.keySet()) {
            if(weightCount.get(i) == 1 && weights.size() > 1) { // there is at most 1 error
                herringWeight = i;
            }
            else {
                normalWeight = i;
            }
        }

        if(herringWeight != -1) {
            Node herring = null;
            for(String childName : root.childrenNames) {
                Node child = nodeMap.get(childName);
                if (child.sum == herringWeight) {
                    herring = child;
                    break;
                }
            }

            int diff = herringWeight - normalWeight;
            herring.weight -= diff;
            System.out.println(herring.name + " needs weight: " + herring.weight);
//            return Integer.MIN_VALUE;
        }

        sum += root.weight;
        root.sum = sum;
        return sum;
    }
}
