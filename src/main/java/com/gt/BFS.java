package com.gt;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public int num;
    public LinkedList<Integer>[] list;

    public BFS(int num){
        this.num = num;
        list = new LinkedList[num];
        for (int i = 0; i < num; i++) {
            list[i] = new LinkedList<>();
        }
    }
    public void doBFS(int start,int target){
        if(start == target)
            return;
        int[] pres = new int[num];
        for (int i = 0; i < num; i++) {
            pres[i] = -1;
        }
        boolean[] isVisited = new boolean[num];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i = 0;i<list[current].size(); i++){
                int cur = list[current].get(i);
                if(!isVisited[cur]){
                    isVisited[cur] = true;
                    if(cur == target){
                        printRoad(pres,start,target);
                        return;
                    }
                    pres[cur] = current;
                    queue.add(cur);
                }
            }
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

