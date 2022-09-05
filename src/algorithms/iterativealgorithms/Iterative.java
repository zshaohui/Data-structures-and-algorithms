package algorithms.iterativealgorithms;

/**
 * 迭代算法
 */
public class Iterative {

    public static void main(String[] args) {
        int result = factorial(4);
        System.out.println(result);
    }


    /**
     * 阶乘问题
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n - 1) * n;
    }

    /**
     * 打印问题
     * @param n
     */
    public static void print(int n) {
        if (n > 0) {
            print(n - 1);
        }
        System.out.println(n);
    }

}
