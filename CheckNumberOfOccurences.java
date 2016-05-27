public class CheckNumberOfOccurences {
	String checkFromThis;
	String checkForThis;
	
	public CheckNumberOfOccurences(String checkFromThis, String checkForThis) {
		this.checkFromThis = checkFromThis;
		this.checkForThis = checkForThis;
	}
	
	public int countOccurences () {
		int checkFromThisLength = checkFromThis.length();
		String removedCharFromCheckString = checkFromThis.replace(checkForThis, "");
		int removedCharFromCheckStringLength = removedCharFromCheckString.length();
		int occurencesOfChar = checkFromThisLength - removedCharFromCheckStringLength;
		
		return occurencesOfChar;
	}
}