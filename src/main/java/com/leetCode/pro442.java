package com.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class pro442 {

    @Test
    public void test1(){
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                if(nums[i] == nums[nums[i]-1])
                    list.add(nums[i]);
                else{
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp-1] = tmp;
                    i--;
                }
            }
        }
        return list;
    }
}
