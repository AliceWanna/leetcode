package com.leetCode;

import java.util.Arrays;

public class pro552 {
    public int findLUSlength(String[] strs) {
        if(strs.length==1)
            return strs[0].length();
        Arrays.sort(strs,
                (o1,o2)->o2.length()-o1.length()
        );
        for(int i = 0;i<strs.length;i++){
            boolean isSub = false;
            for(int j=0;j<strs.length;j++){
                if(j!=i){
                    isSub = isSub(strs[i],strs[j]);
                    if(isSub)
                        break;
                }
            }
            if(!isSub)
                return strs[i].length();
        }
        return -1;
    }
    public boolean isSub(String target,String isSubStr){
        if(target.length() >= isSubStr.length())
            return (target.length() == isSubStr.length()?target.equals(isSubStr):false);
        int index = 0;
        int subIndex = 0;
        while(index < target.length() && subIndex < isSubStr.length()){
            if(target.charAt(index) == isSubStr.charAt(subIndex++))
                index++;
        }
        return index==target.length();
    }
}
