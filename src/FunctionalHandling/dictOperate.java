package FunctionalHandling;

import Data.Processing;
import Data.dataBase;

import java.util.*;

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
    public String resetUSerDictionary()
    {
        this.userDataBase.resetUserDatabase();
        return "Reset: Slang dictionary restarted.";
    }
    public String addSlang(String key, String def, boolean dupFlag)
    {
        if(!this.userDataBase.getUserDictionary().containsKey(key))
        {
            this.userDataBase.getUserDictionary().put(key,new String[]{def});
            System.out.println(String.format("Add: Slang " + key + " added."));
            return "Add: Slang " + key + " added.";
        }else if(dupFlag){
            if(def.isEmpty() || def.isBlank()) {
                System.out.println(String.format("Add: Duplicate slang " + key + " blank definition."));
                return "Add: Duplicate slang " + key + " blank definition.";
            }
            List<String> searchList = new ArrayList<String>(Arrays.asList(
                    this.userDataBase.getUserDictionary().get(key)));
            searchList.add(def);
            String[] newDef = searchList.toArray(this.userDataBase.getUserDictionary().get(key));
            this.userDataBase.getUserDictionary().put(key,newDef);

            System.out.println(String.format("Add: Duplicate slang " + key + " added."));
            return "Add: Duplicate slang " + key + " added.";
        }else {
            System.out.println(String.format("Add: Slang existed."));
            return "Add: Slang existed.";
        }
    }
}
