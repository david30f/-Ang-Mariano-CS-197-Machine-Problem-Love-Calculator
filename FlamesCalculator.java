public class FlamesCalculator implements LoveComputer {
	final String [] flamesRelationship = {"S: Sibling", "F: Friendship", "L: Love", "A: Affection", "M: Marriage", "E: Enemy"};
	
	public FlamesCalculator () {
	}
	
	@Override
	public String compute (String name1, String name2) {
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