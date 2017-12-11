package io.akessler.day8;

import java.util.HashMap;
import java.util.Map;

public class Register {

    private Map<String, Integer> register;

    private static final int REG_INIT_VAL = 0;

    private int allTimeMax;

     public Register() {
         register = new HashMap<>();
         allTimeMax = Integer.MIN_VALUE;
     }

     public void inc(String name, int val) {
        initIfEmpty(name);
         int v = register.get(name) + val;
         if(v > allTimeMax) {
             allTimeMax = v;
         }
         register.put(name, v);
     }

     public void dec(String name, int val) {
         initIfEmpty(name);
         int v = register.get(name) - val;
         if(v > allTimeMax) {
             allTimeMax = v;
         }
         register.put(name, v);
     }

     public int get(String name) {
         initIfEmpty(name);
         return register.get(name);
     }

     public int getLargestVal(){
         int max = Integer.MIN_VALUE;
         for(Integer i : register.values()) {
             if(i > max) {
                 max = i;
             }
         }
         return max;
     }

     public int getAllTimeMax(){
         return allTimeMax;
     }

     private void initIfEmpty(String name) {
         if(!register.containsKey(name)) {
             register.put(name, REG_INIT_VAL);
         }
     }
}
