package com.wang.leetcode1_30;

import com.sun.org.apache.regexp.internal.RE;

public class T29_divide {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     *
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *
     *  
     *
     * 示例 1:
     *
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例 2:
     *
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     *  
     *
     * 提示：
     *
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        System.out.println(dividend+" "+divisor);
        if (divisor==1)
            return dividend;
        if (divisor==-1){
            if (dividend==Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }
        boolean symbol = (dividend>0)^(divisor>0);
        dividend = dividend<0?dividend:-dividend;
        divisor = divisor<0?divisor:-divisor;
        if (dividend>divisor)
            return 0;
        int i = closeDividend(dividend, divisor);
        return symbol?-i:i;
    }
    public static int closeDividend(int dividend, int divisor){
        if (dividend>divisor)
            return 0;
        int result = 1;
        int temp = divisor;
        while (temp+temp<0&&temp+temp>=dividend){
            result<<=1;
            temp<<=1;
        }
        System.out.print(result);
        return result+closeDividend(dividend-temp,divisor);
    }
    public static void main(String[] args) {
        /**
         * -2147483648
         * -1
         */
        System.out.println(divide(-2147483648, -1));
//        System.out.println(Integer.MIN_VALUE);
    }
}
