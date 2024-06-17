package textproc;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class MultiWordCounter implements TextProcessor{
    //Creating attribute wordMap which is a TreeMap object. We are using the interface Map as reference
    private Map<String, Integer> wordMap = new TreeMap<String, Integer>();
    
    public MultiWordCounter(String[] stringArray){
        for(String s : stringArray){
            //Creats key-value pairs (String word, Integer 0 (variable for counting number of occurances in text))
            wordMap.put(s, 0);
        }
    }
    
    
    public void process(String w){
        //For each loop, keySet() returns a set of all the keys so we can iterate over all the words
        for(String key : wordMap.keySet()){
            if(key.equals(w)){
                //Gets the associated value of the key and adds 1 to it before associating the new value with the key
                wordMap.put(key, (wordMap.get(key) + 1));
            }
        }

    }

    public void report(){
        for(String key : wordMap.keySet()){
            System.out.println(key + ": " + wordMap.get(key));
        }
    }
    

}
