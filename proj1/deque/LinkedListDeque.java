package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedListDeque<T> implements  Deque<T>,Iterable<T>{
    public class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {

            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel; // 哨兵节点
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null); // 创建哨兵节点
        sentinel.prev = sentinel; // 哨兵节点的 prev 指向自己
        sentinel.next = sentinel; // 哨兵节点的 next 指向自己
        size = 0;
    }



    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }


    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;


    }




    @Override
    public int size(){
        return size;
    }
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        first.prev = null;
        first.next = null;
        size--;
        return first.item;
    }
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size--;
        last.prev = null;
        last.next = null;
        return last.item;

    }

    @Override
    public T get(int index) {

        Node current = sentinel.next;
        if (index < 0 || index >= size) {
            return null; // 处理无效索引
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public boolean equals(Object o) {
        // 检查是否指向同一个对象
        if (this == o) {
            return true;
        }
        // 检查是否为 null 或者类型不匹配
        if (o == null || !(o instanceof LinkedListDeque)) {
            return false;
        }
        // 强制转换为 Deque
        LinkedListDeque<?> otherLinkedListDeque = (LinkedListDeque<?>) o;
        // 检查大小是否相同
        if (this.size() != otherLinkedListDeque.size()) {
            return false;
        }
        // 使用迭代器逐个比较元素
        Iterator<T> thisIterator = this.iterator();
        Iterator<?> otherIterator = otherLinkedListDeque.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisItem = thisIterator.next();
            Object otherItem = otherIterator.next();
            // 比较元素是否相等
            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }
        // 所有元素都相等
        return true;


    }
    @Override
    public void printDeque() {

    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node current) {

        if (index < 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            sentinel.next = current;
            return current.item; // 找到目标节点，返回数据
        }
        return getRecursive(index - 1, current.next); //
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    // 内部迭代器类
    private class LinkedListDequeIterator implements Iterator<T> {
        private Node current = sentinel.next; // 当前节点，初始化为第一个节点

        @Override
        public boolean hasNext() {
            return current != sentinel; // 如果 current 不等于哨兵节点，表示还有下一个元素
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(); // 如果没有下一个元素，抛出异常
            }
            T item = current.item; // 获取当前节点的数据
            current = current.next; // 移动到下一个节点
            return item;
        }
    }

}

