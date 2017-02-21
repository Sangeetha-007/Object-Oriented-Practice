
public class DriverProgram {
	public static void main(String[] args){
		Queen lastQueen = null;
		for(int i = 1; i <= 8; i++)
		{
			lastQueen = new Queen(i,lastQueen);
		}
		lastQueen.print();
	}
}
