import java.awt.Point;


public class Main {

	public static void main(String[] args) {
		Point startPoint = new Point(0,0);
		Rover roverA = new Rover('N', startPoint);
		char[] commands = {'l','l','r','r','r'};
		System.out.println(roverA);
		roverA.executeCommands(commands);
	}

}
