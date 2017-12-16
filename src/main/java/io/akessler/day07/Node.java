package io.akessler.day07;

import java.util.HashSet;
import java.util.Set;

public class Node {

    public String name;
    public int weight;
    public int sum;

//    public Node parent;
    public String parentName;

    public Set<String> childrenNames;
//    public Set<Node> children;

    public Node() {
        childrenNames = new HashSet<>();
//        children = new HashSet<>();
    }

}
