package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String SEPARATOR = "/";
    protected final String rootPath;

    public Directory(String rootPath) {
        assert rootPath != null && !rootPath.isBlank();

        this.rootPath = rootPath;
    }
    
    public void createDirectory() {
        this.createSubdirectory(SEPARATOR);
    }

    public void createSubdirectory(String directoryName) {
        assert directoryName.startsWith(SEPARATOR) : "Fallo con |" + directoryName + "|";
        try {
            Files.createDirectories(Paths.get(this.rootPath + directoryName));
            Console.instance().writeln(Paths.get(this.rootPath + directoryName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName, String content) {
        assert fileName.startsWith(SEPARATOR) : "Fallo con |" + fileName + "|";

        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(this.rootPath + fileName);
            printWriter.write(content);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFile(String fileName) {
        assert fileName.startsWith(SEPARATOR) : "Fallo con |" + fileName + "|";

        List<String> strings = new ArrayList<>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(this.rootPath + SEPARATOR + fileName));
            String line;
            while ((line = input.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return strings;
    }

    public String rootPath() {
        return this.rootPath.substring(0, this.rootPath.lastIndexOf(SEPARATOR));
    }
    
}
