/**
 * Represents the base for the TowerDefense game.  Has
 * health variable and constantally checks to see if an
 * Enemy has reached it. Game ends when health == 0.
 * @author Jesse Fowler
 * @version 1.0
 */
public class Base {

    private TowerDefense td;
    private int health;

    /** Creates the base and takes the TowerDefense game
      * that called it as a paramater
      * @param td The TowerDefense that called it.
      */
    public Base(TowerDefense td) {
        this.td = td;
        this.health = 25;
    }

    /** Constantly being called by TowerDefense checks
      * to see if an Enemy is on the Base and if the health
      * is above 0.
      */
    public void draw() {

       //--- Alerts When Enemy Completes Path//---
        for (Enemy e: this.td.getEnemies()) {
            if (e.getX() <= -50 && this.td.getGamestate()
                == this.td.getGamestatePlaying()) {
                this.health = this.health - 1;
                this.td.addScore(-10);
                e.setHealth(0);
                System.out.println("Base Health: " + this.health);
            }
        }

       //--- Alerts When Out of Health//---
        if (this.health <= 0) {
            this.td.setGamestate(this.td.getGamestateGameover());
        }

    }
}
