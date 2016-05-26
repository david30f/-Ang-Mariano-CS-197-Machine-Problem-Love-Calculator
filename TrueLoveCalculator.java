//DELETE BEFORE SUBMITTING: this class assumes that name1 and name2:
//-- have no spaces
//-- letters are all in lowercase
//-- have no symbols or numbers
//-- have been already checked by InputValidator class 

public class TrueLoveCalculator implements LoveComputer {
	String name1;
	String name2;
	
	public TrueLoveCalculator (String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
	}
	
	@Override
	public void compute() {
		String combinedName = name1 + name2;
		
		CountNumberOfLettersOccurences countTrue = new CountNumberOfLettersOccurences("true", combinedName);
		int firstDigitsInt = countTrue.count();
		String firstDigitsString = String.valueOf(firstDigitsInt);
		
		CountNumberOfLettersOccurences countLove = new CountNumberOfLettersOccurences("love", combinedName);
		int secondDigitsInt = countLove.count();
		String secondDigitsString = String.valueOf(secondDigitsInt);
		
		String overallPercent = firstDigitsString + secondDigitsString;
		System.out.println("TRUELOVE RESULT: " + overallPercent + "%");
	}
}