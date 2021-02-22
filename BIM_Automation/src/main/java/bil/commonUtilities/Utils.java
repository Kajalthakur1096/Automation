package bil.commonUtilities;

public class Utils {
	
	public static String getRandomNumbers() {
		int size = 4;
		StringBuilder sb = new StringBuilder(size);
		String NumericString = "0123456789";
		for (int i = 0; i < size; i++) {
			int index = (int) (NumericString.length() * Math.random());
			sb.append(NumericString.charAt(index));
		}
		return sb.toString();
	}
}
