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
            if(skipNext) {
                skipNext = false;
                continue;
            }

            // FIXME Is there a way to pull up `inGarbage` check without redundant checks in switch?
            switch(c) {
                case IGNORE_NEXT:
                    skipNext = true;
                    break;

                case GROUP_BEGIN:
                    if(inGarbage) {
                        totalGarbage++;
                        break;
                    }
                    openGroupStack.push(openGroupStack.peek() + 1);
                    break;

                case GROUP_END:
                    if(inGarbage) {
                        totalGarbage++;
                        break;
                    }
                    groupSum += openGroupStack.pop();
                    break;

                case GARBAGE_BEGIN:
                    if(!inGarbage) {
                        inGarbage = true;
                    }
                    else {
                        totalGarbage++;
                    }
                    break;

                case GARBAGE_END:
                    if(inGarbage) inGarbage = false;
                    break;

                case ENTRY_DELIM:
                    if(inGarbage) totalGarbage++;
                    break;

                default:
                    totalGarbage++;
                    break;
            }
        }

        System.out.println(groupSum);
        System.out.println(totalGarbage);
    }
}