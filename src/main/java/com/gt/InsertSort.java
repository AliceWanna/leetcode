package com.gt;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {

    @Test
    public void test1(){
        int[] a = {2,3,41,5123,33,0,-123,32,-32,2,21};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int tmp = a[i];
            for (;j>=0;j--){
                if(a[j] > tmp){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = tmp;
        }
    }


//    public void insertSort(int[] a){
//        for(int i =1;i<a.length; i++){
//            int j = i -1;
//            int temp = a[i];
//            for(;j>=0;j--){
//                if(a[j] > temp){
//                    a[j+1] = a[j];
//                }else{
//                    break;
//                }
//            }
//            a[j+1] = temp;
//        }
//    }
}
