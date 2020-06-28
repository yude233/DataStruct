package floyd;

import adjmatrix.AdjMatrix;

/**
 * Floyd算法实现任意两点间最短路径
 * @author qaz
 *
 */
public class Floyd {
    private int shortPath[][];
    private int prePath[][]; //j点的前一个结点
    
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
     * 初始化
     */
    public void init() {
        adj.initNode();
        adj.initLEdge();
        nodeSize = adj.getNode().length - 1;
        shortPath = new int[nodeSize + 1][nodeSize + 1];
        prePath = new int[nodeSize + 1][nodeSize + 1];
        
        //最短路径初始化
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
     * 算法实现
     */
    public void handle() {
        init();
        for(int k = 1; k <= nodeSize; k++) { //每循环一次，添加个结点
            for(int i = 1; i <= nodeSize; i++) {
                for(int j = 1; j <= nodeSize; j++) {
                    if(shortPath[i][k] + shortPath[k][j] < shortPath[i][j]) { //缩短路径长度，绕过k到j
                        shortPath[i][j] = shortPath[i][k] + shortPath[k][j];
                        prePath[i][j] = prePath[k][j]; //====？ 有问题： 当k j 的值在接下来执行时被改变，则此时值不正确。
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
