import processing.core.*;

import java.util.HashSet;
import java.util.Set;


public class GameHandler extends PApplet{
  public static void main(String args[]) {
    PApplet.main(new String[] { "--present", "processingApp" });
  }

  Set<GameObject> objects;
  int[][] tileGrid;

  public void setup() {
    //initialize game screen and tile grid
    size(800,500);
    tileGrid = new int[50][80];
  }

  public void draw() {
    background(100);
    for (GameObject m : objects) {
      m.update(1 / frameRate);
    }

    // Detect Collisions
    // Resolve Collisions
    // Render scene
  }
}
