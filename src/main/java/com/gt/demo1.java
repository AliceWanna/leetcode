package com.gt;

public class demo1 {
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.findAccesible(0);
        System.out.println(eightQueen.count);
    }
}
