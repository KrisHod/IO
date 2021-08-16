package examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelBufferEx {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("Verse.txt", "rw");
             FileChannel channel = file.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(25);
            StringBuilder poetry = new StringBuilder();

            int byteRead = channel.read(buffer);
            while (byteRead > 0) {
                System.out.println("Was read " + byteRead + " byte");

                buffer.flip();

                while (buffer.hasRemaining()) {
                    poetry.append((char) buffer.get());
                }

                buffer.clear();
                byteRead = channel.read(buffer);
            }

            System.out.println(poetry);

            String quotation = "\nThere are only two ways to live your life. " +
                    "One is as though nothing is a miracle. " +
                    "The other is as though everything is a miracle.";

            ByteBuffer buffer2 = ByteBuffer.wrap(quotation.getBytes());
            channel.write(buffer2);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }
}
