package examples;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String poetry = "To be, or not to be, that is the question:\n" +
                "Whether ’tis nobler in the mind to suffer\n" +
                "The slings and arrows of outrageous fortune,\n" +
                "Or to take arms against a sea of troubles...";
        String author = "William Shakespeare";
        FileWriter writer = null;
        try {
            writer = new FileWriter("Verse.txt", true);
           // writer.write(poetry);
            writer.write(author);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }
}
