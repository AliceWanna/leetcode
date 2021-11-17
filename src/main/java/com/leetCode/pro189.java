package com.leetCode;

import org.junit.Test;

public class pro189 {
    @Test
    public void test1(){
        int []arr = {1,2,3,4,5,6};
        rotate(arr,3);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        myReverse(nums,0,nums.length-1);
        myReverse(nums,0,k-1);
        myReverse(nums,k,nums.length-1);
    }
    public void myReverse(int[] arr,int start,int end){
        while(start<end){
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            end--;
            start++;
        }
    }
}
