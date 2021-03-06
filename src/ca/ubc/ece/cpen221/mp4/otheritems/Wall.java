package ca.ubc.ece.cpen221.mp4.otheritems;

import javax.swing.ImageIcon;

import ca.ubc.ece.cpen221.mp4.Location;
import ca.ubc.ece.cpen221.mp4.Util;
import ca.ubc.ece.cpen221.mp4.World;
import ca.ubc.ece.cpen221.mp4.commands.Command;
import ca.ubc.ece.cpen221.mp4.commands.WaitCommand;

/*
 * Walls are a barrier that most items cannot pass
 */
public class Wall implements ActingItem {
    private final static ImageIcon wallImage = Util.loadImage("wall.gif");
    private final static int strength = 500;

    private Location location;
    private boolean isDead;

    public Wall(Location location) {
        this.location = location;
        this.isDead = false;
    }

    @Override
    public ImageIcon getImage() {
        return wallImage;
    }

    @Override
    public String getName() {
        return "wall";
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getPlantCalories() {
        return 0;
    }

    @Override
    public int getMeatCalories() {
        return 0;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void loseEnergy(int energy) {
        isDead = true;

    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public int getCoolDownPeriod() {

        return 0;
    }

    /**
     * Wait command
     * 
     * @param world
     *            world wall is in
     * @return Command: Wait
     */
    @Override
    public Command getNextAction(World world) {
        // doesn't move
        return new WaitCommand();
    }

}