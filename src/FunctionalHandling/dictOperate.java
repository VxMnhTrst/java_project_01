package FunctionalHandling;

import Data.dataBase;

import java.util.Dictionary;
import java.util.HashMap;

public class dictOperate {
    public dictOperate()
    {

    }
    public String deleteSlang(dataBase userDataBase, String key)
    {
        if(userDataBase.getUserDictionary().containsKey(key))
        {
            return "Delete: Slang not found.";
        }
        userDataBase.getUserDictionary().remove(key);
        return "Delete: Slang " + key + " deleted.";
    }
    public String editSlang(dataBase userDataBase,String key, String def)
    {
        String[] defList = def.split(" | ");
        if(userDataBase.getUserDictionary().containsKey(key))
        {
            userDataBase.getUserDictionary().put(key,defList);
            return "Edit: Slang " + key + " edited.";
        }else {
            return "Edit: Slang not found";
        }
    }
    public void resetUSerDictionary(dataBase userDataBase)
    {
        userDataBase.setUserDictionary(userDataBase.getRawDictionary());
    }
}
