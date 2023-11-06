package FunctionalHandling;

import Utils.Utils;

import java.util.HashMap;

public class dictionary {
    private HashMap<String, String[]> slangDictionary;
    private HashMap<String, String[]> defDictionary;
    public dictionary(HashMap<String, String[]> slangDictionary, HashMap<String, String[]> defDictionary)
    {
        this.slangDictionary = slangDictionary;
        this.defDictionary = defDictionary;
    }
    public String[][] searchWord(String searchKey)
    {
        HashMap<String, String[]> wordSearchHash = new HashMap<>();

        if(this.slangDictionary.containsKey(searchKey))
        {
            wordSearchHash.put(searchKey,slangDictionary.get(searchKey));
            return Utils.convertHashMapToTableData(wordSearchHash);
        }
        return Utils.convertHashMapToTableData(slangDictionary);
    }

    public String[][] searchDef(String searchDef)
    {
        HashMap<String, String[]> wordSearchHash = new HashMap<>();

        if(this.defDictionary.containsKey(searchDef))
        {
            wordSearchHash.put(searchDef,defDictionary.get(searchDef));
            return Utils.convertHashMapToTableData(wordSearchHash);
        }
        return Utils.convertHashMapToTableData(defDictionary);
    }

    public void setDictionary(HashMap<String, String[]> slangDictionary,HashMap<String, String[]> defDictionary) {
        this.slangDictionary = slangDictionary;
        this.defDictionary = defDictionary;
    }
}
