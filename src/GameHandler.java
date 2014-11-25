/**
 * Main class for the game engine.  This is a Processing specific file to get
 * us started, but in the future we should try to abstract the game out so that
 * it can be run in different environments or whatever.
 */
import processing.core.*;

import java.util.HashSet;
import java.util.Set;


public class GameHandler extends PApplet{
  public static void main(String args[]) {
    PApplet.main(new String[] { "--present", "processingApp" });
  }

  Set<AbstractDynamicGameObject> objects;
  int[][] tileGrid;

  public void setup() {
    //initialize game screen and tile grid
    size(800,500);
    tileGrid = new int[50][80];
    objects = new HashSet<>();
  }

  public void draw() {
    if (frameCount % 60 == 0) {
      objects.add(new CircleObject.Builder(this)
              .position(new Vector2D((double) frameCount % width, 50.0))
              .build());
    }

    background(100);
    for (AbstractDynamicGameObject m : objects) {
      m.applyForce(new Vector2D(0, 5));
      m.update(1 / frameRate);
    }

    // Detect Collisions
    // Resolve Collisions
    // Render scene
  }
}
