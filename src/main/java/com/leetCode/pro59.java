package com.leetCode;

import org.junit.Test;

import java.util.Arrays;

public class pro59 {
    @Test
    public void test1(){
        System.out.println(Arrays.deepToString(generateMatrix(3)));

    }
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int left = 0,right = n-1,up = 0,down = n-1,tar=1;
        while(tar <= n*n){
            for(int i =left;i<=right;i++){
                arr[up][i] = tar++;
            }
            up++;
            for(int i =up;i<=down;i++){
                tar++;
                arr[i][right] = tar++;
            }
            right--;
            for(int i =right;i>=left;i--){
                tar++;
                arr[down][i] = tar++;
            }
            down--;
            for(int i =down;i<=up;i++){
                tar++;
                arr[i][left] = tar++;
            }
            left++;
        }
        return arr;
    }
}
