package prim;

import java.util.ArrayList;
import java.util.List;

import adjmatrix.AdjMatrix;

/**
 * prim�㷨�����·��
 * @author qaz
 *
 */
public class Prim {
    private boolean visited[]; //��¼����Ƿ���������ǣ�1����0
    
    private int[] node;
    private int last = 0; //��¼node�±�
    
    private void handle(AdjMatrix adj) {
        
        
        List<Edge> edges = new ArrayList<Edge>();
        Edge minValue = new Edge();
        for(int i : node) {
            for(int j = 1; j < adj.getNode().length; j++) {
                //��������ߴ��ڣ��ҵ�δ����
                if((!visited[j]) && (adj.getEdge()[i][j] != 0)) {
                    Edge e = new Edge();
                    e.setFrom(i);
                    e.setTo(j);
                    e.setValue(adj.getEdge()[i][j]);
                    edges.add(e);
                }
            }
        }
        minValue = edges.get(0);//��ʼ��ֵ��һ����Ȩֵ
        for(Edge e : edges) {
            if(e.getValue() < minValue.getValue()) {//����СȨֵ����¼
                minValue = e;
                
            }
        }
        last++;
        node[last] = minValue.getTo();
        visited[minValue.getTo()] = true;//���ѱ��������Ϊtrue
        if(last < node.length - 1) {//������δ�����꣬�ݹ�ִ��
            handle(adj);
        }
        
        
        
    }
    
    /**
     * ִ��prim�㷨
     * @param adj
     */
    public int[] process(AdjMatrix adj) {
        //����ֵ
        int size = adj.getNode().length;
        visited = new boolean[size];
        node = new int[size];
        last++;
        node[last] = adj.getNode()[1];//��ʼ�Ƚ���һ�����ѡ��
        visited[1] = true;//���1�ѱ��鿴��������
        handle(adj);
        return node;
    }
    
}
