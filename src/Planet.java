

public class Planet {
	private int dimX;
	private int dimY;
	private boolean[][] grid;
	
	public Planet(int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		grid = new boolean[dimX][dimY];
	}

	public int getDimX() {
		return dimX;
	}
	
	public int getDimY() {
		return dimY;
	}
	
	public void setObstacle(int x, int y, boolean obstacle){
		if(validXY(x,y))
			grid[x][y]=obstacle;
	}
	
	public boolean isObstacle(int x, int y){
		return grid[x][y];
	}
	
	public boolean validXY(int x, int y){
		if(x<dimX && y<dimY && x>=0 && y>=0)
			return true;
		else
			return false;
	}
}
