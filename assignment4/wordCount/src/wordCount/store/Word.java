package wordCount.store;

/**
 * @author Hardik Bagdi (hbagdi1@binghamton.edu)
 *
 */
public class Word {
	private String word;
	private long count;
	private int charCount;

	public Word(String word_in, long count_in) {
		setWord(word_in);
		setCount(0);
		setCharCount(word_in.length());
	}

	public Word(String word_in) {
		this(word_in, 0L);
	}

	public String getWord() {
		return word;
	}

	private void setWord(String word) {
		this.word = word;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getCharCount() {
		return charCount;
	}

	private void setCharCount(int charCount) {
		this.charCount = charCount;
	}

}
