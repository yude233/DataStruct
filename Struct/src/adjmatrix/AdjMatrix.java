package adjmatrix;

import java.util.Scanner;

/**
 * �ڽӾ���
 * @author qaz
 *
 */
public class AdjMatrix {
    private int[] node;//��� ,�±��1��ʼ
    private int[][] edge;//��
    
    private int MAX_PATH = 10000;
    
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
    
    /**
     * ��ʼ����--����
     */
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
    
    /**
     * ��ʼ����--����
     */
    public void initLEdge() {
        int size = 0;
        int from, to; //��㡢�յ�
        
        //��ʼ����
        edge = new int[node.length][node.length];
        //�߸���ֵ����·�������ֵmax
        for(int i = 1; i < node.length; i++) {
            for(int j = 1; j < node.length; j++) {
                if(i != j) {
                    edge[i][j] = MAX_PATH; 
                }else {
                    edge[i][j] = 0;//�������·��
                }
                
            }
        }
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("������߸�����");
        size = sc.nextInt();
        for(int i = 1; i <= size; i++) {
            System.out.println("���������㣺");
            from = sc.nextInt();
            System.out.println("��������յ㣺");
            to = sc.nextInt();
            System.out.println("�������Ȩֵ��");
            edge[from][to] = sc.nextInt();
        }
    }
   
    
}
