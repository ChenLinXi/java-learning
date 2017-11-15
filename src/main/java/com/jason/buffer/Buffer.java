package com.jason.buffer;

import java.nio.ByteBuffer;

public class Buffer {

    public static ByteBuffer allocate(int size) {
        ByteBuffer buffer = ByteBuffer.allocate(size);
        return buffer;
    }

    public static ByteBuffer wrap(int size) {
        byte array[] = new byte[size];
        ByteBuffer buffer = ByteBuffer.wrap(array);
        return buffer;
    }

    public static boolean rewind() {
        ByteBuffer buffer = allocate(16);
        for (int i = 0; i < 5; i++) {
            buffer.put((byte) i);
        }
        buffer.rewind();
        System.out.println(buffer.position());
        return true;
    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(15);
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("last operation position: " + buffer.position());

        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("last operation position: " + buffer.position());

        buffer.flip();

        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("last operation position: " + buffer.position());

        buffer.get();
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("last operation position: " + buffer.position());
        
        for (int i = 0; i < 5; i++) {
            System.out.println(buffer.get());
        }
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("last operation position: " + buffer.position());
    }
}
