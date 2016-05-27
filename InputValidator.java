public class InputValidator {
	String inputString;
	
	public InputValidator (String inputString) {
		this.inputString = inputString;
	}
	
	public boolean check() {
		boolean validity = false;
		CheckNumberOfOccurences occurence = new CheckNumberOfOccurences(inputString, ",");
		int resultingOccurence = occurence.countOccurences();
		if (resultingOccurence == 1) {
			String noWhiteSpaceInputString = inputString.replaceAll("\\s+","");
			String [] parts = noWhiteSpaceInputString.split(",");
			String part1 = parts[0];
			String part2 = parts[1];
			int part1Length = part1.length();
			int part2Length = part2.length();
			if ((part1Length != 0) && (part2Length != 0)) {
				boolean part1LettersOnly = part1.matches("[a-zA-Z]+");
				boolean part2LettersOnly = part2.matches("[a-zA-Z]+");
				if(part1LettersOnly && part2LettersOnly) {
					validity = true;
				}
			}
		}
		
		return validity;
	}
}