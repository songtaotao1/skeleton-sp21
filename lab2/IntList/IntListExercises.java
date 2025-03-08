package IntList;

public class IntListExercises {

    /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head.rest != null) {
            head.first += c;
            head = head.rest;
        }
        head.first = head.first + c;

    }

    /**
     * Part B: Buggy method that sets node.first to zero if
     * the max value in the list starting at node has the same
     * first and last digit, for every node in L
     *
     * @param L IntList from Lecture
     */
    public static void setToZeroIfMaxFEL(IntList L) {
        IntList p = L;
        while (p != null) {
            if (firstDigitEqualsLastDigit(max(p))) {
                p.first = 0;
            }
            p = p.rest;
        }
    }

    /**
     * Returns the max value in the IntList starting at L.
     */
    public static int max(IntList L) {
        int max = L.first;
        IntList p = L.rest;
        while (p != null) {
            if (p.first > max) {
                max = p.first;
            }
            p = p.rest;
        }
        return max;
    }

    /**
     * Returns true if the last digit of x is equal to
     * the first digit of x.
     */
    public static boolean firstDigitEqualsLastDigit(int x) {
        int lastDigit = x % 10;
        while (x >= 10) {
            x = x / 10;
        }
        int firstDigit = x % 10;
        return firstDigit == lastDigit;
    }

    /**
     * Part C: (Buggy) mutative method that squares each prime
     * element of the IntList.
     *
     * @param lst IntList from Lecture
     * @return True if there was an update to the list
     */
    public static boolean squarePrimes(IntList lst) {
        // 递归终止条件：链表为空时返回 false
        if (lst == null) {
            return false;
        }

        // 检查当前节点的值是否为质数
        boolean currIsPrime = Primes.isPrime(lst.first);

        // 如果是质数，平方当前节点的值
        if (currIsPrime) {
            lst.first *= lst.first;
        }

        // 递归处理后续节点，并记录后续链表中是否存在质数
        boolean restHasPrime = squarePrimes(lst.rest);

        // 返回当前节点或后续链表中是否存在质数
        return currIsPrime || restHasPrime;
    }
}