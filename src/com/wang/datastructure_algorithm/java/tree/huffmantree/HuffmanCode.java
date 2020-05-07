package com.wang.datastructure_algorithm.java.tree.huffmantree;

import java.util.*;

public class HuffmanCode {

    //生成哈夫曼树对应的哈夫曼编码
    //思路：
    //1、将哈夫曼编码表存放在Map<Byte,String>  32->01 97->100 ...
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2、在生成哈夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
        String content = "wo jiao wang yu ning fs sdfs  sdfs sd sswerwt ry";
        byte[] huffmanzip = huffmanzip(content);
//        byteToBitString(huffmanzip[0]);
        byte[] decode = decode(huffmanCodes, huffmanzip);
        System.out.println("原来的字符串="+new String(decode));//i like like like java do you like a java

    }

    ///////////////////////////数据解压/////////////////////////////
    //思路
    //1、将 zip 的byte数组 重新转成 哈夫曼编码对应的二进制 字符串
    //2、将 哈夫曼编码对应的二进制 字符串 对照 哈夫曼编码表 重新 转成 字符串

    /**
     * 完成堆数据的解码
     *
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmamBytes 哈夫曼编码得到的字节数组
     * @return 原字符串对应的字节数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmamBytes) {
        //1.先得到huffmanBytes 对应的 二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组 转成二进制的字符串
        for (int i = 0; i < huffmamBytes.length; i++) {
            stringBuilder.append(byteToBitString(!(i == huffmamBytes.length - 1), huffmamBytes[i]));
        }
        System.out.println("哈夫曼字节数组转成后的二进制字符串=" + stringBuilder.toString());

        //把字符串按照指定的哈夫曼编码进行解码
        //把哈夫曼编码表进行调换 原表<key,value>->新表<value,key>
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
//        System.out.println("map="+map);
        //创建一个集合，存放byte
        ArrayList<Byte> list = new ArrayList<>();
        StringBuilder key = null;
        for (int i =0;i<stringBuilder.length();){
            Byte b = null;
            key = new StringBuilder();
            while (b==null&&i<stringBuilder.length()){
                key.append(stringBuilder.substring(i++,i));
                b = map.get(key.toString());
            }
            list.add(b);
        }

        //当for循环结束后，list存放了所有字符
        byte []b = new byte[list.size()];
        for (int i =0;i<b.length;i++){
            b[i] = list.get(i);
        }

        return b;
    }

    /**
     * 将一个byte 转成 二进制的字符串
     *
     * @param flag 是否要补位的标识 true 需要 false 不需要
     * @param b
     * @return
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;//将 b 转成 int

        if (flag)
            //如果是正数 还需要 补位 比如 1 就是 的 二进制就是 1 => 0000 0001
            temp |= 256;//按位或运算 256 => 1 0000 0000 | 0 0000 0001 = 1 0000 0001

        String string = Integer.toBinaryString(temp);//返回的是 temp 对应的 二进制补码

        if (flag)
            return string.substring(string.length() - 8);
        else
            return string;
    }

    ///////////////////////////数据压缩/////////////////////////////

    /**
     *  //封装所有方法的调用，到一个方法
     * @param content 原始的字符串
     * @return
     */
    private static byte[] huffmanzip(String content){
        //测试获取content 对应的bytes 数组
        byte[] bytes = content.getBytes();
        System.out.println(bytes.length);//40

        //测试 哈夫曼树
        System.out.println("哈夫曼树");
        TreeNode huffmanTree = createHuffmanTree(getNodes(bytes));
        preOrder(huffmanTree);

        //测试 哈夫曼编码表
        Map<Byte, String> codes = getCodes(huffmanTree);
        System.out.println("哈夫曼编码表");
        System.out.println(codes);

        //测试stringBuilder
        byte[] zip = zip(bytes, codes);
        System.out.println("哈夫曼编码表处理后的byte[] 数组");
        System.out.println(Arrays.toString(zip));

        return zip;
    }

    /**
     * 将一个字符串对应的byte[] 数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码表处理后的byte[] 数组
     *
     * @param bytes        原始的byte[] 数组
     * @param huffmanCodes 生成的哈夫曼编码表
     * @return 一个哈夫曼编码表处理后的byte[] 数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1、利用哈夫曼编码表 将byte[] 数组 转成的哈夫曼编码对应的 字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历 bytes 数组
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println("测试stringBuilder(old)：" + stringBuilder.toString());

        //将 stringBuilder 转成 bytes[]
        int len = (stringBuilder.length() + 7) / 8;

        //创建 存储压缩后byte 数组
        byte[] buffmanCodesBytes = new byte[len];
        String string;
        int index = 0;//记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {//因为是每8位对应一个byte
            string = stringBuilder.substring(i,(i+8)>stringBuilder.length()?stringBuilder.length():i+8);
            //将 string 转成一个 byte 放入到 buffmanCodesBytes
            buffmanCodesBytes[index++] = (byte) Integer.parseInt(string,2);
        }

        return buffmanCodesBytes;
    }

    //重载
    private static Map<Byte, String> getCodes(TreeNode node) {
        if (node == null)
            return null;
        //处理node 的左子树
        getCodes(node.left, "0", stringBuilder);
        getCodes(node.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的 node节点 的所有叶子节点的哈夫曼编码得到，并放入到 huffmanCodes集合
     *
     * @param node          传入的 node节点
     * @param code          路径：左子节点 0 右子节点 1
     * @param stringBuilder 用于拼接路径的
     */
    private static void getCodes(TreeNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code 加入到 stringBuilder1
        stringBuilder1.append(code);
        if (node != null) {
            //判断当前节点是 叶子 还是 非叶子
            if (node.data == null) {
                //说明是 非叶子节点
                //向左 递归
                getCodes(node.left, "0", stringBuilder1);
                //向右 递归
                getCodes(node.right, "1", stringBuilder1);
            } else {
                //说明是 叶子节点
                //放入到 huffmanCodes 中
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    /**
     * 接受一个字节数组，转成一个 list集合结合
     *
     * @param bytes
     * @return
     */
    private static List<TreeNode> getNodes(byte[] bytes) {
        //1、 创建一个arraylist
        ArrayList<TreeNode> nodes = new ArrayList<>();

        //遍历bytes ， 统计 存储每个byte出现的次数 -> map[key,value]
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            map.put(b, map.containsKey(b) ? map.get(b) + 1 : 1);
        }

        //把map中 每个键值对转成一个Node对象，并加入到 nodes 集合中
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new TreeNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 传入一个list集合，生成哈夫曼树
     *
     * @param nodes
     * @return
     */
    private static TreeNode createHuffmanTree(List<TreeNode> nodes) {
        while (nodes.size() > 1) {
            //1、先排序（从小到大）
            Collections.sort(nodes);

            //2、取出最小的两个
            TreeNode left = nodes.get(0);
            TreeNode right = nodes.get(1);

            //3、创建一个新的二叉树节点（没有data，只有权值）
            TreeNode parent = new TreeNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            //4、移除已经处理过的树节点
            nodes.remove(0);
            nodes.remove(0);

            //5、将新的二叉树加入到nodes
            nodes.add(parent);
        }

        //此时 nodes 中只有一个树
        return nodes.get(0);
    }

    /**
     * 前序遍历的方法
     *
     * @param node
     */
    private static void preOrder(TreeNode node) {
        if (node == null)
            return;
        node.preOrder();
    }
}

//创建节点
class TreeNode implements Comparable<TreeNode> {
    Byte data;//存放数据本身，比如'a' => 97 ,' ' => 32
    int weight;//权值(字符 data 在字符串中出现的次数)
    TreeNode left;
    TreeNode right;

    public TreeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }
}