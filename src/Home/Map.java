package Home;

public class Map {

	String name; 
	static int count = 0;
	private String[] strenght = new String[]{"A","K","Q","J","10","9","8","7","6","5","4","3","2","S","I"};
	final int _strenght;
	/*
	 *  Буквой «h» - обозначается чирва
	 *	Буквой «s» - обозначается пика.
	 *	Буквой «c» - обозначается креста.
	 *	Буквой «d» - обозначается бубна.
	 */
	private char[] color = new char[]{'h','s','c','d','a'};
	int _color;
	
	public Map(int strenght, int color) {
		_strenght = strenght;
		_color = color;
		name = this.strenght[strenght] + this.color[color];
		count++;
	}
	
	
	@Override
	public String toString() {
		return new String("["+name+"]");
	}
}
