public class InputValidator {
	
	public InputValidator () {
	}

	public boolean isValid(String inputString) {
		if (inputString.matches("[a-zA-Z]+[a-zA-Z\\s]+[a-zA-Z]+,[a-zA-Z]+[a-zA-Z\\s]+[a-zA-Z]+")) {
      String[] stringArray = inputString.split(",");
      return !stringArray[0].equals(stringArray[1]);
    }
    else {
      return false;
    }
	}
}