import java.awt.Point;


public class Rover {
	private String direction;
	private Point position;
	
	public Rover(String direction, Point position) {
		super();
		this.direction = direction;
		this.position = position;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void turnLeft(){
		//TODO implementare metodo
	}
	
	public void turnRight(){
		//TODO implementare metodo
	}
	
}