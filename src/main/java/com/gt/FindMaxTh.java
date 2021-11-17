package com.gt;

import org.junit.Test;

public class FindMaxTh {

    @Test
    public void test1(){
        int[] arr = {1,4,2,123,41244142,223,-213,-32,6,7,41,-2,44};
        int maxTh = findMaxTh(arr, 5);
        System.out.println(maxTh);
    }

    public int findMaxTh(int[] a ,int th){

        if(a == null || a.length < th)
            return -1;

        int index = out(a,0,a.length -1);
        while (index + 1 != th){
            if(index + 1 > th){
                index = out(a,0,index-1);

            }else{
                index = out(a,index + 1,a.length - 1);
            }
        }
        return a[index];
    }

    public int out (int [] a ,int low,int high){
        int temp = a[high];

        while (low < high) {
            while(low< high && a[low] >= temp)
                low++;
            a[high] = a[low];
            while(low < high && a[high] <= temp)
                high--;
            a[low] = a[high];
        }
        a[low] = temp;
        return low;
    }
}
