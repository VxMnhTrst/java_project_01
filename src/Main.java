import Data.Processing;
import Data.dataBase;
import FunctionalHandling.dictionary;
import FunctionalHandling.randomSlang;
import GUI.GUI;

public class Main {
    public static void main(String[] args) {
        Processing dictData = new Processing();
        dataBase database = new dataBase(dictData);

        dictionary userDictionary = new dictionary(database.getUserSlangDictionary(),database.getUserDefDictionary());
        randomSlang userRandom = new randomSlang(database.getUserSlangDictionary());

        GUI newGUI = new GUI("Slang Dictionary",1500,700,userDictionary,userRandom);

    }
}