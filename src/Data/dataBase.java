package Data;

import java.util.HashMap;

public class dataBase {
    private HashMap<String, String[]> userDictionary;
    private final Processing dataProcess;
    public dataBase(Processing dataProcess)
    {
        this.dataProcess = dataProcess;
        this.userDictionary = this.dataProcess.getCloneDictionary();
    }
    public HashMap<String, String[]> getUserDictionary() {
        return userDictionary;
    }
    public void resetUserDatabase() {
        this.userDictionary = this.dataProcess.getCloneDictionary();
    }
}
