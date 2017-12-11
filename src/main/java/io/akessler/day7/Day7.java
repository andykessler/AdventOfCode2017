package io.akessler.day7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Day7 {

    private static final String FILE_NAME = "src/main/res/day7/input.txt";

    public static void main(String[] args) {
        Map<String, Node> map = new HashMap<>();
        String line;
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                // example data:
                // mxemqqb (267) -> iuuouds, qqmvd
                String[] words = line.split(" ");

                Node n = new Node();
                n.name = words[0];

                String weight = words[1];
                weight = weight.substring(1, weight.length() - 1);
                n.weight = Integer.parseInt(weight);

                if(words.length >= 4) { // has at least -> and 1 child
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
            bufferedReader.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
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
