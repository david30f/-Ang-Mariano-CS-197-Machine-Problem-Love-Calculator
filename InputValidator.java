public class InputValidator {
	
	public InputValidator () {
	}

	public boolean isValid(String inputString) {
		return inputString.matches("[a-zA-Z]+[a-zA-Z\\s]+[a-zA-Z]+,[a-zA-Z]+[a-zA-Z\\s]+[a-zA-Z]+");
	}
}