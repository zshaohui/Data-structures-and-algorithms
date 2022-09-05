package algorithms.sort;

import common.SortUtils;

/**
 * 基数
 */
public class Radix {
    public static void main(String[] args) {
        int arr[] = SortUtils.generateRandomArray(10, 0, 1000);
        System.out.printf("排序前:");
        SortUtils.print(arr);
        sort(arr);
        System.out.printf("排序后:");
        SortUtils.print(arr);
    }

    private static int getDigitsNumber(int i) {
        return String.valueOf(i).length();
    }

    private static void sort(int[] array) {
        int max = array[0];
        //获取到最大值的位数
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        int maxBit = getDigitsNumber(max);
        // 二维数组储存每次得到的数
        // 创建二维数组来储存每次得到的数
        int[][] arrays = new int[10][array.length]; // 二维数组里创建十个数组，长度为要排序数组长度
        int[] numberes; // 记录二维数组中每个数组内的个数
        int bit; // 每次取余得到的数
        int index; // 排序数组的索引
        int flag = 0;  // 如果是排个位
        int num = 1;
        while (flag < maxBit) {
            if (flag == 0)
                num = 1;
            else
                num = num * 10;
            numberes = new int[10];
            for (int i = 0; i < array.length; i++) {
                // 拿到每个数的位
                bit = (array[i] / num) % 10; // 取余
                // 添加到二维数组中
                arrays[bit][numberes[bit]] = array[i];
                // 个数加1
                numberes[bit]++;
            }
            // 得到的新数组
            index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < numberes[i]; j++) {
                    array[index] = arrays[i][j];
                    index++;
                }
            }
            flag++;
        }
    }
}
