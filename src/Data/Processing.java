package Data;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class Processing {
    private String dictFileName;
    private String[] dictLines;
    private int dictLength;
    public Processing() {
        this.dictFileName = "slang.txt";
        this.dictLength = 0;
        this.dictLines = new String[getFileLength(this.dictFileName)];
        loadingDict();
    }
    public Processing(String dictFileName) {
        this.dictFileName = dictFileName;
        this.dictLength = 0;
        this.dictLines = new String[getFileLength(this.dictFileName)];
        loadingDict();
    }
    public static int getFileLength(String fileName)
    {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    private void loadingDict()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.dictFileName))) {
            reader.readLine();
            int i = 0;
            while(i < this.dictLines.length)
            {
                String word = reader.readLine();
                System.out.println(word);
                this.dictLines[i] = word;
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
