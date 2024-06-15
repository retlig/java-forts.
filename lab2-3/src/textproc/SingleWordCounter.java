package textproc;

public class SingleWordCounter implements TextProcessor {
	private String word;
	private int n;

	public SingleWordCounter(String word) {
		this.word = word;
		n = 0;
	}

	public void process(String w) {
		//Changed so it compares the words using method in String Class
		if (w.equals(word)) {
			n++;
		}
	}

	public void report() {
		System.out.println(word + ": " + n);
	}

}
