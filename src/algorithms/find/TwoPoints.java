package algorithms.find;

import common.SortUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class TwoPoints {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 2, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> index = BinarySearch(arr, 0, arr.length - 1, 2);
        if (index == null || index.isEmpty()) {
            System.out.println("未找到");
        } else {
            for (Integer integer : index) {
                System.out.printf("数组下标为:" + integer + " ");
            }
        }
    }


    /**
     * 返回集合
     * int arr[]:排好序的数组
     * int left：左边下标
     * int right：右边索引
     * int findVal：要找的元素
     * return：返回一个集合，为全部该数值的下标
     */
    public static List<Integer> BinarySearch(int arr[], int left, int right, int findVal) {
        //中间下标
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //如果左索引大于右索引，返回一个空链表
        if (left > right) {
            return new ArrayList<Integer>();
        }
        //创建一个链表
        List<Integer> list = new ArrayList();
        //如果要找的元素findVal大于中间值midVal，则在数组的右边,向右进行递归
        if (midVal < findVal) {
            return BinarySearch(arr, mid + 1, right, findVal);
        } else if (midVal > findVal) {
            //如果要找的元素findVal小于中间值midVal，则在数组的左边，向左进行递归
            return BinarySearch(arr, left, mid - 1, findVal);
        } else {
            //定义一个在中间下表前前一个下标temp
            int temp = mid - 1;
            while (true) {
                //判断，如果下标小于0或者不等于要找的元素findVal，则退出循环，
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //说明下标temp对应数组的值都等于findVal，加入链表
                list.add(temp);
                temp--;
            }
            //注意 ：这里不要忘记加入mid
            list.add(mid);
            //重新定义temp为mid后一个下标
            temp = mid + 1;
            while (true) {
                if (temp > right || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
        }
        //返回链表
        return list;
    }


    /**
     * 不适用递归
     */
    private static int seqSearch2(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value < arr[left] || value > arr[right] || right < left) {
            return -1;
        }
        while (left < right) {
            mid = (left + right) / 2;
            if (value > arr[mid]) {
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = midVal - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 使用递归查询
     */
    private static int seqSearch(int[] arr, int left, int right, int value) {
        //找到中间位置
        int mid = (left + right) / 2;
        //找到中间下标在数组中对应的值
        int midValue = arr[mid];
        //进行判断，如果左边下标大于右边下标，表示已经遍历完数组,没有找到该元素，返回-1；
        if (left > right) {
            return -1;
        }
        //如果要找的元素findVal大于中间值midVal，则在数组的右边，向右进行递归，
        if (midValue < value) {
            return seqSearch(arr, mid + 1, right, value);
        } else if (midValue > value) {
            //如果要找的元素findVal小于中间值midVal，则在数组的左边，向左进行递归；
            return seqSearch(arr, left, mid - 1, value);
        } else {
            //说明找到了该元素，返回该元素对应的下标mid；
            return mid;
        }
    }
}
