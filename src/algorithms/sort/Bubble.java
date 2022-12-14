package algorithms.sort;

import common.SortUtils;

/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        int arr[] = new int[]{-2, 3, 2};
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr); //开始排序
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
