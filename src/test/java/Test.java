import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        System.out.println(1 | 2 & 3 << 1);
        Test test = new Test();
        System.out.println(test.getResult(1));
    }

    public int getResult(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result += i * 1;
            case 2:
                result += i * 3;
            case 3:
                result += i * 5;
        }
        return result;
    }
}
