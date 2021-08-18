package examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

public class PathFilesEx {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("Verse.txt");
        Path directoryPath = Paths.get("C:\\Users\\Zver\\Desktop\\lavender farm");

        System.out.println("filePath.getFileName() --> " + filePath.getFileName());
        System.out.println("directoryPath.getFileName() --> " + directoryPath.getFileName());
        System.out.println("----------");

        System.out.println("filePath.getParent() --> " + filePath.getParent());
        System.out.println("directoryPath.getParent() --> " + directoryPath.getParent());
        System.out.println("----------");

        System.out.println("filePath.getRoot() --> " + filePath.getRoot());
        System.out.println("directoryPath.getRoot() --> " + directoryPath.getRoot());
        System.out.println("----------");

        System.out.println("filePath.isAbsolute() --> " + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute() --> " + directoryPath.isAbsolute());
        System.out.println("----------");

        System.out.println("filePath.toAbsolutePath() --> " + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath() --> " + directoryPath.toAbsolutePath());
        System.out.println("----------");

        System.out.println("directoryPath.resolve(filePath) --> " + directoryPath.resolve(filePath));
        System.out.println("----------");

        System.out.println("directoryPath.relativize(filePath) --> " + directoryPath.relativize(Paths.get("C:\\Users\\Zver\\Desktop\\lavender farm\\A\\B\\C")));
        System.out.println("----------");

        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        if (!Files.exists(directoryPath)) {
            Files.createDirectory(directoryPath);
        }

        System.out.println("Files.isReadable(filePath) --> " + Files.isReadable(filePath));
        System.out.println("Files.isWritable(filePath) --> " + Files.isWritable(filePath));
        System.out.println("Files.isExecutable(filePath) --> " + Files.isExecutable(filePath));
        System.out.println("----------");

        Path filePath2 = Paths.get("C:\\Users\\Zver\\Desktop\\Kris\\IO\\Copy.txt");
        System.out.println("Files.isSameFile(filePath, filePath2) --> " + Files.isSameFile(filePath, filePath2));
        System.out.println("----------");

        System.out.println("Files.size(filePath) --> " + Files.size(filePath));
        System.out.println("----------");

        System.out.println("Files.getAttribute(filePath, \"creationTime\") --> " + Files.getAttribute(filePath, "creationTime"));
        System.out.println("----------");

        Map<String, Object> attributes = Files.readAttributes(filePath, "*");
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        Files.move(Paths.get("Copy.txt"), Paths.get("CopyVerse.txt")); //rename

        String greeting = "Hello! How are you?";
        Files.write(filePath, greeting.getBytes());

        List<String> list = Files.readAllLines(filePath);
        for (String line : list) {
            System.out.println(line);
        }
    }
}
