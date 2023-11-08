package FunctionalHandling;

import Data.dataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class randomSlang {
    private ArrayList<String> keys;
    private Random random;
    public randomSlang(dataBase userDataBase)
    {
        this.keys = new ArrayList<String>(userDataBase.getUserDictionary().keySet());
        this.random = new Random();
    }

    public String[] getRandomSlang(dataBase userDataBase)
    {
        String key = this.keys.get(this.random.nextInt(this.keys.size()));
        String def = String.join(" | ",userDataBase.getUserDictionary().get(key));
        String[] randomSlang = new String[] {key,def};
        return randomSlang;
    }
}
