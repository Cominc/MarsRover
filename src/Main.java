import java.awt.Point;


public class Main {

	public static void main(String[] args) {
		Point startPoint = new Point(0,0);
		Planet mars = new Planet(3,3);
		mars.setObstacle(1, 2, true);
		mars.setObstacle(2, 2, true);
		Rover roverA = new Rover('N', startPoint, mars);
		char[] commands = {'l','f','f','r','f','r','r','f','b','b'};
		System.out.println(roverA);
		roverA.executeCommands(commands);
	}

}
