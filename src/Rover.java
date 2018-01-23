import java.awt.Point;


public class Rover {
	private static final int N_DIRECTIONS = 4;
	private static final char[] DIRECTIONS = {'N','E','S','W'};
	private static final char FORWARD_COMMAND = 'f';
	private static final char BACKWARD_COMMAND = 'b';
	private static final char TURNLEFT_COMMAND = 'l';
	private static final char TURNRIGHT_COMMAND = 'r';
	
	private int indexDirection;
	private Point position;
	
	public Rover(char direction, Point position) {
		this.indexDirection = fromLabelToIndex(direction);
		this.position = position;
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public char getDirection() {
		return DIRECTIONS[indexDirection];
	}

	public void setDirection(char direction) {
		indexDirection = fromLabelToIndex(direction);
	}
	
	public void turnLeft(){
		if(indexDirection==0)
			indexDirection = 3;
		else
			indexDirection = (indexDirection-1)%N_DIRECTIONS;
	}
	
	public void turnRight(){
		indexDirection = (indexDirection+1)%N_DIRECTIONS;
	}
	
	public void moveForward(){
		//TODO implementare
	}
	
	public void moveBackward(){
		//TODO implementare
	}
	
	public boolean executeCommands(char[] commands){
		for(int i=0; i< commands.length; i++){
			System.out.println(commands[i]);
			if(!executeCommand(commands[i]))
				return false;
			System.out.println(this);
		}
		return true;
	}
	
	private boolean executeCommand(char command){
		switch(command){
			case FORWARD_COMMAND:
				moveForward();
				break;
			case BACKWARD_COMMAND:
				moveBackward();
				break;
			case TURNLEFT_COMMAND:
				turnLeft();
				break;
			case TURNRIGHT_COMMAND:
				turnRight();
				break;
		}
		return true;
	}
	
	private int fromLabelToIndex(char direction){
		switch(direction){
			case 'N':
				return 0;
			case 'E':
				return 1;
			case 'S':
				return 2;
			case 'W':
				return 3;
			default:
				return 0;
		}
	}

	@Override
	public String toString() {
		return "Rover "+getDirection()+" ["+position.x+","+position.y+"]";
	}

}