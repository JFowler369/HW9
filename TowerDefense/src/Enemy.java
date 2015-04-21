/**
 * Represents a basic Enemy type.  Has health, speed and coordinate variables
 * @author Jesse Fowler
 * @version 1.0
 */
public class Enemy {

    private int x;
    private int y;
    private int size;
    private int speed;
    private int health;
    private int time;
    private boolean firing;
    private String name;

    /** Creates an Enemy with preset base stats.
      * @param td The TowerDefense game creating the Enemy
      */
    public Enemy(TowerDefense td) {

        this.x = 100000000;
        this.y = td.getHeight() + 20;
        this.size = td.getPathSize() - 15;
        this.speed = 1;
        this.health = 15;
        this.time = 0;
        this.firing = false;
        this.name = "Enemy";

    }

    /** Called constatly to "move" the Enemy across the screen
      */
    public void draw() {
        this.x -= speed;
        this.time = this.time + 1;
    }

    /** Returns the x coordinate of the Enemy
      * @return The x coordinate of the Enemy
      */
    public int getX() {
        return this.x;
    }

    /** Returns the Y coordinate of the Enemy
      * @return The Y coordinate of the Enemy
      */
    public int getY() {
        return this.y;
    }

    /** Returns the remaining health of the Enemy
      * @return The remaining health of the Enemy
      */
    public int getHealth() {
        return this.health;
    }

    /** Returns the size of the Enemy
      * @return The size of the Enemy
      */
    public int getSize() {
        return this.size;
    }

    /** Returns whether or not the Enemy is being fired on
      * @return Whether or not the Enemy is being fired on
      */
    public boolean isFiring() {
        return this.firing;
    }

    /** Sets the firing Boolean to true or false
      * @param b What you want to set firing to
      */
    public void setFiring(boolean b) {
        this.firing = b;
    }

    /** Sets the Health of the Enemy to a certain number
      * @param h The int to set health to
      */
    public void setHealth(int h) {
        this.health = h;
    }

    /** Sets the Speed of the Enemy to a certain value
      * @param s The new speed of the Enemy
      */
    public void setSpeed(int s) {
        this.speed = s;
    }

    /** Sets the name of the Enemy
      * @param n The new name of the Enemy
      */
    public void setName(String n) {
        this.name = n;
    }

    /** Decreases the health a certain ammount
      * @param d The ammount to decrease the health
      */
    public void damage(int d) {
        this.health -= d;
    }

    /** Returns the String representation of the Enemy
      * @return The String representation of the Enemy
      */
    public String toString() {
        return this.name + ": " + this.health;
    }
}
