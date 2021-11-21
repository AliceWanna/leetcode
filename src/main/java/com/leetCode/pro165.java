package com.leetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class pro165 {

    public String findLongestWord(String s, List<String> dictionary) {
        String[] strs = (String[]) dictionary.toArray();
        Arrays.sort(strs,
                (o1,o2)->{
                    if(o1.length() != o2.length())
                        return o2.length() - o1.length();
                    else
                        return o1.compareTo(o2);
                }
        );
        for(int i =0;i<strs.length;i++){
            int index=0;
            int j=0;
            while(index < strs[i].length() && j<s.length()){
                if(s.charAt(j++) == strs[i].charAt(index))
                    index++;
            }
            if(index == strs[i].length())
                return strs[i];
        }
        return "";
    }

    @Test
    public void test1(){

        String[] strs = null;
        Arrays.sort(strs,
                (o1,o2)->{
                    if(o1.length() == o2.length())
                        return o2.length() - o1.length();
                    else
                        return o1.compareTo(o2);
                }
        );
//        "1.0.1"
//        "1"
        compareVersion("1.0.1","1");
    }

    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        if(first.length > second.length)
            compareVersion(version2,version1);
        for(int i =0;i<first.length;i++){
            int ver1 = Integer.parseInt(first[i]);
            int ver2 = Integer.parseInt(second[i]);
            if(ver1 != ver2)
                return (ver1<ver2?-1:1);
        }
        return 0;
    }
}
