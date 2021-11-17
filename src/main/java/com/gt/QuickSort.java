package com.gt;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void test1(){
        int[]a = {123,4,231,-23,412,3,45,6,54,23,-98};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] a ,int first,int last){
        if(first >= last)
            return;
        int temp = internalSort(a,first,last);
        quickSort(a,first,temp-1);
        quickSort(a,temp+1,last);
    }
    public int internalSort(int[]a,int first,int last){
        int i = first;
        for(int j = first; j < last;j++){
            if(a[j] < a[last]){
                if(i == j)
                    i++;
                else{
                    int temp = a[j];
                    a[j] = a[i];
                    a[i++] = temp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[last];
        a[last] = tmp;
        return i;
    }
}
