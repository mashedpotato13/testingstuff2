package ca.ubc.ece.cpen221.mp4;

import javax.swing.SwingUtilities;

import ca.ubc.ece.cpen221.mp4.ai.FoxAI;
import ca.ubc.ece.cpen221.mp4.ai.KillerRabbitAI;
import ca.ubc.ece.cpen221.mp4.ai.KnightAI;
import ca.ubc.ece.cpen221.mp4.ai.RabbitAI;
import ca.ubc.ece.cpen221.mp4.ai.SniperAI;
import ca.ubc.ece.cpen221.mp4.items.Gardener;
import ca.ubc.ece.cpen221.mp4.items.Grass;
import ca.ubc.ece.cpen221.mp4.items.animals.Fox;
import ca.ubc.ece.cpen221.mp4.items.animals.Gnat;
import ca.ubc.ece.cpen221.mp4.items.animals.KillerRabbit;
import ca.ubc.ece.cpen221.mp4.items.animals.Knight;
import ca.ubc.ece.cpen221.mp4.items.animals.Rabbit;
import ca.ubc.ece.cpen221.mp4.items.animals.Sniper;
import ca.ubc.ece.cpen221.mp4.items.vehicles.Bulldozer;
import ca.ubc.ece.cpen221.mp4.items.vehicles.DonaldTrump;
import ca.ubc.ece.cpen221.mp4.items.vehicles.HolyGrenadeTank;
import ca.ubc.ece.cpen221.mp4.otheritems.HolyHandGrenade;
import ca.ubc.ece.cpen221.mp4.otheritems.Mine;
import ca.ubc.ece.cpen221.mp4.otheritems.Wall;
import ca.ubc.ece.cpen221.mp4.staff.WorldImpl;
import ca.ubc.ece.cpen221.mp4.staff.WorldUI;

/**
 * The Main class initialize a world with some {@link Grass}, {@link Rabbit}s,
 * {@link Fox}es, {@link Gnat}s, {@link Gardener}, etc.
 *
 * You may modify or add Items/Actors to the World.
 *
 */
public class Main {

