package io.akessler.day11;

public enum HexDirection {
    N, NE, SE, S, SW, NW;

    public HexDirection opposite() {
        switch(this) {
            case N:
                return S;
            case NE:
                return SW;
            case SE:
                return NW;
            case S:
                return N;
            case SW:
                return NE;
            case NW:
                return SE;
            default:
                return null;
        }
    }
}
