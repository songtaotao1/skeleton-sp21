package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;      // 存储元素的数组
    private int size;       // 当前队列中的元素数量
    private int nextFirst;  // 下一个头插操作的位置
    private int nextLast;   // 下一个尾插操作的位置

    // 构造函数
    public ArrayDeque() {
        items = (T[]) new Object[8]; // 初始数组大小为 8
        size = 0;
        nextFirst = 3; // 初始位置在数组中间
        nextLast = 4;
    }

    public void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        int start = (nextFirst ) % items.length; // 第一个元素的位置
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(start + i) % items.length]; // 复制元素到新数组
        }
        items = newItems;
        nextFirst = newSize - 1; // 更新 nextFirst
        nextLast = size;
    }
    @Override
    public void addFirst(T item){
        if (size == items.length) {
            resize(items.length * 2); // 数组已满，扩容
        }
        nextFirst=(nextFirst -1+items.length) % items.length;
         items[nextFirst] = item;

         size++;
    }
    @Override
    public void addLast(T item){
        if (size == items.length) {
            resize(items.length * 2); // 数组已满，扩容
        }
        nextLast=(nextLast + 1+ items.length) % items.length;
        items[nextLast] = item;

        size++;
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2); // 数组利用率过低，缩容
        }

        nextFirst=(nextFirst + 1) % items.length;
        T item = items[nextFirst];
        items[nextFirst] = null;
        size--;
        return item;
    }
    @Override
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2); // 数组利用率过低，缩容
        }

        nextFirst=(nextFirst -1) % items.length;
        T item = items[nextLast];
        items[nextLast] = null;
        size--;
        return item;
    }
    @Override
    public T get(int index){
        if(index < 0 || index >= size){
            return null;
        }
        return  items[(nextFirst + index) % items.length];


    }
    @Override
    public void printDeque() {
        if (isEmpty()) {
            System.out.println("[]"); // 如果队列为空，打印空数组
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(" "); // 在元素之间添加空格
            }
        }
        sb.append("]");
        System.out.println(sb.toString()); // 打印结果
    }
    @Override
    public boolean equals(Object o) {
        // 1. 检查是否指向同一个对象
        if (this == o) {
            return true;
        }
        // 2. 检查是否为 null 或者类型不匹配
        if (o == null || !(o instanceof ArrayDeque)) {
            return false;
        }
        // 3. 强制转换为 ArrayDeque
        ArrayDeque<?> otherDeque = (ArrayDeque<?>) o;
        // 4. 检查大小是否相同
        if (size != otherDeque.size) {
            return false;
        }
        // 5. 逐个比较元素
        Iterator<T> thisIterator = this.iterator();
        Iterator<?> otherIterator = otherDeque.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisItem = thisIterator.next();
            Object otherItem = otherIterator.next();
            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }
        // 6. 所有元素都相等
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    // 内部迭代器类
    private class ArrayDequeIterator implements Iterator<T> {
        private int currentPos; // 当前遍历的位置
        private int count;      // 已遍历的元素数量

        // 构造函数
        public ArrayDequeIterator() {
            currentPos = (nextFirst + 1) % items.length; // 第一个元素的位置
            count = 0;
        }

        // 检查是否还有下一个元素
        @Override
        public boolean hasNext() {
            return count < size;
        }

        // 返回下一个元素
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(); // 如果没有下一个元素，抛出异常
            }
            T item = items[currentPos];
            currentPos = (currentPos + 1) % items.length; // 移动到下一个位置
            count++;
            return item;

        }
    }
    @Override
    public int hashCode() {
        int result = 1;
        for (T item : this) {
            result = 31 * result + (item == null ? 0 : item.hashCode());
        }
        return result;
    }
}

