package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		//Implementing ArrayList with TextProcessor objects. Using List as reference variable to make code more "flexible/modular"
		List<TextProcessor> wordList = new ArrayList<TextProcessor>();




		
		//For each loop, for each string in REGIONS array we will creat a TextProcessor object and then run the while-loop until every word as been counted. After every iteration of the for-loop
		//We will report how many times the word was counted
		for(String region : REGIONS){
			//Moves into for-loop to restart the file, otherwhise we only run the while loop for the first iteration of the for-loop, which I found out the hard way =)
			Scanner s = new Scanner(new File("nilsholg.txt"), "UTF-8");
			s.findWithinHorizon("\uFEFF", 1);
			s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
			
			TextProcessor p = new SingleWordCounter(region);
			while (s.hasNext()) {
				String word = s.next().toLowerCase();
				p.process(word);
			}
			s.close();
		p.report();
		}

	
	}
}