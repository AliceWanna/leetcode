package com.leetCode;

import java.util.LinkedList;

public class pro55 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.isEmpty();
        System.out.println(jump1.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}

class jump1 {
    public static boolean canJump(int[] nums) {
        int current = 0;
        int able = nums[0];
        int lastStep;
        int next = 0;
        while(true){
            if(able == 0)
                return false;
            lastStep=0;
            for(int i = current + 1;i<current + able;i++){
                if(i>=nums.length)
                    break;
                if(lastStep<=(i+nums[i])){
                    next=i;
                    lastStep = i+nums[i];
                }
            }
            current = next;
            able = nums[current];
            if(lastStep>=nums.length)
                return true;
        }
    }
}