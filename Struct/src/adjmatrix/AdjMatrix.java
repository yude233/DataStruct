package adjmatrix;

import java.util.Scanner;

/**
 * �ڽӾ���
 * @author qaz
 *
 */
public class AdjMatrix {
    private int[] node;//���
    private int[][] edge;//��
    
    
    public int[] getNode() {
        return node;
    }

    public int[][] getEdge() {
        return edge;
    }

    /**
     * ��ʼ�����
     */
    public void initNode() {
        int size = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("�������������");
        size = sc.nextInt();
        node = new int[size + 1]; //�±��1��ʼ
        for(int i = 1; i <= size; i++) {
            System.out.println("����������ţ�");
            node[i] = sc.nextInt();
        }
        
    }
    
    //��ʼ����
    public void initEdge() {
        int size = 0;
        int from, to; //��㡢�յ�
        
        //��ʼ����
        edge = new int[node.length][node.length];
        Scanner sc = new Scanner(System.in);
        System.out.println("������߸�����");
        size = sc.nextInt();
        for(int i = 1; i <= size; i++) {
            System.out.println("���������㣺");
            from = sc.nextInt();
            System.out.println("��������յ㣺");
            to = sc.nextInt();
            System.out.println("�������Ȩֵ��");
            edge[from][to] = edge[to][from] = sc.nextInt();
        }
    }
   
    
}
