package adventure;

import java.util.Random;

public class AdventureWorld
{
	/*
	 * Class Instance Variables
	 * 
	 */

	private Location[][][]	worldMap;
	
	/*
	private NukeTree[]		nukeTrees;
	private WolfTree[]		wolfTrees;
	*/
	
	/*
	 * Class Constants
	 * 
	 */
	
	private static final 	WorldDimension WORLD_LOCATIONS				= new WorldDimension(10000, 10000, 100);	// In Locations
	public static final 	WorldDimension	WORLD_LOCATION_DIMENSION	= new WorldDimension(1, 1, 1);				// In feet (x:width, y:height, Z:length/depth)
	private static final 	String			WORLD_LOCATION_DESCRIPTION	= "World Location ";

	/*
	private final int		NUMBER_OF_NUKE_TREES		= 200;
	private final int		NUMBER_OF_BRANCHES			= 20;
	private final int		NUMBER_OF_ROOTS				= 30;
	private final int		NUMBER_OF_SILOS				= 20;
	private final int		NUMBER_OF_MISSILES			= 340;
	private final int		NUMBER_OF_WOLF_TREES		= 100;
	private final int		NUMBER_OF_ROOMS				= 10;
	private final int		NUMBER_OF_WOLVES			= 100;
	*/
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public AdventureWorld()
	{
		/*
		 * Create the World Locations and their Exits
		 * 
		 */
		
		boolean exitAdded = false;
		
		worldMap = new Location[WORLD_LOCATIONS.getWidth()][WORLD_LOCATIONS.getHeight()][WORLD_LOCATIONS.getLength()];

		// Width
		for (int x = 0; x < worldMap.length; x++)
		{
			// Height
			for (int y = 0; y < worldMap[x].length; y++)
			{
				// Length / Depth
				for (int z = 0; z < worldMap[x][y].length; z++)
				{
					worldMap[x][y][z] = new Location(new WorldLocation(x, y, z), WORLD_LOCATION_DIMENSION, WORLD_LOCATION_DESCRIPTION + x + "," + y + "," + z, LocationTypes.WORLD);
				}	
			}
		}
		
		// Create the Locations' Exits

		for (int x = 0; x < worldMap.length; x++)
		{
			for (int y = 0; y < worldMap[x].length; y++)
			{
				for (int z = 0; z < worldMap[x][y].length; z++)
				{
					if (x > 0)
					{
						exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z - 1][x], 2);
	
						if (!exitAdded)
						{
							cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 2 << " at row " << (z - 1) << " col " << (x) << endl;
						}
	
						if (x > 0)
						{
							exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z - 1][x - 1], 1);
	
							if (!exitAdded)
							{
								cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 1 << " at row " << (z - 1) << " col " << (x - 1) << endl;
							}
						}
	
						if (x < GRID_SIZE - 1)
						{
							exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z - 1][x + 1], 3);
	
							if (!exitAdded)
							{
								cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 3 << " at row " << (z - 1) << " col " << (x + 1) << endl;
							}
						}
					}
	
					if (z < GRID_SIZE - 1)
					{
						exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z + 1][x], 7);
	
						if (!exitAdded)
						{
							cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 7 << " at row " << (z + 1) << " col " << (x) << endl;
						}
	
						if (x > 0)
						{
							exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z + 1][x - 1], 6);
	
							if (!exitAdded)
							{
								cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 6 << " at row " << (z + 1) << " col " << (x - 1) << endl;
							}
						}
	
						if (x < GRID_SIZE - 1)
						{
							exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z + 1][x + 1], 8);
	
							if (!exitAdded)
							{
								cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 8 << " at row " << (z + 1) << " col " << (x + 1) << endl;
							}
						}
					}
	
					if (x > 0)
					{
						exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z][x - 1], 4);
	
						if (!exitAdded)
						{
							cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 4 << " at row " << (z) << " col " << (x - 1) << endl;
						}
					}
	
					if (x < GRID_SIZE - 1)
					{
						exitAdded = gameGrid[z][x]->addNeighbor(gameGrid[z][x + 1], 5);
	
						if (!exitAdded)
						{
							cout << "Cell at row " << z << " col " << x << "coud not add neighbor #" << 5 << " at row " << (z) << " col " << (x + 1) << endl;
						}
					}
				}
			}
		}
		
		bool addNeighbor(Cell *cell, int position)
		{
			bool neighborAdded = false;

			if (numberOfNeighbors < MAX_NEIGHBORS)
			{
				if (cellNeighbors[position - 1] == nullptr)
				{
					cellNeighbors[position - 1] = cell;

					numberOfNeighbors++;

					neighborAdded = true;
				}
			}

			return  neighborAdded;
		}
		
		/*
		 * Create the Nuke Trees
		 * 
		 */
		
		/*
		nukeTrees = new NukeTree[NUMBER_OF_NUKE_TREES];
		
		for (int index = 0; index < NUMBER_OF_NUKE_TREES; index++)
		{
			int numberOfMissiles = randomizer(NUMBER_OF_MISSILES);
			
			if (numberOfMissiles < 10)
			{
				numberOfMissiles = 10;
			}
			
			nukeTrees[index] = new NukeTree(index + 1, NUMBER_OF_BRANCHES, NUMBER_OF_ROOTS, NUMBER_OF_SILOS, numberOfMissiles);
		}
		*/
		
		/*
		 * Create the Wolf Trees
		 * 
		 */

		/*
		wolfTrees = new WolfTree[NUMBER_OF_WOLF_TREES];
		
		for (int index = 0; index < NUMBER_OF_WOLF_TREES; index++)
		{
			int numberOfWolves = randomizer(NUMBER_OF_WOLVES);
			
			if (numberOfWolves < 10)
			{
				numberOfWolves = 10;
			}
			
			wolfTrees[index] = new WolfTree(index + 1, NUMBER_OF_BRANCHES, NUMBER_OF_ROOTS, NUMBER_OF_ROOMS, numberOfWolves);
		}
		*/
	}
	
	/*
	 * Randomizer Method
	 * 
	 */
	
	private int randomizer(int max)
	{
		int number = 0;

		Random randomNumber = new Random();

		number = randomNumber.nextInt(max) + 1;
		
		return number;
	}
}
