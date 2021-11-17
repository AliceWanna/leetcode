package com.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class pro54 {
    @Test
    public void test1(){
        //[[1,2,3],[4,5,6],[7,8,9]]
//        int[][] arr = new int[3][];
//        arr[0] = new int[]{1,2,3};
//        arr[1] = new int[]{4,5,6};
//        arr[2] = new int[]{7,8,9};

        //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] arr = new int[3][];
        arr[0] = new int[]{1,2,3,4};
        arr[1] = new int[]{5,6,7,8};
        arr[2] = new int[]{9,10,11,12};
        System.out.println(spiralOrder(arr));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int row = 0;
            int right = matrix[0].length-1;
            int left = 0;
            int down = matrix.length-1;
            int size = (right+1)*(down+1);
            while(list.size()!=size){
                for(int i =left;i<=right;i++){
                    list.add(matrix[row][i]);
                }
                for(int i = row+1;i<=down;i++){
                    list.add(matrix[i][right]);
                }
                for(int i=right-1;i>=left;i--){
                    list.add(matrix[down][i]);
                }
                for(int i = down-1;i>row;i--){
                    list.add(matrix[i][left]);
                }
                left++;
                row++;
                right--;
                down--;
            }
            return list;
    }
}