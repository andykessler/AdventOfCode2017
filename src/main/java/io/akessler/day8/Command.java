package io.akessler.day8;

public class Command {

    public String targetName;

    public int sign; // inc or dec (+-1)

    public int value;

    public Condition condition;

    private Register register;

    public Command(Register register, String commandLine) {
        this.register = register;
        String[] words = commandLine.split(" ");
        if(words.length != 7) {
            throw new ExceptionInInitializerError("Need 7 params per command!");
        }

        targetName = words[0];
        sign = words[1].equals("inc") ? 1 : -1;
        value = Integer.parseInt(words[2]);

        assert(words[3].equals("if"));

//        int left = register.get(words[4]); // assuming left is always a variable
        String left = words[4];
        Operation op = Operation.opMap.get(words[5]);
        int right = Integer.parseInt(words[6]);
        condition = new Condition(left, op, right);
    }

    public void execute() {
        if(condition.holds(register)) {
            if(sign > 0) {
                register.inc(targetName, value);
            }
            else {
                register.dec(targetName, value);
            }
        }
    }

}
