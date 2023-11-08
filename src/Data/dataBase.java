package Data;

import java.util.HashMap;

public class dataBase {
    private HashMap<String, String[]> rawDictionary;
    private HashMap<String, String[]> userDictionary;
    public dataBase(Processing dataProcess)
    {
        this.rawDictionary = dataProcess.getDictionary();
        this.userDictionary = dataProcess.getDictionary();
    }

    public HashMap<String, String[]> getRawDictionary() {
        return rawDictionary;
    }

    public HashMap<String, String[]> getUserDictionary() {
        return userDictionary;
    }

    public void setUserDictionary(HashMap<String, String[]> userDictionary) {
        this.userDictionary = userDictionary;
    }
}
