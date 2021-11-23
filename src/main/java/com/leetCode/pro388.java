package com.leetCode;

import org.junit.Test;

public class pro388 {

    @Test
    public void test1(){
        System.out.println(lengthLongestPath(

                "a\n\tb.txt\na2\n\tb2.txt"));
    }
    public int lengthLongestPath(String input) {
        int[] arr=new int[25];
        int level = 0;
        int len=0;
        int max=0;
        for(int i =0;i<input.length();i++){
            char c=input.charAt(i);
            switch(c){
                case '\n':
                    if(len!=0){
                        if(level==0)
                            arr[0]=len;
                        else
                            arr[level] = arr[level-1]+len;
                    }
                    len=0;
                    level=0;
                    break;
                case '\t':
                    level++;
                    break;
                case '.':
                    while(i<input.length()&&input.charAt(i)!='\n'){
                        len++;
                        i++;
                    }
                    i--;
                    max=Math.max(max,arr[level-1]+level+len);
                    level=0;
                    len=0;
                    break;
                default:
                    len++;
                    break;
            }
        }
        return max;
//        Deque<Integer> stack = new ArrayDeque<>();
//        int level = 0;
//        int count=0;
//        int max=0;
//        int sum=0;
//        for(int i=0;i<input.length();i++){
//            char c = input.charAt(i);
//            switch(c){
//                case '\n':
//                    if(count!=0){
//                        if(level!=0){
//                            stack.push(count);
//                            sum+=count;
//
//                        }else{
//                            stack.clear();
//                            sum=count;
//                            stack.push(count);
//                        }
//                    }
//                    count=0;
//                    level=0;
//                    break;
//                case '\t':
//                    int row = 0;
//                    while(i<input.length()&&input.charAt(i) == '\t'){
//                        row++;
//                        i++;
//                    }
//                    i--;
//                    level=row;
//                    while(stack.size()!=row){
//                        sum-=stack.pop();
//                    }
//                    break;
//                case '.':
//                    int res = 0;
//                    while(i<input.length()&&input.charAt(i) != '\n'){
//                        count++;
//                        i++;
//                    }
//                    if(level!=0)
//                        res = count+sum+stack.size();
//                    else
//                        res=count;
//                    count=0;
//                    i--;
//                    max=Math.max(res,max);
//                    break;
//                default:
//                    count++;
//                    break;
//            }
//        }
//        return max;
    }
}
