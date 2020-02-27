package com.wang.datastructure.java.stack;

import com.wang.util.OperationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PolandNotationt {
    public static void main(String[] args) {
        //根据前面的思路，完成表达式的运算
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//是否退出菜单
        String key = "";
        while(loop){
            System.out.println("请输入【任意字符】进入计算系统或者【exit/退出】退出系统");
            key = scanner.next();
            switch (key){
                case "退出":
                    scanner.close();
                    loop=false;
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    boolean flag = true;
                    while (flag){
                        System.out.println("计算器模式");
                        System.out.println("请输入表达式计算或者输入【back/返回】返回上一级");
                        key = scanner.next();
                        if(!key.equals("返回")&&!key.equals("back")){

                            //思路（中缀表达式转后缀表达式）
                            //1. 我们不方便对字符串遍历和操作，因此，可以将key中缀加入到对应list中
                            List<String> list = toInfixExpressionList(key);
                            System.out.printf("中缀表达式是【 %s 】\n",list);
                            //2. 将得到的中缀表达式的list-》后缀表达式的list
                            List<String> list1 = parseSuffixExpressiongList(list);
                            System.out.printf("后缀表达式是【 %s 】\n",list1);


//                            //思路（后缀表达式直接计算）
//                            //1.先将suffixExpression放入到ArrayList中
//                            List<String> listString = getListString(key);
//                            //将list传入到一个计算方法中
                            int calculator = calculator(list1);
                            System.out.printf("%s = %d\n", key, calculator);

                        }else {
                            flag = false;
                            System.out.println("返回上一级");
                        }
                    }
                    break;
            }
        }
        System.out.println("退出系统~~");

    }

    //将得到的中缀表达式的list-》后缀表达式的list
    public static List<String> parseSuffixExpressiongList(List<String> ls) {
        //定义两个栈
        Stack<String> stack1 = new Stack<>();//符号栈
        //因为stack2这个栈，在整个过程中出栈操作，后面还要逆序，我们可以不用栈队列后者list
        List<String> stack2 = new ArrayList<String>();//辅助栈（储存中间结果）

        //遍历ls
        for(String s : ls){
            //如果是一个数就入s1栈
            if(s.matches("\\d+")){
                stack2.add(s);
            }else if (s.equals("(")){
                stack1.push(s);
            }else if (s.equals(")")){
                //如何是右括号，则依次弹出stack1栈的运算符，并压入stack2中，直至遇到右括号为止
                while (!stack1.peek().equals("(")){
                    stack2.add(stack1.pop());
                }
                stack1.pop();//将stack1中左括号弹出，消除一对括号
            }else {
                // 当s的运算符的优先级小于或等于stack1栈顶的运算符的
                // 将stack1的运算符弹出并加入stack2中，
                // 再次转到4.1与stack1中新的栈顶运算符比较
                // 需要一个比较优先级高级的方法
                while (!stack1.isEmpty() && OperationUtils.getLevel(stack1.peek())>=OperationUtils.getLevel(s)){
                    stack2.add(stack1.pop());
                }
                //需要将s压入栈中
                stack1.push(s);
            }
        }
        //将stack1中剩余的依次加入stack2；
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2;
    }

    //将中缀表达式放入到对应的list中
    public static List<String> toInfixExpressionList(String expression) {
        //存放表达式中的内容
        List<String> list = new ArrayList<String>();
        int i = 0;//指针，用于遍历表达式字符转
        String string ;//作多位数的拼接
        char c;//没遍历到一个字符就存放到c中；
        do{
            //如果c是一个非数字，就需要加入到list中
            //0[48]->9[57]
            if ((c=expression.charAt(i))<48||(c=expression.charAt(i))>57){
                list.add(""+c);
                i++;
            }else {
                //是一个数，需要考虑对位数；
                string = "";//初始化为空串
                while (i<expression.length()&&(c=expression.charAt(i))>=48&&(c=expression.charAt(i))<=57){
                    string += c;
                    i++;
                }
                list.add(string);
            }
        }while (i<expression.length());
        return list;
    }

    //将一个逆波兰表达式，依次放入到list中
    public static List<String> getListString(String suffixExpression) {
        //分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //逆波兰表达书计算方法
    public static int calculator(List<String> listString) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历 listString
        for (String item : listString) {
            //判断数（正则）
            if (item.matches("\\d+")) {//匹配多位数
                //直接入栈
                stack.push(item);
            } else {
                //运算符 出栈两个数和当前符号运算，结果入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符非法~~");
                }
                stack.push("" + res);
            }
        }
        //栈中只有一个数据就是结果了
        return Integer.parseInt(stack.pop());
    }
}


