##对列
####1.介绍
>队列是一个有效列表，可以用数组或者是链表来实现。遵循先入先出的原则。即先存入队列的数据，要先取出，后存入的要后取出。
####2.数组模拟队列
>队列本身是有序列表，若使用数组的数据结构来存储队列的数据，则队列数组的声明如下，其中maxSize是该队列的对大容量。  
>maxSize-1|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1|&nbsp;&nbsp;|  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0|&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; <-rear=-1  
>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*queue*&nbsp;<-front=-1    
>因为队列的输出、输入是分别从前后端来处理，因此需要两个变量front及rear分别记录队列前后端的下标，front会随着数据输出而改变，而rear则是随着数据输入而改变。
>rear对队列最后【含】front是队列最前元素【不含】  
####当我们将数据存入队列时成为"addQueue"，addQueue的处理需要两个步骤：思路分析
>1)将尾指针往后移：rear+1，当front=rear【空】
>2)若尾指针rear小于队列的最大下标maxSize-1，则将数据存入reat所指的数组元素中，否则无法存入数据。rear=maxSize-1【满】
#### 问题分析和改进
>当队列加满后，即使取出数据以后还是提示“队列满”的失败信息，即使用一次后，不能复用  
>改进：改进成一个循环队列 取模：%
#### 改进思路即--数组模拟环形队列
>1.front变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值时0  
>2.rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做约定。rear的初始值时0  
>3.当队列满时，条件是(rear+1)%maxSize = front【满】  
>4.当队列为空时，条件是rear=front【空】  
>5.当我们这样分析，队列中有效的数据的个数（rear+maxSize-front）%maxSize  
>6.我们就可以在原来的队列修改