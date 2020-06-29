package topological;

import adjmatrix.AdjMatrix;

/**
 * �������޻�ͼ��������
 * @author qaz
 *
 */
public class TopologicalSort {
    private AdjMatrix adj = new AdjMatrix();
    private int nodeSize;
    private int visited[];
    private int edge[][];
    private int sort[];
    private int last = 0; //lastΪsort�±�
    
    private int MAX_SIZE = 10000;
    private void init() {
        adj.initNode();
        adj.initLEdge();
        nodeSize = adj.getNode().length - 1;
        visited = new int[nodeSize + 1];
        edge = new int[nodeSize + 1][nodeSize + 1];
        edge = adj.getEdge();
        sort = new int[nodeSize + 1];
    }
    
    public void handle() {
        init();
        for(int k = 1; k <= nodeSize - last; k++) {//ÿ��ѭ���ҵ�һ�����
            for(int i = 1; i <= nodeSize; i++) {
                if(visited[i] == 1) continue;
                boolean flag = true;
                for(int j = 1; j <= nodeSize; j++) {
                    if(edge[j][i] != 0 && edge[j][i] < MAX_SIZE) {
                        flag = false;
                    }
                }
                if(flag == true) {
                    visited[i] = 1;
                    sort[i] = ++last;
                    //���ڽӾ������ֵ��Ϊ0
                    for(int n = 1; n <= nodeSize; n++) {
                        edge[i][n] = 0;
                    }
                }
            }
        }
    }
    
    public void printSort() {
        for(int i = 1; i <= nodeSize; i++) {
            System.out.println(i + " : " + sort[i]);
        }
    }
    
}
