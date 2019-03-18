import com.sun.jdi.PathSearchingVirtualMachine;

import javax.sound.sampled.DataLine;
import java.util.Arrays;

class Stack {
    private Object[] data;
    private int size = 0;

    public Stack() {
        data = new Object[0];
    }

    public boolean ifFull() {
        return data.length == size || (data.length == 0 && size == 0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void increData() {
        data = Arrays.copyOf(data, data.length + 10);
    }

    public void push(Object object) {
        if (ifFull()) {
            increData();
        }
        size++;
        data[size - 1] = object;
    }

    public Object pop() {
        Object o = data[size - 1];
        data[size - 1] = null;
        size--;
        return o;
    }
}

public class Q37 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push("123");
        Object o = stack.pop();
        System.out.println(o);
        o = stack.pop();
        System.out.println(o);
    }
}
