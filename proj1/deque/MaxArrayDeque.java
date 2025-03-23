package deque;
import java.util.Comparator;
import java.util.Iterator;
public class MaxArrayDeque<T>extends ArrayDeque<T> {
    private Comparator<T> comparator;


    public MaxArrayDeque(Comparator<T> c) {
    super();
    this.comparator = c;


    }
    public T max(){
        return  max(comparator);
    }

    public T max(Comparator<T> c){
        if(MaxArrayDeque.super.isEmpty()){
            return null;
        }
        Iterator<T> iterator = iterator();
        T maxItem = iterator.next(); // 假设第一个元素是最大的
        while (iterator.hasNext()) {
            T currentItem = iterator.next();
            if (c.compare(currentItem, maxItem) > 0) {
                maxItem = currentItem; // 更新最大元素
            }
        }
        return maxItem;
    }

}







