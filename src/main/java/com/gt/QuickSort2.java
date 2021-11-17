package com.gt;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {


    @Test
    public void test1(){
        int[] a = new int[200];
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            a[i] = random.nextInt(100000);
        }
        quickSort2(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort2(int[] a,int first,int last){
        if(first >= last)
            return;
        int index = out(a,first,last);
        quickSort2(a,first,index - 1);
        quickSort2(a,index + 1,last);
    }

    public int out(int[] a,int f,int l){
        int tmp = a[f];

        while (f < l){
            while(f < l && a[l] >= tmp)
                l--;
            a[f] = a[l];
            while(f < l && a[f] <= tmp)
                f++;
            a[l] = a[f];
        }
        a[l] = tmp;
        return l;
    }
}
