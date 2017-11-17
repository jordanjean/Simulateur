package game.map;

public class Position {

	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "x:"+new Integer(x).toString() +" y: " + new Integer(y).toString()+ "|";
	}
	
	public Boolean equals(Position p){
		return ((this.x == p.getX()) && (this.y == p.getY()));
	}
}
