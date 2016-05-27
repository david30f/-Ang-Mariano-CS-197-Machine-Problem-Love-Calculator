public class PrepareInputsForCalculation {
	String inputString;
	
	public PrepareInputsForCalculation(String inputString) {
		this.inputString = inputString;
	}
	
	public String[] prepare () {
		String noWhiteSpaceInputString = inputString.replaceAll("\\s+","");
		String inputStringWithNoWhiteSpaceAndInLowerCase = noWhiteSpaceInputString.toLowerCase();
		String [] parts = inputStringWithNoWhiteSpaceAndInLowerCase.split(",");
		String part1 = parts[0];
		String part2 = parts[1];
		
		return new String[] {part1, part2};
	}
} 