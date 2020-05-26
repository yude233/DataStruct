package test;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        char[] tasks = {'a', 'a', 'a', 'b', 'b', 'b'};
        int time = Solution.leastInterval(tasks, 2);
        System.out.println(time);
    }

}
