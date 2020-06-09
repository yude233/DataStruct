package test;

public class QueueManager {
    
    private Queue q = new Queue();
    
    private char vain = '#';
    
    /**
     * 判队空
     * @return
     */
    public boolean empty() {
        if(q.front == q.rear) {
            return true;
        }
        return false;
    }
    
    /**
     * 初始化队列长度
     * @param length
     */
    public void initQueue(int length) {
        q.data = new char[length];
        q.front = -1;
        q.rear = -1;
        System.out.println("已初始化队列，长度为：" + q.data.length);
    }
    
    /**
     * 入队
     * @param c
     */
    public void enQueue(char c) {
        int rear = q.rear;
        rear = (rear + 1) % q.data.length;//循环队列
        q.rear = rear;
        q.data[q.rear] = c;
    }
    
    /**
     * 出队
     * @param c
     */
    public void deQueue() {
        if(empty()) {
            System.out.println("queue is empty!");
        }else {
            int front = q.front;
            front = (front + 1) % q.data.length;//循环队列
            q.front = front;
            //q.data[q.front] = vain;//出队，队头置空
        }
    }
    
    /**
     * 获取队头元素
     * @return
     */
    public char getFront() {
        if(empty()) {
            System.out.println("queue is empty!");
            return vain;
        }
        
        return q.data[q.front + 1];
    }
    
    /**
     * 打印队列数据
     */
    public void printQueue(){
        if(empty()) {
            System.out.println("queue is empty!");
        }else {
            System.out.println("print queue!");
            for(char c : q.data) {
                System.out.println(c);
            } 
        }    
    }
    
    /**
     * 判断数据是否存在
     * @param c
     * @return
     */
    public boolean isExists(char c) {
        for(char ch : q.data) {
            if(ch == c)
                return true;
        }
        return false;
    }
    
    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        if((q.rear + 1) % q.data.length == q.front) {
            return true;
        }
        return false;
    }
}
