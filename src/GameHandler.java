/**
 * Main class for the game engine.  This is a Processing specific file to get
 * us started, but in the future we should try to abstract the game out so that
 * it can be run in different environments or whatever.
 */

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class GameHandler extends PApplet {
  public static void main(String args[]) {
    PApplet.main(new String[] { "--present", "GameHandler" });
  }

  ArrayList<AbstractDynamicGameObject> objects;
  //int[][] tileGrid;

  public void setup() {
    //initialize game screen and tile grid
    size(displayWidth, displayHeight);
    //tileGrid = new int[50][80];
    objects = new ArrayList<>();
    objects.add(new CircleObject.Builder(this).build());
  }

  public void draw() {
    background(100);

    if (frameCount % 120 == 0) {
      objects.add(new CircleObject.Builder(this)
              .position(new Vector2D(0, frameCount % displayWidth))
              .radius(50)
              .mass(frameCount / 500)
              .build());
    }

    for (AbstractDynamicGameObject m : objects) {
      m.applyForce(new Vector2D(0, 100));
      m.update(1 / frameRate);
      if (m.getPosition().getFirst() > width) {
        objects.remove(m);
        break;
      }
      m.render();
      m.accumulator.clearForces();
    }

    // Detect Collisions
    // Resolve Collisions
    // Render scene
  }
}