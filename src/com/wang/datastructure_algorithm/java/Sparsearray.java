package com.wang.datastructure_algorithm.java;

import com.wang.util.ArrayUtils;

/**
 * 稀疏数组
 */
public class Sparsearray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //1表示黑子2表示白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组--");
        ArrayUtils.printArray(chessArr1);
        //将二维数组 转 稀疏数组 的思路
        //1. 先遍历二维数组 得到非0的数据个数
        int sum = 0;
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[i].length;j++){
                if(chessArr1[i][j]!=0)
                    sum++;
            }
        }
        System.out.println("sum=" + sum);
        //创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0数据存储到sparseArr
        int count = 0;//记录第几个非0数据
        for(int i=0;i<chessArr1.length;i++){
            for(int j=0;j<chessArr1[i].length;j++){
                if(chessArr1[i][j]!=0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到是稀疏数组为~~");
        ArrayUtils.printArray(sparseArr);

        //将稀疏数组 --> 原始二维数组
        /**
         * 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int[11][11];
         * 2.再读取稀疏数组后几行的数据，并赋值给chessArr2原始二维数组
         */
        //1. 先读取稀疏数组的一行，根据第一行数据，创建新的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后的几行数据（从第一行开始），并赋值给 原始的二维数组
        for (int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }


        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        ArrayUtils.printArray(chessArr2);

    }
}
