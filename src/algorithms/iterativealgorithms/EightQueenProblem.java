package algorithms.iterativealgorithms;

import lombok.extern.slf4j.Slf4j;

/**
 * 八皇后问题
 */
public class EightQueenProblem {
    /**
     * 皇后的数量
     */
    int max = 8;
    int[] array = new int[max];

    /**
     * 解法数量
     */
    static int count = 0;

    public static void main(String[] args) {
        EightQueenProblem queue8 = new EightQueenProblem();
        queue8.check(0); // 从第一个皇后开始check
        System.out.print("总共的解法： count = " + count);
    }


    private void check(int n) {
        if (n == max) { // n=8表示放第九个皇后，因为n是从0开始的，前面8个已经放好的
            count++;
            this.print();
            return;
        } else {
            //循环i 依次放入皇后
            for (int i = 0; i < max; i++) {
                //先把当前这个皇后n，放到该行的第1列
                array[n] = i; //  n第n个皇后， i表示第i列
                // 判断当放置第n个皇后到i列时，是否冲突
                if (judge(n)) { // 不冲突
                    // 接着放 n+1个皇后，即开始递归
                    check(n + 1); //开始放n+1个皇后
                }
                // 如果冲突，继续执行 array[n] = i; 将第n个皇后，放置本行的后一个位置
            }
        }
    }


    /**
     * 判断是否与上一个皇后冲突
     *
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n]) {
                return false;
            }

            if (Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后的位置
     */
    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
