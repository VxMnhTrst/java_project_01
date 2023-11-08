package FunctionalHandling;

import Data.Processing;
import Data.dataBase;

import java.util.Dictionary;
import java.util.HashMap;

public class dictOperate {
    private dataBase userDataBase;
    public dictOperate(dataBase userDataBase)
    {
        this.userDataBase = userDataBase;
    }
    public String deleteSlang(String key)
    {
        if(!this.userDataBase.getUserDictionary().containsKey(key))
        {
            return "Delete: Slang not found.";
        }
        this.userDataBase.getUserDictionary().remove(key);
        return "Delete: Slang " + key + " deleted.";
    }
    public String editSlang(String key, String def)
    {
        String[] defList = def.split(" | ");
        if(this.userDataBase.getUserDictionary().containsKey(key))
        {
            this.userDataBase.getUserDictionary().put(key,defList);
            System.out.println(String.format("Edit: Slang " + key + " edited."));
            return "Edit: Slang " + key + " edited.";
        }else {
            System.out.println(String.format("Edit: Slang not found"));
            return "Edit: Slang not found";
        }
    }
    public void resetUSerDictionary()
    {
        this.userDataBase.resetUserDatabase();
    }
}
