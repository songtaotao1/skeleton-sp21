package Demo;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if(rest == null){
            return 1;
        }else{
         return 1+rest.size();
        }

    }
       // 存储指向下一个节点的引用

            // 构造函数，初始化节点的值和指向下一个节点的引用


            // 向链表添加一个新元素，并且每个元素后插入其平方
            public void addWithSquare(int x) {
                IntList p = this;

                // 遍历链表并插入平方值
                while (p.rest != null) { // 遍历链表，直到最后一个节点
                    IntList newNode = new IntList(p.first * p.first, p.rest);  // 插入当前节点的平方值
                    p.rest = newNode; // 更新当前节点的rest指向新节点
                    p = p.rest.rest;   // 移动到下一个原始节点
                }

                // 在链表末尾插入 x 和 x 的平方
                p.rest = new IntList(x * x, null); // 插入x的平方
                p.rest.rest = new IntList(x, null); // 插入x
            }
  /** public void addWithSquare(int x) {
        int originalSize = size();  // 只调用一次 size() 得到原始长度
        IntList p = this;
        IntList tail = null;  // 用来记录最后一个插入的节点

        // 遍历原始的每个节点
        for (int i = 0; i < originalSize; i++) {
            // 为当前节点 p 插入一个新节点，其值为 p.first 的平方，
            // 新节点的 rest 指向原 p.rest
            IntList squareNode = new IntList(p.first * p.first, p.rest);
            p.rest = squareNode;  // 修改当前节点的指针，插入新节点
            tail = squareNode;    // 更新 tail 指针，指向最新插入的平方节点
            p = squareNode.rest;  // 跳过刚插入的平方节点，指向下一个原始节点
        }

        // 循环结束后，tail 指向最后一个插入的平方节点，
        // 在其后插入新值 x（只插入 x，不再插入 x 的平方）
        tail.rest = new IntList(x, null);
    }*/


    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
      int count = 0;
      IntList current = this;
      while(current != null){
          count++;
          current = current.rest;

      }
      return count;

    }

    /** Returns the ith value in this list.*/
    public int get(int i) {
        if(i==1){
            return first;
        }
        if (rest == null) { // Handle out-of-bounds cases
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        }
        return rest.get(i - 1); // Move to the next node, decreasing i

    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.iterativeSize());
    }
}