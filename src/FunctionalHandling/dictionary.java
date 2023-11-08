package FunctionalHandling;

import Data.dataBase;
import Utils.Utils;
import jdk.jshell.execution.Util;

import java.util.HashMap;

public class dictionary {
    public dictionary()
    {
    }
    public String[][] searchWord(dataBase userDataBase, String searchKey)
    {
        HashMap<String, String[]> wordSearchHash = new HashMap<>();
        searchKey = searchKey.trim();

        if(searchKey.trim().isEmpty())
        {
            return Utils.convertHashMapToTableData(userDataBase.getUserDictionary());
        }

        if(userDataBase.getUserDictionary().containsKey(searchKey))
        {
            wordSearchHash.put(searchKey,userDataBase.getUserDictionary().get(searchKey));
            return Utils.convertHashMapToTableData(wordSearchHash);
        }
        return Utils.convertHashMapToTableData(userDataBase.getUserDictionary());
    }
    public String[][] searchDef(dataBase userDataBase, String searchDef)
    {
        HashMap<String, String[]> slangWithDef = new HashMap<>();
        searchDef = searchDef.trim();

        if(searchDef.isEmpty())
        {
            return Utils.convertHashMapToTableData(userDataBase.getUserDictionary());
        }

        int i = 0;
        for(String key : userDataBase.getUserDictionary().keySet())
        {
            String def = String.join(" | ",userDataBase.getUserDictionary().get(key));
            if(Utils.containsIgnoreCase(def,searchDef))
            {
                slangWithDef.put(key,userDataBase.getUserDictionary().get(key));
            }
        }
        if(slangWithDef.size() == 0)
        {
            return Utils.convertHashMapToTableData(userDataBase.getUserDictionary());
        }else {
            return Utils.convertHashMapToTableData(slangWithDef);
        }

    }

}
