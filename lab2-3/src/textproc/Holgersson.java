package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		//Create timer
		long t0 = System.nanoTime();
		//Create HashSet to hold stopwords/banned words
		Set<String> stopwords = new HashSet<String>();
		//Create ArrayList to hold TextProcessor objects and objects implementing the interface
		List<TextProcessor> wordList = new ArrayList<TextProcessor>();
		
		//Creates and adds a SingleWordCounter object to the ArrayList. This works because SingleWordCounter implements interface TextProcessor
		wordList.add(new SingleWordCounter("nils"));
		wordList.add(new SingleWordCounter("norge"));
		//Since MultiWordCounter implements TextProcessor interface we can add it to the ArrayList with object type TextProcessor (this was a bit confusing at first, ask TA)
		wordList.add(new MultiWordCounter(REGIONS));
		




		Scanner scan = new Scanner(new File("undantagsord.txt"), "UTF-8");
		Scanner s = new Scanner(new File("nilsholg.txt"), "UTF-8");
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		scan.findWithinHorizon("\uFEFF", 1);
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		while(scan.hasNext()){
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}

		//Creates and adds GeneralWordCounter obj to the list. This works because GeneralWordCounter implements interface TextProcessor
		wordList.add(new GeneralWordCounter(stopwords));
		
		
		//Scans next word in nilshog.txt (as long as there is one), sets it to lower case
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			//For each loop, goes through the wordList and calls process method on each, checking if it's equivalent to the word, and counting up 
			//(SingleWordCounter objects have attribute n, which holds the value) if it's equivalent.
			for(TextProcessor p : wordList){
				p.process(word);
			}
			
		}

		//Closes the scanner?
		s.close();
		scan.close();

		//For each loop, calling the report method which prints out the word and how many times it was counted
		for(TextProcessor p : wordList){
			p.report();
		}
		//Median time 311.703 ms
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
	}
}