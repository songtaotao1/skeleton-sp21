package Demo;


import static org.junit.Assert.*;
import org.junit.Test;

public class IntListTest {
    @Test
    public void testGet() {
        // 创建测试用例：列表 (1 -> 2 -> 3)
        IntList list = new IntList(1, new IntList(2, new IntList(3, null)));

        // 断言测试：检查 get(i) 是否返回正确的值
        assertEquals(1, list.get(1)); // 第 1 个元素应该是 1
        assertEquals(2, list.get(2)); // 第 2 个元素应该是 2
        assertEquals(3, list.get(3)); // 第 3 个元素应该是 3

        // 测试超出范围的情况，应该抛出 IndexOutOfBoundsException
        try {
            list.get(4); // 超出范围
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            // 测试通过，因为异常被正确抛出
        }
    }
    @Test
    public void testsize() {
        IntList list = new IntList(1, new IntList(2, new IntList(3,new IntList(4, null))));
        int expected = 4;
        assertEquals(expected, list.size());
    }
    @Test
    public void testIterativesize() {
        IntList list = new IntList(1, new IntList(2, new IntList(3, null)));
        int expected = 3;
        assertEquals(expected, list.iterativeSize());
    }
}

