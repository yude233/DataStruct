package topological;

import org.junit.jupiter.api.Test;

class TopologicalSortTest {

    @Test
    void test() {
        TopologicalSort t = new TopologicalSort();
        t.handle();
        t.printSort();
    }

}
