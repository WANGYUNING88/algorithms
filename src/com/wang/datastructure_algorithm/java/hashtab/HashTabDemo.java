package com.wang.datastructure_algorithm.java.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("【add】--> 添加员工");
            System.out.println("【list】--> 显示员工");
            System.out.println("【find】--> 查找员工");
            System.out.println("【exit】--> 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入查找的员工id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

//创建哈希表 管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;
//    构造器

    public HashTab(int size) {
        //初始化 empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        this.size = size;

        //分别初始化每一个链表
        for (int i = 0;i<size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //编写一个散列函数(简单的取模法)
    public int hashFun(int id) {
        return id % size;
    }

    //添加员工
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到那条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp 加入到对应的链表中
        empLinkedLists[empLinkedListNo].add(emp);
    }

    //查询员工信息
    public void findEmpById(int id){
        //使用散列函数，获取到那条链表
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].findEmpById(id);
        if (emp==null){
            System.out.printf("在哈希表中，无法找到NO.%d的员工信息!\n",id);
        }else {
            System.out.printf("在哈希表的第%d条链表中，找到了NO.%d的员工信息【id = %d, name = %s】!\n",empLinkedListNo+1,id,emp.id,emp.name);
        }
    }

    //遍历所有的链表
    public void list() {
        for (int i = 0;i<size;i++){
            empLinkedLists[i].list(i);
        }
    }
}

//表示一个员工（节点node）
class Emp {
    int id;
    String name;
    Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建 EmpLinkedList ,表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp，因此这个链表的head 是直接指向的第一个Emp
    private Emp head;//默认为空

    //添加员工(入职)
    public void add(Emp emp) {
        //说明
        //1.假定添加员工时，id 是自增的，因此将该雇员直接加入到本链表最后即可
        if (head == null) {
            //头节点是空的，说明此时员工是第一个
            head = emp;
            return;
        }
        //不是第一个
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表的员工信息
    public void list(int no) {
        if (head == null) {
            System.out.printf("第 %d 条链表为空\n",no+1);
            return;
        }
        Emp curEmp = head;
        System.out.printf("第 %d 条链表的信息：\n",no+1);
        while (curEmp != null) {
            System.out.printf("  => id=%d name=%s\n", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
    }

    //根据id 查找员工
    public Emp findEmpById(int id){
        //判断链表是否为空
        if (head == null){
            System.out.printf("链表为空，无法找到NO.%d的员工信息!\n",id);
            return null;
        }
        Emp curEmp = head;//辅助指针
        while (curEmp!=null){
            if (curEmp.id == id){
                return curEmp;
            }
            curEmp = curEmp.next;
        }
        return null;
    }
}
