package src.main.java;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class NIOdemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int[] intArray = new int[]{1, 2, 3, 4, 5};
        IntBuffer intBuffer = IntBuffer.wrap(intArray);

        System.out.println(byteBuffer + "," + intBuffer);
    }
}
