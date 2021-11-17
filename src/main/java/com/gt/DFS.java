package com.gt;

import java.util.LinkedList;

public class DFS {
    public int num;
    public LinkedList<Integer>[] list;
    public boolean isFound;

    public DFS(int num){
        this.num = num;
        list = new LinkedList[num];
        for (int i = 0; i < num; i++) {
            list[i] = new LinkedList<>();
        }
    }
    public void doDFS(int start,int target,boolean[] visited,int[] prev){
        if(isFound){
        }

    }
    //start 到 target
    private void printRoad(int[] pres,int start, int target) {
        if(pres[target] != -1 && target!=start){
            printRoad(pres,start,pres[target]);
        }
        System.out.print(start + " ");
    }
}
