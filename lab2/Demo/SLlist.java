package Demo;

import java.lang.reflect.Array;

public class SLlist {
    /** An SLList is a list of integers, which hides the terrible truth
     * of the nakedness within. */
    public static class SLList {
        private  class IntNode {
            public int item;
            public IntNode next;

            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
                System.out.println(size);
            }
        }

        /* The first item (if it exists) is at sentinel.next. */
        private IntNode sentinel;
        private int size;

        private  void lectureQuestion() {
            SLList L = new SLList();
            IntNode n = new IntNode(5, null);
        }

        /** Creates an empty SLList. */
        public SLList() {
            sentinel = new IntNode(63, null);
            size = 0;
        }

        public SLList(int x) {
            sentinel = new IntNode(63, null);
            sentinel.next = new IntNode(x, null);
            size = 1;
        }

        /** Adds x to the front of the list. */
        public void addFirst(int x) {
            sentinel.next = new IntNode(x, sentinel.next);
            size = size + 1;
        }

        /** Returns the first item in the list. */
        public int getFirst() {
            return sentinel.next.item;
        }

        /** Adds x to the end of the list. */
        public  void addLast(int x) {
            size = size + 1;

            IntNode p = sentinel;

            /* Advance p to the end of the list. */
            while (p.next != null) {
                p = p.next;
            }

            p.next = new IntNode(x, null);
        }

        /** Returns the size of the list. */
        public int size() {
            return size;
        }
        /** 实现方法delete first 删除SLlist的第一个元素。维护3个不变量


        哨兵引用始终指向一个哨兵节点。
         最前面的项目（如果存在）始终位于 sentinel.next.item。
         大小变量始终是已添加的项目总数。*/
        public void delete_first() {
            if (sentinel.next == null) {
                throw new IllegalStateException("Cannot delete from an empty list.");
            }

            // 如果 sentinel.next.next == null，说明链表只有一个元素
            if (sentinel.next.next == null) {
                sentinel.next = null;  // 删除第一个元素后，链表为空
            } else {
                sentinel.next = sentinel.next.next;  // 正常删除第一个元素
            }
        }
/** 从讲座代码库中提供给您的 SLList.java 副本开始，实现第二个构造函数，该构造函数接受一个整数数组，并使用这些整数创建一个 SLList。再次记住维护您的不变量。

*/

         public SLList(int[] array) {
                sentinel = new IntNode(0, null);  // 哨兵节点初始化
                IntNode p = sentinel;  // p 用来遍历链表
                int size = 0;
                // 遍历输入的数组
                for (int i = 0; i < array.length; i++) {
                    p.next = new IntNode(array[i], null);  // 将每个元素添加到链表中
                    p = p.next;  // 移动到下一个节点
                    size = size + 1;
                }
            }

        public void addAdjacent() {
            sentinel  = new IntNode(0,null);
            IntNode p = sentinel;
            while (p.next != null && p.next.next != null) {
                if (p.next.item == p.next.next.item) {
                    // 合并当前节点和下一个节点

                    p.next.item = p.next.next.item+p.next.item;
                    p.next.next = p.next.next.next;

                    // 跳过下一个节点
                } else {
                    p=p.next; // 移动到下一个节点
                }
            }
        }



 public static void main(String[] args) {
            /* Creates a list of one integer, namely 10 */
            SLList L = new SLList();
            L.addLast(20);
            System.out.println(L.size());
        }
    }
}
