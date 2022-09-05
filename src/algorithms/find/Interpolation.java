package algorithms.find;

import common.SortUtils;

/**
 * 插值
 */
public class Interpolation {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = seqSearch(arr, 2, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int seqSearch(int[] arr, int target, int left, int right) {
        int leftToTarget = target - arr[left];
        int rightToLeft = arr[right] - arr[left];
        int num = right - left;
        //中间的值的下标 注意此行与二分查找的区别
        int mid = left + leftToTarget * num / rightToLeft;
        //目标值小于中间值  取左侧
        if (arr[mid] > target && left <= right) {
            //递归左侧
            return seqSearch(arr, target, left, mid - 1);
        } else if (arr[mid] < target && left <= right) {
            //目标值大于中间值  取右侧 并且递归
            return seqSearch(arr, target, mid + 1, right);
        } else {
            //不大于也不小于 则是相等
            return mid;
        }
    }
}
