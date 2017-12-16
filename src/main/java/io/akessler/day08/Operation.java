package io.akessler.day08;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    EQ("=="), NEQ("!="), LT("<"), LTE("<="), GTE(">="), GT(">");

    public static Map<String, Operation> opMap;
    static {
        opMap = new HashMap<>();
        for(Operation op : Operation.values()) {
            opMap.put(op.name, op);
        }
    }

    String name;

    Operation(String name) {
        this.name = name;
    }

    public boolean perform(int leftValue, int rightValue) {
        switch(this) {
            case EQ:
                return leftValue == rightValue;
            case NEQ:
                return leftValue != rightValue;
            case LT:
                return leftValue < rightValue;
            case LTE:
                return leftValue <= rightValue;
            case GT:
                return leftValue > rightValue;
            case GTE:
                return leftValue >= rightValue;
            default:
                return false;
        }
    }
}
