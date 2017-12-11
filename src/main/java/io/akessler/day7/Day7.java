package io.akessler.day7;

import io.akessler.AdventUtility;

import java.util.*;

public class Day7 {

    public static void main(String[] args) {
        List<String> lines = AdventUtility.readInput(7);

        Map<String, Node> map = new HashMap<>();
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
            map.put(n.name, n);
        }

        String currKey = (String) map.keySet().toArray()[0];
        Node curr = map.get(currKey);
        boolean done;
        do {
            done = true; // assume last loop until proven otherwise
            for(String k : map.keySet()){
                Node v = map.get(k);
                if(v.childrenNames.contains(currKey)){
                    curr.parentName = v.name;
                    currKey = k;
                    curr = v;
                    done = false;
                }
            }
        } while(!done);

        System.out.println(curr.name);
    }
}
