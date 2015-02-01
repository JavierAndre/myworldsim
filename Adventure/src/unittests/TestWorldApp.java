package unittests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import myworldsim.Direction;
import myworldsim.World;

public class TestWorldApp {

	public static void main(String[] args) throws FileNotFoundException
	{
		// Create the World
		World world = new World();

		//File file 			= new File("testworld.txt");
		//PrintWriter output 	= new PrintWriter(file);
		
		// Display the World Location Exits
		for (int row = 0; row < world.getWorldLength(); row++)
		{
			for (int col = 0; col < world.getWorldWidth(); col++)
			{
				//System.out.println("Location:\t" + row + ", " + col);
				//output.printf("%19s%26s\n", "Location:", "" + row + ", " + col);
				
				for (Direction dir : Direction.values())
				{
					//output.printf("%20s%25s\n", dir.name() + " Exit to: ", world.getWorldLocation(row, col).getExit(dir.ordinal()).getExitToLocation().getDescription());
				}
				
				//output.println();
			}
		}
		
		//output.close();
		System.out.println("World test completed.");
	}
}
