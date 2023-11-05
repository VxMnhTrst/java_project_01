package Data;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Processing {
    private String dictFileName;
    private int dictLength;
    private HashMap<String,String[]> dictionary;
    public Processing() {
        this.dictFileName = "slang.txt";
        this.dictLength = getFileLength(this.dictFileName);
        loadingDict();
    }
    public Processing(String dictFileName) {
        this.dictFileName = dictFileName;
        this.dictLength = getFileLength(this.dictFileName);
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
            this.dictionary = new HashMap<>();

            while(i < this.dictLength - 1)
            {
                String word = reader.readLine();
                String slang = word.split("`")[0];
                String[] definitions = word.split("`")[1].split("\\| ");

                dictionary.put(slang,definitions);
                i++;
            }
            System.out.println(dictionary.get("}:-)")[0]);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String[]> getDictionary() {
        return dictionary;
    }
}
