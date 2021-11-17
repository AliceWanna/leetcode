package com.gt;

import org.junit.Test;

import java.util.Arrays;





public class CountSort {

    @Test
    public void test1(){
        int[] a = {0,3,3,2,5,6,7,2,3,9,6,5};
        countSort(a,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public void countSort(int a[],int index){
        if(index <=1)
            return;
        int max = a[0];
        for (int i = 1; i <= index; i++) {
            if(a[i] > max)
                max = a[i];
        }
        int [] arr = new int[max + 1];
        for (int i = 0; i <= index; i++) {
            arr[a[i]]++;
        }

        for (int i = 1; i < max + 1; i++) {
            arr[i] = arr[i] + arr[i-1];
        }
        int i = 0;
        int[] copy = new int[index + 1];
        while (i<=index){
            copy[--arr[a[i]]] = a[i];
            i++;
        }
        for (int j = 0; j < index+1; j++) {
            a[j] = copy[j];
        }
    }

    @Test
    public void test2() {
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
        System.out.println(countAndSay(9));
        System.out.println(countAndSay(10));
    }

    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = countAndSay(n-1);
        int[] cc = new int[10];
        StringBuilder tar = new StringBuilder(32);
        int tmp;
        int des = str.charAt(0)-'0';
        cc[str.charAt(0)-'0']++;
        for(int i = 1 ;i<str.length();i++){
            cc[str.charAt(i)-'0']++;
            if(str.charAt(i) != str.charAt(i-1)){
                tmp = str.charAt(i-1)-'0';
                tar.append(cc[tmp]).append(tmp);
                cc[tmp] = 0;
                des = str.charAt(i)-'0';
            }
        }
        tar.append(cc[des]).append(des);
        return tar.toString();
    }
}
