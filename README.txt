----- Game Mode/Logic -----

-Have Classes for Enemies and towers

-Towers have x and y coordinates, damage, and cost variables

-Enemys have x and y coordinates, speed, health, and Name variables

-Different Enemy and Tower classes extend base classes

----- Game Functionality -----

-Enemies theoretically move across screen (no visual represnetation)

-Towers have code to detect if an Enemy is in a certain range and will then fire
  damaging the Enemy

-Once and Enemy's health drops below 0 it is removed
  from the ArrayList and score is added

-Once the ArrayList is empty the round is increased and more Enemy spawn

-Sample code of Enemys moving left and damaging the base once they move off the
  "Screen" then being despawned and new round starting once all are removed
  Game ends when base health == 0

-After 2 rounds Enemys become Goombas that are faster and have more health and
  Ammount of Enemys increase each round.

-Has Function that resets all Game parameters to starting values (restarts game)

-Gamestates control when the game checks parameters (stops moving Enemys and
  checking tower range when Base health == 0/ gamestate = GAMEOVER)

----- App Structure & Packaging -----

-Included executable jar file that runs basic program that spawns Enemies
  and once their x-coordinate reaches a certain point damages the base
    and removes them from the game

-Includes folder with ant build file that compiles source files and then
  creates and runs an executable jar file as well
    as run checkstyle and create and checkstyles javadocs

- Ant commands: init - initializes directories
                compile - compiles files in /src to /build
                dist - creates jar file from classes in /build
                run - runs jar file from /dist/lib
                checkstyle - runs checkstyle.jar on files in /src
                javadoc - creates javadoc from files in /src
                javadoccheck - runs checkstyle.jar -j on files in /src
