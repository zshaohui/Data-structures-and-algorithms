package algorithms.sort;

import common.SortUtils;

/**
 * 归并
 */
public class Merge {
    public static void main(String[] args) {
        int[] arr = SortUtils.generateRandomArray(10, 0, 10);
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr, 0, arr.length - 1);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static void sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边归并排序
            sort(arr, low, mid);
            //右边归并排序
            sort(arr, mid + 1, high);
            // 合并两个有序数组
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            // 对比大小，调整顺序
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 右边剩余元素填充进temp中（因为前面已经归并，剩余的元素必会小于右边剩余的元素）
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 右边剩余元素填充进temp中（因为前面已经归并，剩余的元素必会大于于左边剩余的元素）
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 调整数组顺序
        for (int x = 0; x < temp.length; x++) {
            arr[x + low] = temp[x];
        }
    }
}
