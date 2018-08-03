package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zhang
 * @date 2018/8/3
 * @Description
 */
public class FibonacciSearch {
    private static List<Integer> a = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arrayList = new ArrayList<>();

        System.out.println("请输入想查找的数组(e.g. 5 6 1 3 2 4 7 ;)：");
        while (!in.hasNext(";")){
            arrayList.add(in.nextInt());
        }

        int j = 0;
        int k = 0;
        int l = 1;
        while (j < 30){
            a.add(k);
            int h = k;
            k += l;
            l = h;
            j++;
        }
        System.out.println("斐波那契数组为：\n"+a);

        Collections.sort(arrayList);

        Scanner search = new Scanner(System.in);
        System.out.println("排序后的数组为：\n"+arrayList);
        System.out.println("请输入想查找的数：");
        int t = search.nextInt();
        int result = fibonacciSearch(arrayList,t);
        System.out.println("要查找的数位于第"+(result+1)+"位");
    }

    private static int fibonacciSearch(List<Integer> arrayList, int t){

        int low,high,mid,i,k,length;

        low = 0 ;
        length = arrayList.size()-1;
        high = length;

        k = 0;
        while (high > a.get(k)-1)
            k++;
        for(i = high+1; i < a.get(k) -1; i++){
            arrayList.add(arrayList.get(high));
        }

        while (low <= high){
            mid = low+a.get(k-1)-1;
            if(t < arrayList.get(mid)){
                high = mid-1;
                --k;
            }

            else if(t > arrayList.get(mid)){
                low = mid+1;
                k = k-2;
            }

            else {
                if(mid <= length )
                    return mid;
                else
                    return length;
            }
        }

        return -1;
    }
}
