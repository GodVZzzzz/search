package search;

import java.util.Scanner;

/**
 * @author Zhang
 * @date 2018/8/3
 * @Description    哈希查找算法，将一个数组放入散列表
 */
public class HashSearch {

    private static final int HASHSIZE = 12;        //散列表长度为数组长度
    private static final int NULLKEY = -32768;

    private static  int m = 0;                //散列表表长

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        int[] a = {12,67,56,16,25,37,22,29,15,47,48,34};
        InitHashTable(hashTable);
        for(int i = 0; i < HASHSIZE; i++){
            InsertHash(hashTable,a[i]);
        }
        System.out.println("生成的哈希表为：");
        for (int i = 0; i < HASHSIZE; i++){
            System.out.println(i+": "+hashTable.elem[i]+",  该数取模为:"+(hashTable.elem[i] % m));
        }

        System.out.println("输入要查找的关键字：");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {

            int isSuccess = SearchHash(hashTable, in.nextInt());
            if (isSuccess >= 0) {
                System.out.println("该数位于散列表的" + isSuccess + "位");
            } else
                System.out.println("查无此数！");
        }

    }

    /*初始化哈希表*/
    private static boolean InitHashTable(HashTable hashTable){
        int i;
        m = HASHSIZE;
        hashTable.count = m;
        hashTable.elem = new int[m];
        for (i = 0; i < m; i++){
            hashTable.elem[i] = NULLKEY;
        }
        return true;
    }

    /*插入*/
    private static void InsertHash(HashTable hashTable, int key){
        int addr = Hash(key);
        while (hashTable.elem[addr] != NULLKEY)
            addr = (addr+1) % m;
        hashTable.elem[addr] = key;
    }

    /*查找*/
    private static int SearchHash(HashTable hashTable,int key){
        int addr = Hash(key);
        while (hashTable.elem[addr] != key){
            addr = (addr + 1) % m;
            if(hashTable.elem[addr] == NULLKEY || addr == Hash(key)){
                return -1;
            };
        }
        return addr;
    }

    /*散列函数*/
    private static int Hash(int key){
        return key % m;
    }
    /*哈希表结构*/
    private static class HashTable{
        int[] elem;            //元素存储基址，动态分配数组
        int count;           //元素个数
    }
}
