package mydijkstra;

import org.junit.jupiter.api.Test;

class DijkstraTest {

    @Test
    void test() {
        Dijkstra d = new Dijkstra();
        d.handle(1);
        PreNodeAndPath[] pp = d.getPp();
        for(int i = 1; i < pp.length; i++) {
            System.out.println(pp[i].getPreNode());
            System.out.println(pp[i].getShortPath());
        }
    }

}
