package dijkstra;


import org.junit.jupiter.api.Test;

class DijkstraTest {

    @Test
    void test() {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.handle(1);
        ShortesPath[] s = dijkstra.getSp();
        for(int i = 1; i < s.length; i++) {
            System.out.println(s[i].getPreNode());
            System.out.println(s[i].getPathLength());
        }
    }

}
