package Data;

import java.util.HashMap;

public class dataBase {
    private HashMap<String, String[]> rawSlangDictionary;
    private HashMap<String, String[]> rawDefDictionary;
    private HashMap<String, String[]> userSlangDictionary;
    private HashMap<String, String[]> userDefDictionary;
    public dataBase(Processing dataProcess)
    {
        this.rawSlangDictionary = dataProcess.getDictionary();
        this.rawDefDictionary = dataProcess.getDictionary();
        this.userSlangDictionary = dataProcess.getDictionary();
        this.userDefDictionary = dataProcess.getDictionary();
    }

    public HashMap<String, String[]> getRawSlangDictionary() {
        return rawSlangDictionary;
    }

    public HashMap<String, String[]> getRawDefDictionary() {
        return rawDefDictionary;
    }

    public HashMap<String, String[]> getUserSlangDictionary() {
        return userSlangDictionary;
    }

    public HashMap<String, String[]> getUserDefDictionary() {
        return userDefDictionary;
    }

    public void setUserSlangDictionary(HashMap<String, String[]> userSlangDictionary) {
        this.userSlangDictionary = userSlangDictionary;
    }

    public void setUserDefDictionary(HashMap<String, String[]> userDefDictionary) {
        this.userDefDictionary = userDefDictionary;
    }
}
