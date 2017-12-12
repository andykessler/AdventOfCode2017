package io.akessler.day3;

public enum Direction {
    UP(0,1), LEFT(-1,0), DOWN(0,-1), RIGHT(1,0);

    public int x;

    public int y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Direction next() {
        switch(this) {
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
            default:
                return null;
        }
    }
}
