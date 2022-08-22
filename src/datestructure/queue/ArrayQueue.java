package datestructure.queue;

public class ArrayQueue {

    private int maxSize;//数值的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;// 存放数据

    //构造函数
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //出队
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,显示数据失败");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,头部数据显示失败");
        }
        return arr[front + 1];
    }

}
