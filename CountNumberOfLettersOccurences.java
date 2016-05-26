public class CountNumberOfLettersOccurences {
	String loopOnThisString;
	String checkForSimilaritiesFromThisString;
	
	public CountNumberOfLettersOccurences (String loopOnThisString, String checkForSimilaritiesFromThisString) {
		this.loopOnThisString = loopOnThisString;
		this.checkForSimilaritiesFromThisString = checkForSimilaritiesFromThisString;
	}
	
	public int count() {
		int loopOnThisStringLength = loopOnThisString.length();
		int checkForSimilaritiesFromThisStringLength = checkForSimilaritiesFromThisString.length();
		int totalNumberOfOccurences = 0;
		for(int i = 0; i < loopOnThisStringLength; i++) {
			char currentChar = loopOnThisString.charAt(i);
			String currentStrChar = String.valueOf(currentChar);
			String removedCurrentCharFromCheckString = checkForSimilaritiesFromThisString.replace(currentStrChar, "");
			int removedCurrentCharFromCheckStringLength = removedCurrentCharFromCheckString.length();
			int occurencesOfCurrentChar = checkForSimilaritiesFromThisStringLength - removedCurrentCharFromCheckStringLength;
			totalNumberOfOccurences = totalNumberOfOccurences + occurencesOfCurrentChar;
		}
		
		return totalNumberOfOccurences;
	}
}