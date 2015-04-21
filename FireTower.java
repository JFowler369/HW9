/**
 * Represents a Tower variant. Has increased cost and damage
 * @author Jesse Fowler
 * @version 1.0
 */
public class FireTower extends Tower {

    /** Creates a Tower and changes it's default cost and damage
      * @param aX The x coordinate of the Tower
      * @param aY The y coordinate of the Tower
      * @param aZ The z value of the Tower
      * @param aTD The TowerDefense game that created the Tower
      */
    public FireTower(int aX , int aY , int aZ, TowerDefense aTD) {
        super(aX, aY, aZ, aTD);
        super.setDamage(1 / 5);
        super.setCost(500);
    }

}
