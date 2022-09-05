package algorithms.sort;

import common.SortUtils;

/**
 * 希尔排序
 */
public class Shell {
    public static void main(String[] args) {
        int[] arr = SortUtils.generateRandomArray(10, 1, 10);
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    public static int[] sort(int[] array) {
        int len = array.length;
        if (len < 2) {
            return array;
        }
        //当前待排序数据，该数据之前的已被排序
        int current;
        //增量
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                current = array[i];
                //前面有序序列的索引
                int index = i - gap;
                while (index >= 0 && current < array[index]) {
                    array[index + gap] = array[index];
                    //有序序列的下一个
                    index -= gap;
                }
                //插入
                array[index + gap] = current;
            }
            //int相除取整
            gap = gap / 2;
        }
        return array;
    }
}
