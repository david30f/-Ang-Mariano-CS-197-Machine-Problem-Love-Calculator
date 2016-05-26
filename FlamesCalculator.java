//DELETE BEFORE SUBMITTING: this class assumes that name1 and name2:
//-- have no spaces
//-- letters are all in lowercase
//-- have no symbols or numbers
//-- have been already checked by InputValidator class  

public class FlamesCalculator implements LoveComputer {
	String name1;
	String name2;
	final String [] flamesRelationship = {"S = Sibling", "F = Friendship", "L = Love", "A = Affection", "M = Marriage", "E = Enemy"};
	
	public FlamesCalculator (String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
	}
	
	@Override
	public String compute () {
		RemoveSameLetters remover = new RemoveSameLetters(name1, name2);
		String [] removedLettersString = remover.remove(); 
		String combinedString = removedLettersString[0] + removedLettersString[1];
    
		int combinedStringLength = combinedString.length();
		int numberOfLettersOfFlames = flamesRelationship.length;
		int modOfcombinedStringLength = combinedStringLength % numberOfLettersOfFlames;	
    
		String returnValue = flamesRelationship[modOfcombinedStringLength]; 
		return returnValue;
	}
}