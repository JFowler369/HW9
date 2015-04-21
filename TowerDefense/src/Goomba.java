/**
 * Represents a Goomba that is an Enemy with more health and speed
 * @author Jesse Fowler
 * @version 1.0
 */
public class Goomba extends Enemy {

    /** Creates an Enemy then gives it different stats and name
      * @param td The TowerDefense game that created the object
      */
    public Goomba(TowerDefense td) {
        super(td);
        super.setSpeed(2);
        super.setHealth(25);
        super.setName("Goomba");
    }
}
