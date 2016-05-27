public class RemoveSameLetters {
	String loopOnThisString;
	String checkForSimilaritiesFromThisString;
	
	public RemoveSameLetters (String loopOnThisString, String checkForSimilaritiesFromThisString) {
		this.loopOnThisString = loopOnThisString;
		this.checkForSimilaritiesFromThisString = checkForSimilaritiesFromThisString;
	}
	
	public String[] remove() {
		int loopOnThisStringLength = loopOnThisString.length();
		for (int i = 0; i < loopOnThisStringLength; i++) {
			char currentChar = loopOnThisString.charAt(i);
			String currentStrChar = String.valueOf(currentChar);
			if (checkForSimilaritiesFromThisString.contains(currentStrChar) && !currentStrChar.equals("!")) {
				loopOnThisString = loopOnThisString.replaceAll(currentStrChar, "!");
				checkForSimilaritiesFromThisString = checkForSimilaritiesFromThisString.replaceAll(currentStrChar, "!");
			}
		}

		String loopOnThisStringRemovedSameLetters = loopOnThisString.replaceAll("!", "");
		String checkForSimilaritiesFromThisStringRemovedSameLetters = checkForSimilaritiesFromThisString.replaceAll("!", "");
		return new String[] {loopOnThisStringRemovedSameLetters, checkForSimilaritiesFromThisStringRemovedSameLetters};
	}
}