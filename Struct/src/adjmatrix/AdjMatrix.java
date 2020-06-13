package adjmatrix;

import java.util.Scanner;

/**
 * 邻接矩阵
 * @author qaz
 *
 */
public class AdjMatrix {
    private int[] node;//结点
    private int[][] edge;//边
    
    
    public int[] getNode() {
        return node;
    }

    public int[][] getEdge() {
        return edge;
    }

    /**
     * 初始化结点
     */
    public void initNode() {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入结点个数：");
        size = sc.nextInt();
        node = new int[size + 1]; //下标从1开始
        for(int i = 1; i <= size; i++) {
            System.out.println("请输入结点序号：");
            node[i] = sc.nextInt();
        }
        
    }
    
    //初始化边
    public void initEdge() {
        int size = 0;
        int from, to; //起点、终点
        
        //初始化边
        edge = new int[node.length][node.length];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入边个数：");
        size = sc.nextInt();
        for(int i = 1; i <= size; i++) {
            System.out.println("请输入边起点：");
            from = sc.nextInt();
            System.out.println("请输入边终点：");
            to = sc.nextInt();
            System.out.println("请输入边权值：");
            edge[from][to] = edge[to][from] = sc.nextInt();
        }
    }
   
    
}
