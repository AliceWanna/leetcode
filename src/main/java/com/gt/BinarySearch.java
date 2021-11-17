package com.gt;

import org.junit.Test;

import java.util.HashMap;

public class BinarySearch {

    public int[]    get(){
        return new int[]{1,3,3};
    }

    @Test
    public void test3() {
        HashMap<String, Integer> map = new HashMap<>();
    }

    @Test
    public void test1(){
        int[] arr = {1,3,5,6,9,23,44,66,76,90,110};
        int i = binarySearch(arr, 110, 0, arr.length - 1);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int[] arr = {1,3,5,6,9,23,44,66,76,90,110};
        int i = findLastLowByBinarySearch(arr, 0, 0, arr.length - 1);
        System.out.println(arr[i]);
    }

        //查找最后一个小于等于target的元素
    public int findLastLowByBinarySearch(int[] arr,int target,int left,int right){
        if(arr == null)
            return -1;
        if(right == 0)
            return target == arr[0]?0:-1;
        if(left > right)
            return -1;
        int middle = (left + right)/2;
        if(target < arr[middle])
            return findLastLowByBinarySearch(arr,target,left,middle-1);
        if(target >= arr[middle]){
            if(middle == arr.length-1 || arr[middle+1] > target)
                return middle;
            return findLastLowByBinarySearch(arr,target,middle + 1,right);
        }
        return -1;
    }

    //递归实现二分法
    public int binarySearch(int[] a,int des,int left,int right){
        if(left > right)
            return -1;
        int index = (left + right)/2;
        int tmp = a[index];
        if(tmp == des)
            return index;
        if(des < tmp)
            return binarySearch(a,des,left,index -1);
        else
            return binarySearch(a,des,index + 1,right);
    }
}
