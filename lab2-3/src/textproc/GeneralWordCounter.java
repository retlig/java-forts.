package textproc;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
public class GeneralWordCounter implements TextProcessor {

    private Set<String> stopwords;
    private Map<String, Integer> wordMap = new TreeMap<String, Integer>();

    public GeneralWordCounter(Set<String> stopwords){
        //Copies the entries of the HashSet stopwords to our attribute stopwords
        this.stopwords = new HashSet<String>(stopwords);
    }

    public void process(String w){
        //Controls if the word is contained in the Set of banned words
        if(!stopwords.contains(w)){
            //If it's not banned we check if it's already been added to the HashMap, if not
            //we add it and set the value to 1
            if(!wordMap.containsKey(w)){
                wordMap.put(w, 1);
            }
            //If it's already in the HashMap we retrieve the value and update it + 1
            else{
                wordMap.put(w, wordMap.get(w) + 1);
            }
        }
    }

    //Creates a Set with Map.Entry<String, Integer> objects, i.e a set containing all the key value pairs in our HashMax
    Set<Map.Entry<String, Integer>> wordSet = wordMap.entrySet();
    //Creates an ArraList with the same entries as the wordSet created above, so we can sort the list. 
    List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);


    //Lab 3 ~ Method that returns ArrayList with Map.Entry<String, Integer> objects
    public List<Map.Entry<String, Integer>> getWordList(){
        return wordList;
    }
	
    public void report(){
        
        // for(String key : wordMap.keySet()){
        //     if(wordMap.get(key) >= 200){
        //         System.out.println(key + ": " + wordMap.get(key));
        //     }
        // }

        
        //Calling the sort() method on the list. Sending a lambda expression as comparator. Compares values, if the same, compares lexographically, then sorts the list in descending order
        wordList.sort((first, second) -> {
            if(first.getValue() == second.getValue()){
                return second.getKey().compareTo(first.getKey());
            } else {
                return second.getValue() - first.getValue();   
            } 
        });

        // for(Map.Entry<String, Integer> entry : wordList){
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }


        //Prints the first 5/30 words in the list wordList
        for(int i = 0; i < 30; i++){
            //gets object Map.Entry<String, Integer at index i, to retrieve key and value for printing
            System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
        }

    }
}


