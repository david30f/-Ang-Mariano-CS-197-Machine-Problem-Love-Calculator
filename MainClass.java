import java.util.Scanner;

public class MainClass {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		String inputNames = scan.nextLine();
		scan.close();
		InputValidator checkInput = new InputValidator(inputNames);
		boolean validity = checkInput.check();
		if (validity) {
			PrepareInputsForCalculation preparation = new PrepareInputsForCalculation(inputNames);
			String[] preparedNamesArray = preparation.prepare();
			
			String name1 = preparedNamesArray[0];
			String name2 = preparedNamesArray[1];
			System.out.println(name1 + " & " + name2);
			LoveComputer flames = new FlamesCalculator(name1, name2);
			flames.compute();
			LoveComputer trueLove = new TrueLoveCalculator(name1, name2);
			trueLove.compute();
		}
		
		else
			System.out.println("Invalid Input");

	}
}