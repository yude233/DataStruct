package dijkstra;

import adjmatrix.AdjMatrix;

/**
 * 求单元最短路径
 * @author qaz
 *
 */
public class Dijkstra {
    
    private AdjMatrix adj = new AdjMatrix();//用邻接矩阵存储
    
    private int flag[]; //序号为角标的结点，是否求得最短路径：是，1；否0
    
    private int nodeSize;//= 结点数 + 1
    
    private ShortesPath[] sp;
      
    private int MAX_PATH = 10000;
    
    
    public ShortesPath[] getSp() {
        return sp;
    }

    /**
     * 初始化
     */
    private void init(int sourceNode) {
        adj.initNode();
        adj.initLEdge();
        nodeSize = adj.getNode().length;
        flag = new int[nodeSize];
        
        flag[sourceNode] = 1;//已求得最短路径
        
        sp = new ShortesPath[nodeSize];
        
        //初始化存储前点序号和路径长度得数组
        for(int i = 1; i < nodeSize; i++) {
            ShortesPath s = new ShortesPath();
            s.setPathLength(adj.getEdge()[sourceNode][i]);
            if(s.getPathLength() != 0) {//如果有路径
                s.setPreNode(sourceNode);
            }
            sp[i] = s;
        }
    }
    
    
    /**
     * 求结点sourceNode的单元最短路径====存在问题
     * @param sourceNode
     */
    public void handle(int sourceNode) {
        init(sourceNode);
        int minPath;
        int minPathIndex = 0;
        for(int i = 1; i < nodeSize; i++) {
            minPath = MAX_PATH;
            for(int j =  1; j < nodeSize; j++) { //从v-s中选出距离值最小的点
                if(flag[j] == 0 &&
                   sp[j].getPathLength() != 0 && 
                   sp[j].getPathLength() < minPath) {
                    
                    minPath = sp[j].getPathLength();
                    minPathIndex = j;
                }
            }
            flag[minPathIndex] = 1; //minPathIndex点加入s组
            for(int k =1; k < nodeSize; k++) { //修改边集数据，调整距离值
               if(flag[k] == 0 && 
                       (sp[minPathIndex].getPathLength() + adj.getEdge()[minPathIndex][k]) < sp[k].getPathLength()) {
                   sp[k].setPreNode(minPathIndex);
                   sp[k].setPathLength(sp[minPathIndex].getPathLength() + adj.getEdge()[minPathIndex][k]);
               }
            }
        }
    }
    
}
