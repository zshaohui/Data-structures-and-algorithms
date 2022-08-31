package algorithms.iterativealgorithms;

import java.util.Stack;

/**
 * 迷宫问题
 */
public class Labyrinth {
    static int[][] matrix; //迷宫坐标

    public static void main(String[] args) {
        // 1 代表围墙，2代表走过，-1代表该点不通，避免下次重复搜索
        matrix = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        // 初始化栈
        Stack<int[]> stack = new Stack<>();
        // 初始化四个方向 上下左右
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        // 起点 （1,1）终点（8,8），可以灵活设置
        recursion(1, 1);
        printResult();
    }

    private static boolean recursion(int i, int j) {
        // 递归结束条件，代表已到达终点（8,8）
        if (matrix[8][8] == 2) {
            return true;
        }
        if (matrix[i][j] == 0) {
            matrix[i][j] = 2;
            if (recursion(i - 1, j)) {
                return true;
            } else if (recursion(i + 1, j)) {
                return true;
            } else if (recursion(i, j - 1)) {
                return true;
            } else if (recursion(i, j + 1)) {
                return true;
            } else {
                matrix[i][j] = -1;
                return false;
            }
        } else {
            return false;
        }
    }

    private static void printResult() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

