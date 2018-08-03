package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Zhang
 * @date 2018/8/3
 * @Description  二分查找/插值查找
 */
public class BinarySearch {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("请输入想查找的数组(e.g. 5 6 1 3 2 4 7 ;)：");
        while (!in.hasNext(";")){
            arrayList.add(in.nextInt());
        }

        Collections.sort(arrayList);

        Scanner search = new Scanner(System.in);
        System.out.println("排序后的数组为：\n"+arrayList);
        System.out.println("请输入想查找的数：");
        int t = search.nextInt();
        int result = binarySearh(arrayList,t);

        if(result < 0)
            System.out.println("在数组中没有该元素！");
        else
            System.out.println("该元素位于数组中的第"+(result+1)+"位");
    }

    private static int binarySearh(ArrayList<Integer> arrayList, int t){

        int start = 0;
        int end = arrayList.size() -1;


        while (start <= end) {
            //int mid = (start + end) / 2;                                   //二分查找
            int mid = start + (t-arrayList.get(start)) * (end - start) / (arrayList.get(end) - arrayList.get(start));          //插值查找
            if (t == arrayList.get(mid))
                return mid;
            else if (t > arrayList.get(mid)) {
                start = mid + 1;
            } else if (t < arrayList.get(mid)) {
                end = mid - 1;
            }
        }

        return -1;

    }
}
