import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Main Application for TowerDefense game creates and calls Enemys and keeps
 * track of map, base, Enemys, and Towers
 * @author Jesse Fowler
 * @version 1.0
 */
public class TowerDefense extends Application {

    //----- Game Variables -----//
    private int width = 1000;
    private int height = 1000;
    private int round = 1;
    private int menuStart = 3 * width / 4;
    private int pathSize = width / 15;
    private int score = 150;
    private boolean soundLose = false;
    private Level level = new Level(1);
    private boolean nextRound = false;
    private boolean enemyAdd = false;

    //----- GameStates -----//
    private int gamestatePLAYING = 283;
    private int gamestateGAMEOVER = 728;
    private int gamestate = gamestatePLAYING;

    //----- Enemy Variables -----//
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Base base = new Base(this);
    private int enemiesKilled = 0;
    private int maxEnemy = 5 + ((round - 1) * 2);

    //----- Tower Variables -----//
    private ArrayList<Tower> towers = new ArrayList();
    private int tower = 1;

    /** Creates Enemys and stage then continuously calls the draw() function
      * @param stage Stage to draw on
      */
    @Override public void start(Stage stage) throws Exception {
        enemies.add(new Enemy(this));

        Label label = new Label("Tests in Command Prompt");
        Scene scene = new Scene(label);
        stage.setScene(scene);
        stage.setTitle("TowerDefense");
        stage.show();
        System.out.println("Test");

        while (this.gamestate == this.gamestatePLAYING) {
            this.draw();
        }
    }

    /** Keeps track of all the game Variable and calls object draw functions
      * and creates Enemys based on round
      * Also keeps track of gamestate
      */
    public void draw() {

        if (gamestate == gamestatePLAYING || gamestate == gamestateGAMEOVER) {
            //----- Draws Selected Level -----
            if (this.level != null) {
                this.level.draw();
            }

            //----- Spawns && Draws Enemies -----
            if (!this.nextRound) {
                for (Enemy e: enemies) {
                    e.draw();
                    if (enemies.size() < maxEnemy) {
                        if (e.getX() == 95000000) {
                            enemyAdd = true;
                        }
                    }
                }
            }
            //----- Changes Enemy Spawn based on round -----//
            if (enemyAdd) {
                if (this.round <= 2) {
                    enemies.add(new Enemy(this));
                    System.out.println(enemies.toString());
                    enemyAdd = false;
                }
                if (this.round > 2) {
                    enemies.add(new Goomba(this));
                    System.out.println(enemies.toString());
                    enemyAdd = false;
                }

            }


            //----- Despawns Enemies -----
            for (int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).getHealth() <= 0) {
                    enemies.get(i).setFiring(false);
                    enemies.remove(i);
                    enemiesKilled = enemiesKilled + 1;
                    score = score + 15;
                }
            }

            //----- Alerts When Round Is Over
            if (enemiesKilled >= maxEnemy) {
                round = round + 1;
                maxEnemy = 5 + ((round - 1) * 2);
                nextRound = true;
            }

            base.draw();

            //----- Draws Towers -----
            for (Tower f: towers) {
                if (f != null) {
                    f.draw();
                }
            }

            //----- Resets Round -----
            if (nextRound) {
                enemies = new ArrayList<Enemy>();
                enemies.add(new Enemy(this));
                enemiesKilled = 0;
                nextRound = false;
                System.out.println("Round: " + this.round);
            }
        }

        if (this.gamestate == this.gamestateGAMEOVER) {
            System.out.println("GameOver");

        }
    }

    /** Resets the Game parameters to default values
      */
    public void resetGame() {

        //----- Game Variables -----
        round = 1;
        gamestate = gamestatePLAYING;
        score = 150;

        //----- Enemy Variables -----
        enemies = new ArrayList<Enemy>();
        base = new Base(this);
        enemiesKilled = 0;
        maxEnemy = 5 + ((round - 1) * 2);

        //----- Tower Variables -----
        tower = 1;
        towers = new ArrayList<Tower>();
    }

    /** Returns the height of the game
      * @return The height of the game
      */
    public int getHeight() {
        return this.height;
    }

    /** Returns the pathSize of the game
      * @return The pathSize of the game
      */
    public int getPathSize() {
        return this.pathSize;
    }

    /** Returns the ArrayList of Enemys
      * @return The ArrayList of Enemys
      */
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    /** Returns the current gamestate
      * @return The current gamestate
      */
    public int getGamestate() {
        return this.gamestate;
    }

    /** Returns the value of gamestatePLAYING
      * @return The value of gamestatePLAYING
      */
    public int getGamestatePlaying() {
        return this.gamestatePLAYING;
    }

    /** Returns the value of gamestateGAMEOVER
      * @return The value of gamestateGAMEOVER
      */
    public int getGamestateGameover() {
        return this.gamestateGAMEOVER;
    }

    /** Sets the gamestate to a new value
      * @param x The new gamestate value
      */
    public void setGamestate(int x) {
        this.gamestate = x;
    }

    /** Returns the game Score
      * @return The game Score
      */
    public int getScore() {
        return this.score;
    }

    /** Adds a value to the game score
      * @param x The value to be added to the game score
      */
    public void addScore(int x) {
        this.score += x;
    }
}
