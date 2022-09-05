package algorithms.find;

/**
 * 顺序(线性)
 */
public class Order {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 2, 5, 6, 10, 99};
        int index = seqSearch(arr, 100);
        if (index == -1) {
            System.out.println("未找到");
        } else {
            System.out.println("数组下标为:" + index);
        }
    }

    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
