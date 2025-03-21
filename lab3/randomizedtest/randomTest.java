package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

public class randomTest {
    @Test
            public void test() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> BL = new BuggyAList<>();
    int N = 50000;
        for (int i = 0; i < N; i += 1) {
                 int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizebl = BL.size();
                System.out.println("size: " + size);
            }else if (operationNumber == 2) {
                if (L.size() != 0&&BL.size() != 0) {
                    L.removeLast();
                    BL.removeLast();
                }
                continue;




            }else if (operationNumber == 3) {
                if (L.size() != 0&&BL.size() != 0) {
                    L.getLast();
                    BL.getLast();
                }
                continue;

            }
        }
        Assert.assertEquals(L.getLast(), BL.getLast());
        Assert.assertEquals(L.size(), L.size());
    }
}
