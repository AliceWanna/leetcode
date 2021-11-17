package com.gt;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;
    private LinkedList<Integer>[]list ;

    public void addEdge(int start,int end){
        list[start].add(end);
        list[end].add(start);
    }

    public void bfs(int start,int end){
        if(start == end)
            return;
        int[] pres = new int[v];
        for (int i = 0; i < v; i++) {
            pres[i] = -1;
        }
        boolean[] isVisited = new boolean[v];
        isVisited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while (!queue.isEmpty()){
            int poll = queue.poll();
            for (int i = 0; i < list[poll].size(); i++) {
                int current = list[poll].get(i);
                if(!isVisited[current]){
                    pres[current] = poll;
                    if(current == end) {
                        return;//print
                    }
                    isVisited[current] = true;
                    queue.add(current);
                }
            }
        }
        return;
    }

    public Graph(int v) {
        this.v = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }
    }
    public int getV() {
        return v;
    }
    public LinkedList<Integer>[] getList() {
        return list;
    }


}
