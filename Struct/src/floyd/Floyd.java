package floyd;

import adjmatrix.AdjMatrix;

/**
 * Floyd�㷨ʵ��������������·��
 * @author qaz
 *
 */
public class Floyd {
    private int shortPath[][];
    private int prePath[][]; //j���ǰһ�����
    
    private int nodeSize;
    private int MAX_SIZE = 10000;
    
    private AdjMatrix adj = new AdjMatrix();
    
    public int[][] getShortPath() {
        return shortPath;
    }

    public int[][] getPrePath() {
        return prePath;
    }

    public int getNodeSize() {
        return nodeSize;
    }


    /**
     * ��ʼ��
     */
    public void init() {
        adj.initNode();
        adj.initLEdge();
        nodeSize = adj.getNode().length - 1;
        shortPath = new int[nodeSize + 1][nodeSize + 1];
        prePath = new int[nodeSize + 1][nodeSize + 1];
        
        //���·����ʼ��
        for(int i =1; i <= nodeSize; i++) {
            for(int j = 1; j <= nodeSize; j++) {
                shortPath[i][j] = adj.getEdge()[i][j];
                if(i != j && shortPath[i][j] < MAX_SIZE) {
                    prePath[i][j] = i;
                }
            }
        }
    }
    
    /**
     * �㷨ʵ��
     */
    public void handle() {
        init();
        for(int k = 1; k <= nodeSize; k++) { //ÿѭ��һ�Σ���Ӹ����
            for(int i = 1; i <= nodeSize; i++) {
                for(int j = 1; j <= nodeSize; j++) {
                    if(shortPath[i][k] + shortPath[k][j] < shortPath[i][j]) { //����·�����ȣ��ƹ�k��j
                        shortPath[i][j] = shortPath[i][k] + shortPath[k][j];
                        prePath[i][j] = prePath[k][j]; //====�� �����⣺ ��k j ��ֵ�ڽ�����ִ��ʱ���ı䣬���ʱֵ����ȷ��
                    }
                }
            }
            System.out.println("k = " + k);
            printResult();
        }
    }
    
    private void printResult() {
        for(int i = 1; i <= nodeSize; i++) {
            for(int j = 1; j <= nodeSize; j++) {
                System.out.println(shortPath[i][j]);
            }
        }
        System.out.println("========================");
        for(int i = 1; i <= nodeSize; i++) {
            for(int j = 1; j <= nodeSize; j++) {
                System.out.println(prePath[i][j]);
            }
        }
    }
}
