package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int egg = 7;
        int floor = 100;

        int[][] mem = new int[egg + 1][floor + 1];

        System.out.println(eggDropDPItr(egg, floor, mem));
    }

    public static int eggDropDPItr(int egg, int floor, int[][] mem){
        for (int e = 1; e <= egg; e++) {
            for (int f = 0; f <= floor; f++) {
                if (f == 0){
                    mem[e][f] = 0;
                }
                else if (e == 1){
                    mem[e][f] = f;
                }
                else {
                    int min = Integer.MAX_VALUE;

                    for (int i = 1; i <= f ; i++) {

                        int sol = Math.max(mem[e-1][i-1], mem[e][f-i]) + 1;

                        if(sol < min){
                            min = sol;
                        }
                    }

                    mem[e][f] = min;
                }
            }
        }

        return mem[egg][floor];
    }

    public static int eggDropDP(int egg, int floor, int[][] mem){

        if (floor == 0){
            return 0;
        }

        if (egg == 1){
            return floor;
        }

        if (mem[egg][floor] != 0){
            return mem[egg][floor];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= floor ; i++) {
            int sol = Math.max(eggDropDP(egg - 1, i-1, mem), eggDropDP(egg, floor - i, mem)) + 1;

            if(sol < min){
                min = sol;
            }
        }

        mem[egg][floor] = min;

        return min;
    }

    public static int eggDrop(int egg, int floor){

        if (floor == 0){
            return 0;
        }

        if (egg == 1){
            return floor;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= floor ; i++) {
            int sol = Math.max(eggDrop(egg - 1, i-1), eggDrop(egg, floor - i)) + 1;

            if(sol < min){
                min = sol;
            }
        }

        return min;
    }
}
