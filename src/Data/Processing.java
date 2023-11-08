package Data;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Processing {
    private String dictFileName;
    private String historyFileName;
    private int dictLength;
    private HashMap<String,String[]> slangDictionary;
    private String[] searchHistory;
    private int historyLength;
    public Processing() {
        this.dictFileName = "slang.txt";
        this.historyFileName = "searchHistory.txt";
        this.dictLength = getFileLength(this.dictFileName);
        this.historyLength = getFileLength(this.historyFileName);

        loadingSlangDict();
        loadingSearchHistory();
    }
    public Processing(String dictFileName, String historyFileName) {
        this.dictFileName = dictFileName;
        this.historyFileName = historyFileName;
        this.dictLength = getFileLength(this.dictFileName);
        this.historyLength = getFileLength(this.historyFileName);

        loadingSlangDict();
        loadingSearchHistory();
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
    private void loadingSlangDict()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.dictFileName))) {
            reader.readLine();
            int i = 0;
            this.slangDictionary = new HashMap<>();

            while(i < this.dictLength - 1)
            {
                String word = reader.readLine();
                String slang = word.split("`")[0];
                String[] definitions = word.split("`")[1].split("\\| ");

                slangDictionary.put(slang,definitions);
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadingSearchHistory()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(this.historyFileName))) {
            reader.readLine();
            int i = 0;
            this.searchHistory = new String[this.historyLength - 1];

            while(i < this.historyLength - 1)
            {
                String word = reader.readLine();
                this.searchHistory[i] = word;

                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeSearchHistory()
    {
        try(BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(this.historyFileName, false)))) {
            int i = 0;
            writer.write("History search");
            while(i < this.searchHistory.length)
            {
                writer.write("\n");
                writer.write(this.searchHistory[i]);
                i++;
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setSearchHistory(String[] searchHistory)
    {
        this.searchHistory = searchHistory;
    }
    public HashMap<String, String[]> getCloneDictionary() {
        return (HashMap<String, String[]>) this.slangDictionary.clone();
    }
    public String[] getHistory() {
        return this.searchHistory;
    }
}
