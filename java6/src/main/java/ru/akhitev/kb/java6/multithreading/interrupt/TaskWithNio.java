package ru.akhitev.kb.java6.multithreading.interrupt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;

class TaskWithNio implements Runnable {
    private final SocketChannel channel;

    public TaskWithNio(SocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        System.out.println("Начало чтения из канала");
        try {
            channel.read(ByteBuffer.allocate(1));
        } catch(ClosedByInterruptException cbie) {
            System.err.println("ClosedByInterruptException " + cbie.getMessage());
        } catch (AsynchronousCloseException ace) {
            System.err.println("AsynchronousCloseException" + ace.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
