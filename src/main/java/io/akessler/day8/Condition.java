package io.akessler.day8;

public class Condition {

    public String leftValue;

    public Operation operation;

    public int rightValue;

    public Condition(String leftValue, Operation operation, int rightValue) {
        this.leftValue = leftValue;
        this.operation = operation;
        this.rightValue = rightValue;
    }

    public boolean holds(Register register) {
        return operation.perform(register.get(leftValue), rightValue);
    }
}
