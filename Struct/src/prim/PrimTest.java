package prim;

import org.junit.jupiter.api.Test;

import adjmatrix.AdjMatrix;

class PrimTest {

   
    
    @Test
    void test() {
        AdjMatrix adj = new AdjMatrix();
        adj.initNode();
        adj.initEdge();
        
        Prim prim = new Prim();
        int result[] = prim.process(adj);
        for(int node : result) {
            System.out.println(node);
        }
    }

}
