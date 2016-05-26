public class MainClass {
	public static void main (String args[]) {
		String name1 = "tomthompson";
		String name2 = "shellysmith";
		System.out.println(name1 + " & " + name2);
		LoveComputer flames = new FlamesCalculator(name1, name2);
		flames.compute();
		LoveComputer trueLove = new TrueLoveCalculator(name1, name2);
		trueLove.compute();
	}
}