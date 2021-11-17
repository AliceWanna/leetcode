package com.gt;


import org.junit.Test;

public class EightQueen {

    @Test
    public void test1(){
        EightQueen eightQueen = new EightQueen();
        eightQueen.findAccesible(0);
    }

    public int[] queen;//index --> row , val --> column
    public int count;
    public EightQueen() {
        queen = new int[8];
    }

    public void findAccesible(int row){
        if(row == 8) {
            count++;
            printQueen();
            return;
        }
        for(int i = 0;i<8;i++){
            if(isOk(row,i)){
                queen[row]=i;
                findAccesible(row+1);
            }
        }
    }

    public void printQueen(){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(queen[i] == j){
                    System.out.print("Q");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        System.out.println("---------------------");
    }

    public boolean isOk(int row,int column){
        int left=column-1;
        int right=column+1;
        for(int i =row-1;i>=0;i--){
            if(queen[i] == column)
                return false;
            if(left>=0){
                if(queen[i] == left)
                    return false;
            }
            if(right<8){
                if(queen[i] == right)
                    return false;
            }
            right++;
            left--;
        }
        return true;
    }
}
