/**
 * Represents a basic Tower type.  Has damage, cost, and target variables
 * @author Jesse Fowler
 * @version 1.0
 */
public class Tower {

    private int x;
    private int y;
    private int size;
    private int z;
    private int damage;
    private int cost;
    private boolean firing;
    private TowerDefense td;
    private Enemy target;

    /** Creates a Tower with a set x,y coordinate and z value
      * @param aX The x coordinate of the Tower
      * @param aY The y coordinate of the Tower
      * @param aZ The z value of the Tower
      * @param aTD The TowerDefense game that created the Tower
      */
    public Tower(int aX , int aY , int aZ, TowerDefense aTD) {
        this.x = aX;
        this.y = aY;
        this.size = 150;
        this.z = aZ;
        this.firing = false;
        this.damage = (1 / 10);
        this.td = aTD;
        this.cost = 100;
    }

    /** Constantly called would draw the Tower on the screen and checks
      * if an Enemy is in it's range then fires on it
      */
    public void draw() {

        if (this.z == 2) {
           //--- Shooting//---
            for (Enemy e: this.td.getEnemies()) {
                if (e.getX() < this.x + this.size / 2
                    && e.getX() + e.getSize() > this.x - this.size / 2) {
                    if (e.getY() < this.y + this.size / 2
                        && e.getY() + e.getSize() > this.y - this.size / 2) {
                        if (!this.firing) {
                            this.firing = true;
                            this.target = e;
                        }
                    } else {
                        this.firing = false;
                    }
                }
                this.firing();
            }
        }
        this.update();

    }

    private void firing() {
        if (this.firing) {
            this.target.damage(damage);
            if (this.target.getHealth() <= 0) {
                this.firing = false;
            }
        }
    }

    private void update() {

       //--- Checks to See if Target is in Range//---
        if (this.target != null) {
            if (this.target.getX() > this.x + this.size / 2
                || this.target.getX()
                + this.target.getSize() < this.x - this.size / 2) {
                this.target = null;
                this.firing = false;
            }
        }
        if (this.target != null) {
            if (this.target.getY() > this.y + this.size / 2
                || this.target.getY() + this.target.getSize()
                < this.y - this.size / 2) {
                this.target = null;
                this.firing = false;
            }
        }
    }

    /** Sets the cost of the Tower
      * @param c The new cost of the Tower
      */
    public void setCost(int c) {
        this.cost = c;
    }

    /** Sets the damgae of the Tower
      * @param d The new Damage for the tower
      */
    public void setDamage(int d) {
        this.damage = d;
    }
}
