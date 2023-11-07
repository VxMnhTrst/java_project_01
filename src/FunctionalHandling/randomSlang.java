package FunctionalHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class randomSlang {
    private HashMap<String, String[]> dictionary;
    private ArrayList<String> keys;
    private Random random;
    public randomSlang(HashMap<String, String[]> dictionary)
    {
        this.dictionary = dictionary;
        this.keys = new ArrayList<String>(dictionary.keySet());
        this.random = new Random();
    }

    public String[] getRandomSlang()
    {
        String key = this.keys.get(this.random.nextInt(this.keys.size()));
        String def = String.join(" | ",dictionary.get(key));
        String[] randomSlang = new String[] {key,def};
        return randomSlang;
    }

    public void setDictionary(HashMap<String, String[]> dictionary) {
        this.dictionary = dictionary;
    }
}
