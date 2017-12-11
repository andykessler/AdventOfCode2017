package io.akessler.day7;

import java.util.HashSet;
import java.util.Set;

public class Node {

    public String name;
    public int weight;

    public String parentName;
    public Set<String> childrenNames;

    public Node() {
        childrenNames = new HashSet<>();
    }

}
