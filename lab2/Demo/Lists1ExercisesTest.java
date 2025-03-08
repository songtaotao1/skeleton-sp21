package Demo;
import static org.junit.Assert.*;
import org.junit.Test;
public class Lists1ExercisesTest {
    @Test /*  x==4    */
    public void testIncrlist() {
        IntList list = new IntList(1, new IntList(2, new IntList(3, null)));
        IntList newlist = Lists1Exercises.incrList(list, 4);
        assertEquals(5, newlist.first);
        assertEquals(6, newlist.rest.first);
        assertEquals(7, newlist.rest.rest.first);
        assertEquals(1, list.first);
        assertEquals(2, list.rest.first);
        assertEquals(3, list.rest.rest.first);
    }
    @Test
    public void testdincrList() {
        IntList list = new IntList(1, new IntList(2, new IntList(3, null)));
         Lists1Exercises.dincrList(list, 5);
        assertEquals(6, list.first);
        assertEquals(7, list.rest.first);
        assertEquals(8, list.rest.rest.first);

    }



}
