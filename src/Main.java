import Data.Processing;
import Data.dataBase;
import FunctionalHandling.dictionary;
import FunctionalHandling.randomSlang;
import FunctionalHandling.dictOperate;
import GUI.GUI;

public class Main {
    public static void main(String[] args) {
        Processing dictData = new Processing();
        dataBase database = new dataBase(dictData);

//        dictionary userDictionary = new dictionary();
//        randomSlang userRandom = new randomSlang(database);
//        dictOperate userDictOperate = new dictOperate(database.getUserSlangDictionary(),database.getRawSlangDictionary());


        GUI newGUI = new GUI("Slang Dictionary",1500,700,database);

    }
}