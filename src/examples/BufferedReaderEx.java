package examples;

import java.io.*;

public class BufferedReaderEx {
    public static void main(String[] args) {
        try (BufferedReader reader= new BufferedReader(new FileReader("Verse.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Copy.txt"))) {
//            int character;
//            while ((character= reader.read()) !=-1){ //copy by character
//                writer.write(character);
//            }

            String line;
            while ((line=reader.readLine()) !=null){ //copy by line
                writer.write(line);
                writer.write('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
