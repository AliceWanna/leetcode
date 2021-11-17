package com.leetCode;

import org.junit.Test;

import java.util.Arrays;

public class pro498 {

    @Test
    public void test1(){
//        [[1,2,3],[4,5,6],[7,8,9]]
        int[][]arr = new int[3][];
        arr[0] = new int []{1,2,3};
        arr[1] = new int []{4,5,6};
        arr[2] = new int []{7,8,9};
        System.out.println(Arrays.toString(findDiagonalOrder(arr)));
    }

    public int[] findDiagonalOrder(int[][] mat) {

        int row = mat.length;
        int column = mat[0].length;
        int[] res = new int[row*column];
        int startRow = 0,startColumn=0;
        int count = 0;
        while(count<row*column){
            while(startRow >-1&&startColumn<column){
                res[count++] = mat[startRow--][startColumn++];
            }
            if(startColumn==column){
                startRow+=2;
                startColumn--;
            }else{
                startRow++;
            }
            while(startRow<row&&startColumn>-1){
                res[count++] = mat[startRow++][startColumn--];
            }
            if(startRow==row){
                startRow--;
                startColumn+=2;
            }else{
                startColumn++;
            }
        }
        return res;
    }
}
