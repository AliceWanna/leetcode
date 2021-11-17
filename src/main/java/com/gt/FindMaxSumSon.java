package com.gt;

import org.junit.Test;

public class FindMaxSumSon {

    @Test
    public void test1(){
        int[] arr = {-12,-44,-1};
        int maxSum = findMaxSum(arr);
        System.out.println(maxSum);
    }
    public int findMaxSum(int[] a){
        int max = a[0];
        int tmp = 0;
        for (int j : a) {
            tmp += j;
            if (max < tmp)
                max = tmp;
            else if (tmp < 0)
                tmp = 0;
        }
        return max;
    }
}
