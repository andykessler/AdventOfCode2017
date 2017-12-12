package io.akessler.day12;

import java.util.List;

public class Node {

    public int id;

    public List<Integer> neighbors;

    public Node(int id, List<Integer> neighbors) {
        this.id = id;
        this.neighbors = neighbors;
    }

}
