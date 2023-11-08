package Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class dataBase {
    private HashMap<String, String[]> userDictionary;
    private final Processing dataProcess;
    private String[] searchHistory;
    public dataBase(Processing dataProcess)
    {
        this.dataProcess = dataProcess;
        this.userDictionary = this.dataProcess.getCloneDictionary();
        this.searchHistory = this.dataProcess.getHistory();
    }
    public void addingSearchHistory(String search) {
        if(search.isEmpty() || search.isBlank()) return;
        List<String> searchList = new ArrayList<String>(Arrays.asList(this.searchHistory));
        searchList.add(search);
        this.searchHistory = searchList.toArray(this.searchHistory);
    }
    public HashMap<String, String[]> getUserDictionary() {
        return this.userDictionary;
    }
    public String[] getSearchHistory() {return this.searchHistory;}
    public void saveHSearchHistory()
    {
        this.dataProcess.setSearchHistory(this.searchHistory);
        this.dataProcess.writeSearchHistory();
    }
    public void resetUserDatabase() {
        this.userDictionary = this.dataProcess.getCloneDictionary();
    }
}
