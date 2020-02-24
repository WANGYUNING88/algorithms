###Sparsearray稀疏数组
####1.基本介绍
    当一个数组中大部分元素为0，或者为同一个值时，可以使用稀疏数组来保存该数组。
    稀疏数组的处理方法是：
######    记录数组一共有几行几列，有多少各不同的值
    把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
###### 实例
11*11 的二维数组   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    稀疏数组  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp;  | row        | col    |  val  |      
0 0 1 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| &nbsp;&nbsp; | ---   | ---  | --- |  
0 0 0 2 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 0 | 11   | 11   | 2 |  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 1 | 1   | 2   | 1 |  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| 2 | 2   | 3   | 2 |    
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
0 0 0 0 0 0 0 0 0 0 0       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
######二维数组转稀疏数组的思路
1.遍历原始的二维数组，得到有效数据的个数sum
2.根据sum就就可以创建稀疏数组sparseArr int[sum+1][3]
3.将二维数组的有效数据存到稀疏数组
######稀疏数组转原始二维数组的思路
1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int[11][11];
2.再读取稀疏数组后几行的数据，并赋值给chessArr2原始二维数组
代码详见
