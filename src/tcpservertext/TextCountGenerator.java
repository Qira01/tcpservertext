package tcpservertext;

public class TextCountGenerator {

	public String getCountText () {
		String text = "Welcome to our application!";
		String length = String.valueOf(count(text));
		
		return length;
	}
	
	public static int count(String text) {
		if(text==null || text.isEmpty()) {
			return 0;
		}
		String[] words = text.split("\\s+");
		return words.length;
	}
}
