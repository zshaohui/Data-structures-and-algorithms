package common;

public class SortUtils {

    private SortUtils() {
    }

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        return arr;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }
}
