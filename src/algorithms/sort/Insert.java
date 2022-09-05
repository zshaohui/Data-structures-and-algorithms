package algorithms.sort;

import common.SortUtils;

/**
 * 插入排序
 */
public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[]{53, 27, 36, 15, 69, 42};
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static void sort(int[] arr) {
        int j;
        //i=1；从1开始，没必要和自己比
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                //符合条件的往后移动一位
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }
}
