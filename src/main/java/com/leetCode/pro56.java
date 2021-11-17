package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class pro56 {
    public static void main(String[] args) {
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]
        int [][] arr = new int[5][1];
        arr[0] = new int[]{2, 3};
        arr[1] = new int[]{4,5};
        arr[2] = new int[]{6,7};
        arr[3] = new int[]{8,9};
        arr[4] = new int[]{1,10};

        System.out.println(Arrays.deepToString(Solution.merge(arr)));
    }
}

class Solution {
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        boolean[] isAdd = new boolean[intervals.length];
        for(int i = 0;i<intervals.length;i++){
            if(isAdd[i])
                continue;
            int left = intervals[i][0];
            int right = intervals[i][1];
            for(int j = i+1;j<intervals.length;j++){
                if(isAdd[j] || intervals[j][1]<left || intervals[j][0] > right)
                    continue;
                left = Math.min(intervals[j][0],left);
                right = Math.max(intervals[j][1],right);
                isAdd[j] = true;
            }
            list.add(new int[]{left,right});
        }
        int[][] res = new int[list.size()][];
        for(int i = 0;i<list.size();i++){
            int[] arr = list.get(i);
            res[i] = new int[]{arr[0],arr[1]};
        }
        return res;
    }
}