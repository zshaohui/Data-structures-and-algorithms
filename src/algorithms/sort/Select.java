package algorithms.sort;

import common.SortUtils;

/**
 * 选择排序
 */
public class Select {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 6, 8, 9, 2, 3, 5, 4, 7};
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
                    minIndex = j;
                    minNum = arr[j];
                }
            }
            //值互换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }
        }
    }
}
