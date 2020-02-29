package com.wang.datastructure_algorithm.java.recursion;

public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙，初始化为1
        //上下
        for (int i = 0 ;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右
        for (int i = 1 ;i<7;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //障碍
        map[3][1] = 1;
        map[3][2] = 1;

       // map[1][2] = 1;
        map[2][2] = 1;

        //输出地图
        for (int i =0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使使用方法，找路
        setWay(map,1,1);

        //输出新地图
        System.out.println("小球探索过的路线");
        for (int i =0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯找路径
     * 约定 [i,j]为开始的位置，[0]为未走的地方 ,[6][5]是终点
     * [1]为不通的地方,[2]表示通路可走,[3]表示已经走过的地方，但是不通
     * 走迷宫时，确定一个移动策略（移动顺序）下->右->上->左，
     * @param map 地图
     * @param i
     * @param j 开始的位置的坐标
     * @return 通路与否
     */
    public static boolean setWay(int[][] map,int i,int j) {
        if (map[6][5]==2)
            return true;
        else {
            if (map[i][j]==0){
                //此地为探索
                map[i][j] = 2;//假定此路线通
                if (setWay(map,i+1,j)){
                    //下
                    return true;
                }else if (setWay(map,i,j+1))
                    //右
                    return true;
                else if (setWay(map,i-1,j))
                    //上
                    return true;
                else if (setWay(map,i,j-1))
                    //上
                    return true;
                else {
                    //下->右->上->左各点都不同
                    map[i][j] = 3;
                    return false;
                }
            }
            else {
                //不是0，就可能是123，说明走过了
                return false;
            }
        }
    }
}
