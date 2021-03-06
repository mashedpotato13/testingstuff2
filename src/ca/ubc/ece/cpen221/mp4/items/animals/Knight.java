package ca.ubc.ece.cpen221.mp4.items.animals;

import javax.swing.ImageIcon;

import ca.ubc.ece.cpen221.mp4.Food;
import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.ai.AI;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.items.LivingItem;

/*
 * Shining Knight for the Queen
 */
public class Knight implements ArenaAnimal {

    private static final int INITIAL_ENERGY = 100;
    private static final int MAX_ENERGY = 100;
    private static final int STRENGTH = 250;
    private static final int VIEW_RANGE = 10;
    private static final int MIN_BREEDING_ENERGY = 25;
    private static final int COOLDOWN = 2;
    private static final ImageIcon knightImage = Util.loadImage("knight.gif");

    private final AI ai;

    private Location location;
    private int energy;

    public Knight(AI knightAI, Location initialLocation) {
        this.ai = knightAI;
        this.location = initialLocation;

        this.energy = INITIAL_ENERGY;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public LivingItem breed() {
        Knight child = new Knight(ai, location);
        child.energy = energy / 2;
        this.energy = energy / 2;
        return child;
    }

    @Override
    public void eat(Food food) {
        energy = Math.min(MAX_ENERGY, energy + food.getMeatCalories());

    }

    @Override
    public void moveTo(Location targetLocation) {
        location = targetLocation;

    }

    @Override
    public int getMovingRange() {
        return 1;
    }

    @Override
    public ImageIcon getImage() {
        return knightImage;
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    @Override
    public void loseEnergy(int energyLoss) {
        this.energy = this.energy - energyLoss;

    }

    @Override
    public boolean isDead() {
        return energy <= 0;
    }

    @Override
    public int getPlantCalories() {
        // Knight is not a plant.
        return 0;
    }

    @Override
    public int getMeatCalories() {
        return energy;
    }

    @Override
    public int getCoolDownPeriod() {
        return COOLDOWN;
    }

    @Override
    public Command getNextAction(World world) {
        Command nextAction = ai.getNextAction(world, this);
        this.energy--; // Loses 1 energy regardless of action.
        return nextAction;
    }

    @Override
    public int getMaxEnergy() {
        return MAX_ENERGY;
    }

    @Override
    public int getViewRange() {
        return VIEW_RANGE;
    }

    @Override
    public int getMinimumBreedingEnergy() {
        return MIN_BREEDING_ENERGY;
    }

}
