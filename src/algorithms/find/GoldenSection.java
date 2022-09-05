package algorithms.find;

import java.util.Arrays;

/**
 * 斐波那契（黄金分割法）
 */
public class GoldenSection {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(fib(arr, 2));
    }


    public static int maxsize = 20;
    //创建斐波那契数列
    public static int[] fibarr() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    // 传入数组，待查数据，返回下标索引值
    public static int fib(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0; // 菲波那切数列分割数值的下标
        int middle = 0;
        int f[] = fibarr();
        // 获取k值
        while (right > f[k] - 1) {
            k++;
        }
        // f[k]可能会大于arr的长度，使用一个新的数组，指向arr
        // 不足的地方使用0填充，实际上需要使用arr最后一个数进行填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        // 循环查找到这个value值
        while (left <= right) {
            middle = f[k - 1] - 1;// 拿到下标进行比较
            if (value < temp[middle]) {
                // 向左查找
                right = middle - 1;
                k--;
            } else if (value > temp[middle]) {
                // 向右查找
                left = middle + 1;
                k -= 2;
            } else {
                // 需要确定返回的是哪个下标 middle or right
                if (middle <= right) {
                    return middle;
                } else {
                    return right;
                }
            }
        }
        return -1;
    }


}
