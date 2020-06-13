package prim;

import java.util.ArrayList;
import java.util.List;

import adjmatrix.AdjMatrix;

/**
 * prim算法求最短路径
 * @author qaz
 *
 */
public class Prim {
    private boolean visited[]; //记录结点是否遍历过，是：1，否：0
    
    private int[] node;
    private int last = 0; //记录node下标
    
    private void handle(AdjMatrix adj) {
        
        
        List<Edge> edges = new ArrayList<Edge>();
        Edge minValue = new Edge();
        for(int i : node) {
            for(int j = 1; j < adj.getNode().length; j++) {
                //如果这条边存在，且点未遍历
                if((!visited[j]) && (adj.getEdge()[i][j] != 0)) {
                    Edge e = new Edge();
                    e.setFrom(i);
                    e.setTo(j);
                    e.setValue(adj.getEdge()[i][j]);
                    edges.add(e);
                }
            }
        }
        minValue = edges.get(0);//初始赋值第一条边权值
        for(Edge e : edges) {
            if(e.getValue() < minValue.getValue()) {//将最小权值结点记录
                minValue = e;
                
            }
        }
        last++;
        node[last] = minValue.getTo();
        visited[minValue.getTo()] = true;//将已遍历结点标记为true
        if(last < node.length - 1) {//如果结点未遍历完，递归执行
            handle(adj);
        }
        
        
        
    }
    
    /**
     * 执行prim算法
     * @param adj
     */
    public int[] process(AdjMatrix adj) {
        //赋初值
        int size = adj.getNode().length;
        visited = new boolean[size];
        node = new int[size];
        last++;
        node[last] = adj.getNode()[1];//开始先将第一个结点选出
        visited[1] = true;//结点1已被查看即遍历过
        handle(adj);
        return node;
    }
    
}
