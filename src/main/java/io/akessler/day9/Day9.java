package io.akessler.day9;

import io.akessler.AdventUtility;

import java.util.Stack;

public class Day9 {

    private static final char GROUP_BEGIN = '{';

    private static final char GROUP_END = '}';

    private static final char GARBAGE_BEGIN = '<';

    private static final char GARBAGE_END = '>';

    private static final char ENTRY_DELIM = ',';

    private static final char IGNORE_NEXT = '!';

    public static void main(String[] args) {
        String line = AdventUtility.readInput(9).get(0);

        char[] chars = line.toCharArray();
        Stack<Integer> openGroupStack = new Stack<>();
        openGroupStack.push(0);

        int groupSum = 0;
        int totalGarbage = 0;
        boolean skipNext = false;
        boolean inGarbage = false;
        for(int i=0; i<chars.length; i++) {
            char c = chars[i];

            if (skipNext) {
                skipNext = false;
                continue;
            }
            else if (c == IGNORE_NEXT) {
                skipNext = true;
                continue;
            }

            if (inGarbage) {
                if (c == GARBAGE_END) {
                    inGarbage = false;
                }
                else {
                    totalGarbage++;
                }
            }
            else {
                if (c == GARBAGE_BEGIN) {
                    inGarbage = true;
                }
                else if (c == GROUP_BEGIN) {
                    openGroupStack.push(openGroupStack.peek() + 1);
                }
                else if (c == GROUP_END) {
                    groupSum += openGroupStack.pop();
                }
            }
        }

        System.out.println(groupSum);
        System.out.println(totalGarbage);
    }
}