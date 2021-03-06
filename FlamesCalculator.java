
import java.util.ArrayList;

public class FlamesCalculator implements LoveComputer {
  
  ArrayList<String> flames;

	public FlamesCalculator () {
    flames = new ArrayList();
    flames.add("Friendship");
    flames.add("Love");
    flames.add("Affection");
    flames.add("Marriage");
    flames.add("Enemy");
    flames.add("Sibling");
	}
	
	@Override
	public String compute (String name1, String name2) {
		RemoveSameLetters remover = new RemoveSameLetters(name1, name2);
		String [] removedLettersString = remover.remove(); 
		String combinedString = removedLettersString[0] + removedLettersString[1];
    
		int flamesCount = combinedString.length();
               
    int position = 0;
    while(flames.size() > 1) {
      int positionToRemove = (flamesCount + position - 1) % flames.size();
      flames.remove(positionToRemove);
      position = positionToRemove % flames.size();
    }
                
		return flames.get(0);
	}
}