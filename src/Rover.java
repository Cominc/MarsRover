import java.awt.Point;


public class Rover {
	private static final char[] DIRECTIONS = {'N','E','S','W'};
	private static final int NORTH= 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	private static final char FORWARD_COMMAND = 'f';
	private static final char BACKWARD_COMMAND = 'b';
	private static final char TURNLEFT_COMMAND = 'l';
	private static final char TURNRIGHT_COMMAND = 'r';
	private static final String ROVER_PRINT = "Rover %c [%d,%d]";
	
	private int indexDirection;
	private Point position;
	private Planet planet;
	
	public Rover(char direction, Point position, Planet planet) {
		this.indexDirection = fromLabelToIndex(direction);
		this.planet = planet;
		if(planet.validXY(position.x, position.y))
			this.position = position;
		else
			this.position = new Point(0,0);
		
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

	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public void setDirection(char direction) {
		indexDirection = fromLabelToIndex(direction);
	}
	
	private boolean turnLeft(){
		if(indexDirection==0)
			indexDirection = 3;
		else
			indexDirection = (indexDirection-1)%DIRECTIONS.length;
		return true;
	}
	
	private boolean turnRight(){
		indexDirection = (indexDirection+1)%DIRECTIONS.length;
		return true;
	}
	
	private boolean moveForward(){
		int nextX = position.x;
		int nextY = position.y;
		switch(indexDirection){
			case NORTH:
				nextY++;
				break;
			case EAST:
				nextX++;
				break;
			case SOUTH:
				nextY--;
				break;
			case WEST:
				nextX--;
				break;
		}
		return move(nextX,nextY);
	}
	
	private boolean moveBackward(){
		int nextX = position.x;
		int nextY = position.y;
		switch(indexDirection){
			case NORTH:
				nextY--;
				break;
			case EAST:
				nextX--;
				break;
			case SOUTH:
				nextY++;
				break;
			case WEST:
				nextX++;
				break;
		}
		return move(nextX,nextY);
	}
	
	private boolean move(int nextX,int nextY){
		if(nextX==-1)
			nextX=planet.getDimX()-1;
		if(nextY==-1)
			nextY=planet.getDimY()-1;
		
		nextX = nextX%planet.getDimX();
		nextY = nextY%planet.getDimY();
		
		if(planet.isObstacle(nextX, nextY))
			return false;
		else{
			position.x = nextX;
			position.y = nextY;
			return true;
		}
	}
	
	public boolean executeCommands(char[] commands){
		for(int i=0; i< commands.length; i++){
			System.out.println(commands[i]);
			if(!executeCommand(commands[i]))
			{
				System.out.println("Obstacle found!");
				return false;
			}
			System.out.println(this);
		}
		return true;
	}
	
	private boolean executeCommand(char command){
		switch(command){
			case FORWARD_COMMAND:
				return moveForward();
			case BACKWARD_COMMAND:
				return moveBackward();
			case TURNLEFT_COMMAND:
				return turnLeft();
			case TURNRIGHT_COMMAND:
				return turnRight();
			default:
				return false;
		}
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
	public String toString(){
		return String.format(ROVER_PRINT, getDirection(), position.x, position.y);
	}

}