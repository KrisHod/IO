package examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("Verse.txt", "rw")) {

            int c =file.read(); //reads by byte and moves pointer
            System.out.println((char)c);

            String line = file.readLine();
            System.out.println(line);

            file.seek(101);
            String line2 = file.readLine();
            System.out.println(line2);

            long position = file.getFilePointer();
            System.out.println(position);

            file.seek(file.length()-1);
            file.writeBytes("\n\t\t\t\t\t1601");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
