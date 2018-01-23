
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
		grid[x][y]=obstacle;
	}
	
	public boolean isObstacle(int x, int y){
		return grid[x][y];
	}
}
