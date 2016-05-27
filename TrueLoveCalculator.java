public class TrueLoveCalculator implements LoveComputer {
	
	public TrueLoveCalculator () {
	}
	
	@Override
	public String compute(String name1, String name2) {
		String combinedName = name1 + name2;
		
		CountNumberOfLettersOccurences countTrue = new CountNumberOfLettersOccurences("true", combinedName);
		int firstDigitsInt = countTrue.count();
		String firstDigitsString = String.valueOf(firstDigitsInt);
		
		CountNumberOfLettersOccurences countLove = new CountNumberOfLettersOccurences("love", combinedName);
		int secondDigitsInt = countLove.count();
		String secondDigitsString = String.valueOf(secondDigitsInt);
		
		String overallPercent = firstDigitsString + secondDigitsString + "%";
    return overallPercent;
	}
}