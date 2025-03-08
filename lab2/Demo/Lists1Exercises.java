package Demo;

import java.util.ArrayList;


public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        if (L == null) { // 递归终止条件：如果 L 为空，返回 null
            return null;
        }
        // 创建一个新的 IntList，其中 first = L.first + x
        return new IntList(L.first + x, incrList(L.rest, x));



    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {

            IntList ptr = L; // 使用指针遍历链表
            while (ptr != null) {
                ptr.first += x; // 直接修改元素值
                ptr = ptr.rest; // 移动到下一个节点
            }
            return L; // 返回修改后的链表




    }



    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        // System.out.println(dincrList(L, 3));
    }
}