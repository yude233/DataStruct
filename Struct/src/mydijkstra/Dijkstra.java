package mydijkstra;

import adjmatrix.AdjMatrix;

/**
 * Dijkstr算法求单源最短路径
 * @author qaz
 *
 */
public class Dijkstra {
    private boolean[] flag;//flag = ture的在s组，即已求得最短路径
    private AdjMatrix adj = new AdjMatrix(); //邻接矩阵
    private int nodeSize;//结点个数
    private PreNodeAndPath[] pp;//前点路径数组，值表示前点到该角标结点的路径长度
    private int MAX_SIZE = 10000;//最大路径长度
    
    public PreNodeAndPath[] getPp() {
        return pp;
    }

    /**
     * 初始化
     * @param sourceNode
     */
    private void init(int sourceNode) {
        adj.initNode();
        adj.initLEdge();//初始化有向边
        
        nodeSize = adj.getNode().length - 1;//结点个数
        
        flag = new boolean[nodeSize + 1];
        flag[sourceNode] = true;//首个结点进入s组
        
        pp = new PreNodeAndPath[nodeSize + 1];//初始化前点数组
        for(int i = 1; i <= nodeSize; i++) {
            PreNodeAndPath p = new PreNodeAndPath();
            pp[i] = p;
            int path = adj.getEdge()[sourceNode][i];
            if((path != 0)) {
               p.setPreNode(sourceNode);
               p.setShortPath(path);
            }
        }
        
       
    }
    
    /**
     * 最短路径算法
     * @param sourceNode
     */
    public void handle(int sourceNode) {
        init(sourceNode);
        int minPath = 0;//最短路径
        int minPathIndex = 0;//最短路径结点角标
        for(int i = 1; i <= nodeSize; i++) {
            minPath = MAX_SIZE;
            //将最短距离的点添加到s组
            for(int j = 1; j <= nodeSize; j++) {
                if(!flag[j] && pp[j].getShortPath() < minPath) {
                    minPath = pp[j].getShortPath();
                    minPathIndex = j;
                }
            }
            if(minPathIndex == 0) {
                System.out.println("error: minPathIndex == 0!!!");
            }
            flag[minPathIndex] = true;//minPathIndex加入s组
            //调整pp结点的距离值
            for(int k = 1; k <= nodeSize; k++) {
                if(flag[k] == false && pp[minPathIndex].getShortPath() + adj.getEdge()[minPathIndex][k] < pp[k].getShortPath()) {
                    pp[k].setPreNode(minPathIndex);
                    pp[k].setShortPath(pp[minPathIndex].getShortPath() + adj.getEdge()[minPathIndex][k]);
                }
            }
           
        }
    }
}
