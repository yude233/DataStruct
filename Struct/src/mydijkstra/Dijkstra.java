package mydijkstra;

import adjmatrix.AdjMatrix;

/**
 * Dijkstr�㷨��Դ���·��
 * @author qaz
 *
 */
public class Dijkstra {
    private boolean[] flag;//flag = ture����s�飬����������·��
    private AdjMatrix adj = new AdjMatrix(); //�ڽӾ���
    private int nodeSize;//������
    private PreNodeAndPath[] pp;//ǰ��·�����飬ֵ��ʾǰ�㵽�ýǱ����·������
    private int MAX_SIZE = 10000;//���·������
    
    public PreNodeAndPath[] getPp() {
        return pp;
    }

    /**
     * ��ʼ��
     * @param sourceNode
     */
    private void init(int sourceNode) {
        adj.initNode();
        adj.initLEdge();//��ʼ�������
        
        nodeSize = adj.getNode().length - 1;//������
        
        flag = new boolean[nodeSize + 1];
        flag[sourceNode] = true;//�׸�������s��
        
        pp = new PreNodeAndPath[nodeSize + 1];//��ʼ��ǰ������
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
     * ���·���㷨
     * @param sourceNode
     */
    public void handle(int sourceNode) {
        init(sourceNode);
        int minPath = 0;//���·��
        int minPathIndex = 0;//���·�����Ǳ�
        for(int i = 1; i <= nodeSize; i++) {
            minPath = MAX_SIZE;
            //����̾���ĵ���ӵ�s��
            for(int j = 1; j <= nodeSize; j++) {
                if(!flag[j] && pp[j].getShortPath() < minPath) {
                    minPath = pp[j].getShortPath();
                    minPathIndex = j;
                }
            }
            if(minPathIndex == 0) {
                System.out.println("error: minPathIndex == 0!!!");
            }
            flag[minPathIndex] = true;//minPathIndex����s��
            //����pp���ľ���ֵ
            for(int k = 1; k <= nodeSize; k++) {
                if(flag[k] == false && pp[minPathIndex].getShortPath() + adj.getEdge()[minPathIndex][k] < pp[k].getShortPath()) {
                    pp[k].setPreNode(minPathIndex);
                    pp[k].setShortPath(pp[minPathIndex].getShortPath() + adj.getEdge()[minPathIndex][k]);
                }
            }
           
        }
    }
}
