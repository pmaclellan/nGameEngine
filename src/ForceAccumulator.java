/**
 * A helper construct for summing the various forces acting upon a single object
 * at a given time.  The accumulated force is then used to calculate the
 * object's new acceleration.
 */
import java.util.Vector;

public class ForceAccumulator {
  Vector<Vector2D> forces;

  public ForceAccumulator() {
    forces = new Vector<>();
  }

  /**
   * Adds a single force to the accumlator.
   *
   * @param force the force to be summed
   */
  public void addForce(Vector2D force) {
    forces.add(force);
  }

  /**
   * Clears all forces from the accumulator.  This likely should be used after
   * each frame.
   */
  public void clearForces() {
    forces.clear();
  }

  public int size() {
    return forces.size();
  }

  /**
   * Sums all of the forces that are currently present in the accumulator.
   *
   * @return the total combined force
   */
  public Vector2D accumulate() {
    // return a zero-vector if no forces are present
    //if (forces.size() == 0) {
    //  return new Vector2D();
    //}

    Vector2D totalForce = new Vector2D();

    for (Vector2D force : forces) {
      totalForce = totalForce.add(force);
    }

    return totalForce;
  }
}
