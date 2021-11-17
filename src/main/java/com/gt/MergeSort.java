package com.gt;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void test1(){
        int[] a = {1,4,2,123,41244142,223,-213,-32,6,7,41,-2,44};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[]a,int first,int last){
        if(first >= last)
            return;
        int temp = (first + last)/2;
        mergeSort(a,first,temp);
        mergeSort(a,temp + 1,last);

        merge(a,first,temp,last);
    }

    public void merge(int[] a,int first,int temp,int last){
        int[] arr = new int[last - first + 1];
        int j = temp +1;
        int i = first;
        int index = 0;
        while ( i <= temp && j <=last){
            if(a[i] < a[j]){
                arr[index++] = a[i++];
            }else{
                arr[index++] = a[j++];
            }
        }
        while (i<= temp)
            arr[index++] = a[i++];
        while (j<= last)
            arr[index++] = a[j++];
        if (index >= 0) System.arraycopy(arr, 0, a, first, index);
//        for(int ii = 0;ii<index;ii++){
//            a[first + ii] = arr[ii];
//        }
    }
    /*
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }
}
     */
}
