package com.leetCode;

public class pro306 {
    String str;
    int len;
    public boolean isAdditiveNumber(String num) {
        this.str = num;
        this.len = num.length();
        return dfs(0,0,0,0);
    }

    public boolean dfs(int index,int count,long sum,long pres){
        if(index == len)
            return count>2;
        long value = 0;
        for(int i = index;i<len;i++){
            if(i>index && str.charAt(index) == '0')
                break;
            value = value*10 + str.charAt(i) - '0';
            if(count >= 2){
                if(value < sum)
                    continue;
                else if(value > sum)
                    break;
            }
            if(dfs(i+1,count+1,pres+value,value))
                return true;
        }
        return false;
    }
}