	static final int X_DIM = 40;
	static final int Y_DIM = 40;
	static final int SPACES_PER_GRASS = 7;
	static final int INITIAL_GRASS = X_DIM * Y_DIM / SPACES_PER_GRASS;
	static final int INITIAL_GNATS = INITIAL_GRASS / 4;
	static final int INITIAL_RABBITS = INITIAL_GRASS / 4;
	static final int INITIAL_FOXES = INITIAL_GRASS / 32;
	static final int INITIAL_TIGERS = INITIAL_GRASS / 32;
	static final int INITIAL_BEARS = INITIAL_GRASS / 40;
	static final int INITIAL_HYENAS = INITIAL_GRASS / 32;
	static final int INITIAL_CARS = INITIAL_GRASS / 100;
	static final int INITIAL_TRUCKS = INITIAL_GRASS / 150;
	static final int INITIAL_MOTORCYCLES = INITIAL_GRASS / 64;
	static final int INITIAL_MANS = INITIAL_GRASS / 150;
	static final int INITIAL_WOMANS = INITIAL_GRASS / 100;
	static final int INITIAL_HUNTERS = INITIAL_GRASS / 150;
	static final int INITIAL_HHG = 1;
	static final int INITIAL_MINE = 2;
	static final int INITIAL_KNIGHTS = 5;
	static final int INITIAL_SNIPERS = 5;
	static final int INITIAL_TRUMPS = 2;
	static final int INITIAL_KILLER_RABBITS = 3;
	static final int INITIAL_BULLDOZER = 2;
	static final int INITIAL_HHGTANK = 2;
	static final int INITIAL_WALL = 1;

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().createAndShowWorld();
			}
		});
	}

	/*
	 * Create and initializes testing world
	 */
	public void createAndShowWorld() {
		World world = new WorldImpl(X_DIM, Y_DIM);
		initialize(world);
		new WorldUI(world).show();
	}

	/**
	 * Initializes animals, vehicles, and items to world
	 * 
	 * @param world
	 *            world where animals, vehicles, and items are initialized
	 */
	public void initialize(World world) {
		addGrass(world);
		world.addActor(new Gardener());

		addGnats(world);
		addRabbits(world);
		addFoxes(world);
		
		
		addSniper(world);
		addHHGTank(world);
		addKnights(world);
		addTrumps(world);
		addBulldozer(world);
		
		addKillerRabbits(world);
		addHHG(world);
		addMine(world);
		addWall(world);

		// TODO: You may add your own creatures here!
	}

	/*
	 * Add grass to world
	 */
	private void addGrass(World world) {
		for (int i = 0; i < INITIAL_GRASS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			world.addItem(new Grass(loc));
		}
	}
	/*
	 * Add wall to world
	 */
	private void addWall(World world) {
		for (int i = 0; i < INITIAL_WALL; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			world.addItem(new Wall(loc));
		}
	}

	/*
	 * Add Gnats to world
	 */
	private void addGnats(World world) {
		for (int i = 0; i < INITIAL_GNATS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Gnat gnat = new Gnat(loc);
			world.addItem(gnat);
			world.addActor(gnat);
		}
	}

	/*
	 * Add Foxes to world
	 */
	private void addFoxes(World world) {
		FoxAI foxAI = new FoxAI();
		for (int i = 0; i < INITIAL_FOXES; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Fox fox = new Fox(foxAI, loc);
			world.addItem(fox);
			world.addActor(fox);
		}
	}

	/*
	 * Add Rabbits to world
	 */
	private void addRabbits(World world) {
		RabbitAI rabbitAI = new RabbitAI();
		for (int i = 0; i < INITIAL_RABBITS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Rabbit rabbit = new Rabbit(rabbitAI, loc);
			world.addItem(rabbit);
			world.addActor(rabbit);
		}
	}

	/*
	 * Add Knights to world
	 */
	private void addKnights(World world) {
		KnightAI knightAI = new KnightAI();
		for (int i = 0; i < INITIAL_KNIGHTS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Knight knight = new Knight(knightAI, loc);
			world.addItem(knight);
			world.addActor(knight);
		}
	}

	/*
	 * Add Sniper to world
	 */
	private void addSniper(World world) {
		SniperAI sniperAI = new SniperAI();
		for (int i = 0; i < INITIAL_SNIPERS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Sniper sniper = new Sniper(sniperAI, loc);
			world.addItem(sniper);
			world.addActor(sniper);
		}
	}

	/*
	 * Add HolyHandGrenades to world
	 */
	private void addHHG(World world) {
		for (int i = 0; i < INITIAL_HHG; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			HolyHandGrenade hhg = new HolyHandGrenade(loc);
			world.addItem(hhg);
			world.addActor(hhg);
		}
	}

	/*
	 * Add Mines to world
	 */
	private void addMine(World world) {
		for (int i = 0; i < INITIAL_MINE; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Mine mine = new Mine(loc);
			world.addItem(mine);
			world.addActor(mine);
		}
	}

	/*
	 * Add Donald Trumps to world
	 */
	private void addTrumps(World world) {

		for (int i = 0; i < INITIAL_TRUMPS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			DonaldTrump trump = new DonaldTrump(loc);
			world.addItem(trump);
			world.addActor(trump);
		}
	}

	/*
	 * Add Bulldozers to world
	 */
	private void addBulldozer(World world) {

		for (int i = 0; i < INITIAL_BULLDOZER; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			Bulldozer bulldozer = new Bulldozer(loc);
			world.addItem(bulldozer);
			world.addActor(bulldozer);
		}
	}

	/*
	 * Add KillerRabbits to world
	 */
	private void addKillerRabbits(World world) {
		KillerRabbitAI killerRabbitAI = new KillerRabbitAI();
		for (int i = 0; i < INITIAL_KILLER_RABBITS; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			KillerRabbit caerbonnog = new KillerRabbit(killerRabbitAI, loc);
			world.addItem(caerbonnog);
			world.addActor(caerbonnog);
		}
	}

	/*
	 * Add HolyHandGrenade Tanks to world
	 */
	private void addHHGTank(World world) {
		for (int i = 0; i < INITIAL_HHGTANK; i++) {
			Location loc = Util.getRandomEmptyLocation(world);
			HolyGrenadeTank tank = new HolyGrenadeTank(loc);
			world.addItem(tank);
			world.addActor(tank);
		}
	}

}