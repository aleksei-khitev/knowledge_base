package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetExample {
    public static void main(String[] args) {
        String fromFile = "/home/aleksei_khitev/test_3.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
             FileChannel inputChannel = fileInputStream.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            inputChannel.read(buffer);
            printCharBufferWithoutCharset(buffer);
            printCharBufferWithCharset(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCharBufferWithoutCharset(ByteBuffer buffer) {
        buffer.flip();
        System.out.println("Просто чтение buffer.asCharBuffer()\n--------");
        System.out.print(buffer.asCharBuffer());
        System.out.println();
    }

    private static void printCharBufferWithCharset(ByteBuffer buffer) {
        Charset charset = StandardCharsets.UTF_8;
        buffer.rewind(); // Вернуться к началу
        CharBuffer charBuffer = charset.decode(buffer);
        System.out.println("Чтение CharBuffer, полученного через charset.decode()\n--------");
        System.out.println(charBuffer);
    }
}
