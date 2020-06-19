package dijkstra;

import adjmatrix.AdjMatrix;

/**
 * ��Ԫ���·��
 * @author qaz
 *
 */
public class Dijkstra {
    
    private AdjMatrix adj = new AdjMatrix();//���ڽӾ���洢
    
    private int flag[]; //���Ϊ�Ǳ�Ľ�㣬�Ƿ�������·�����ǣ�1����0
    
    private int nodeSize;//= ����� + 1
    
    private ShortesPath[] sp;
      
    private int MAX_PATH = 10000;
    
    
    public ShortesPath[] getSp() {
        return sp;
    }

    /**
     * ��ʼ��
     */
    private void init(int sourceNode) {
        adj.initNode();
        adj.initLEdge();
        nodeSize = adj.getNode().length;
        flag = new int[nodeSize];
        
        flag[sourceNode] = 1;//��������·��
        
        sp = new ShortesPath[nodeSize];
        
        //��ʼ���洢ǰ����ź�·�����ȵ�����
        for(int i = 1; i < nodeSize; i++) {
            ShortesPath s = new ShortesPath();
            s.setPathLength(adj.getEdge()[sourceNode][i]);
            if(s.getPathLength() != 0) {//�����·��
                s.setPreNode(sourceNode);
            }
            sp[i] = s;
        }
    }
    
    
    /**
     * ����sourceNode�ĵ�Ԫ���·��====��������
     * @param sourceNode
     */
    public void handle(int sourceNode) {
        init(sourceNode);
        int minPath;
        int minPathIndex = 0;
        for(int i = 1; i < nodeSize; i++) {
            minPath = MAX_PATH;
            for(int j =  1; j < nodeSize; j++) { //��v-s��ѡ������ֵ��С�ĵ�
                if(flag[j] == 0 &&
                   sp[j].getPathLength() != 0 && 
                   sp[j].getPathLength() < minPath) {
                    
                    minPath = sp[j].getPathLength();
                    minPathIndex = j;
                }
            }
            flag[minPathIndex] = 1; //minPathIndex�����s��
            for(int k =1; k < nodeSize; k++) { //�޸ı߼����ݣ���������ֵ
               if(flag[k] == 0 && 
                       (sp[minPathIndex].getPathLength() + adj.getEdge()[minPathIndex][k]) < sp[k].getPathLength()) {
                   sp[k].setPreNode(minPathIndex);
                   sp[k].setPathLength(sp[minPathIndex].getPathLength() + adj.getEdge()[minPathIndex][k]);
               }
            }
        }
    }
    
}
