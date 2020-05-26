package test;

import org.junit.jupiter.api.Test;

class QueueManagerTest {
    QueueManager qm = new QueueManager();
    @Test
    void test() {
       qm.initQueue(2);
       qm.printQueue();
       qm.enQueue('a');
       qm.enQueue('b');
       qm.printQueue();
       System.out.println(qm.getFront());
       qm.deQueue();
       System.out.println(qm.getFront());
       qm.deQueue();
       System.out.println(qm.getFront());

    }

}
