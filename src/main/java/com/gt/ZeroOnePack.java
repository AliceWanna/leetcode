package com.gt;

import org.junit.Test;

public class ZeroOnePack {
    public int maxValue = Integer.MIN_VALUE;

    //findMaxValue(0,0,arr,arr.length,100);
    @Test
    public void test1(){
        ZeroOnePack zeroOnePack = new ZeroOnePack();
        int[] arr = new int[]{1,4,6,9,10,20};
        zeroOnePack.findMaxValue(0,0,arr,arr.length,4);
        System.out.println(zeroOnePack.maxValue);
        System.out.println(findMaxValueVer1(8,arr,arr.length));
        System.out.println(findMaxValueVer2(8,arr,arr.length));
    }

    /*
      currentItem --> 考察到哪个物品
      valueSum    --> 当前已装进去的重量总和
      items       --> 每个物品的重量
      num         --> 物品个数
      packValue   --> 背包重量
    */
    //回溯算法实现
    public void findMaxValue(int currentItem,int valueSum,int[] items,int num,int packValue){
        //  装满  ||  考察完所有物品
        if(valueSum == packValue || num == currentItem){
            if(valueSum>maxValue)
                maxValue = valueSum;
            return;
        }
        findMaxValue(currentItem+1,valueSum,items,num,packValue);
        //已经超过背包重量
        if(valueSum+items[currentItem] <=packValue){
            findMaxValue(currentItem+1,valueSum+items[currentItem],items,num,packValue);
        }
    }

    //动态规划实现 ver--1.0
    public int findMaxValueVer1(int packValue,int[] items,int num){
        boolean[][] status = new boolean[num][packValue+1];
        status[0][0] = true;
        status[0][items[0]] = true;
        for (int i = 1; i < items.length; i++) {
            for (int j = 0; j < packValue+1; j++) {
                if(status[i-1][j]){
                    status[i][j] = true;
                    if(j+items[i] <=packValue)
                        status[i][j+items[i]] = true;
                }
            }
        }
        for (int i = packValue; i >-1; i--) {
            if(status[num-1][i])
                return i;
        }
        return 0;
    }

    //动态规划实现 ver--2.0
    public int findMaxValueVer2(int packValue,int[] items,int num){
        boolean[] status = new boolean[packValue+1];
        status[0] = true;
        status[items[0]] = true;
        for (int i = 1; i < items.length; i++) {
            for (int j = packValue-items[i]; j >-1; j--) {
                if(status[j]) status[j+items[i]] = true;
            }
//            for (int j = 0; j <=packValue-items[i]; j++) {
//                if(status[j]) status[j+items[i]] = true;
//            }
        }
        for (int i = packValue; i >-1; i--) {
            if(status[i])
                return i;
        }
        return 0;
    }

    //动态规划实现复杂背包问题(每个物品附带价值)
    public int findMaxValueVer3(int packValue,int[] weight,int[] value){
        int[][] status = new int[weight.length][packValue+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < packValue+1; j++) {
                status[i][j] = -1;
            }
        }
        status[0][0]=0;
        status[0][weight[0]] = value[0];
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < packValue+1; j++) {
                if(status[i-1][j] >=0) status[i][j] = status[i-1][j];
            }
            for (int j = 0; j < packValue+1-weight[i]; j++) {
                if(status[i-1][j] >=0){
                    int curVal = status[i-1][j] + value[i];
                    if(curVal >status[i-1][j+weight[i]])
                        status[i][j+weight[i]] = curVal;
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < packValue+1; i++) {
            if(status[weight.length-1][i] > maxValue)
                maxValue = status[weight.length-1][i];
        }
        return maxValue;
    }

    //动态规划实现复杂背包问题(每个物品附带价值) 改进版
    public int findMaxValueVer4(int packValue,int[] weight,int[] value){
        int[] status = new int[packValue+1];
        for (int i = 0; i < packValue+1; i++) {
                status[i] = -1;
        }
        status[0]=0;
        status[weight[0]] = value[0];
        for (int i = 1; i < weight.length; i++) {
            for (int j = packValue-weight[i]; j>=0; j--) {
                if(status[j]>=0){
                    int curVal = status[j] + value[i];
                    if(curVal > status[j+weight[i]])
                        status[j+weight[i]] = curVal;
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < packValue+1; i++) {
            if(status[i]>maxValue)
                maxValue = status[i];
        }
        return maxValue;
    }

}
