package algorithms.sort;

import common.SortUtils;

/**
 * 快速排序
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = SortUtils.generateRandomArray(10, 0, 10);
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr, 0, arr.length - 1);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low > high) return;
        int i = low, j = high, basePosition, temp;

        basePosition = arr[low]; //基位
        while (i < j) {
            while (basePosition <= arr[j] && i < j) {
                j--;
            }
            while (basePosition >= arr[i] && i < j) {
                i++;
            }
            if (i < j){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = basePosition;
        //递归调用左半数组
        sort(arr, low, j-1);
        //递归调用右半数组
        sort(arr, j+1, high);
    }
}
