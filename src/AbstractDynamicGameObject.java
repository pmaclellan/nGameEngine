/**
 * A subset of {@link GameObject}s that are able to move about the screen.  The
 * positions of these objects are updated after every frame using the
 * {@code update} method.  Once updated, they are rendered to the screen using
 * the {@code render} method.
 */
import processing.core.*;

public abstract class AbstractDynamicGameObject implements GameObject {
  /**
   * The object's current position (x, y).
   */
  protected Vector2D position;
  /**
   * The object's previous position (x, y).
   */
  protected Vector2D oldPosition;
  /**
   * The object's current acceleration (x, y).
   */
  protected Vector2D acceleration;
  /**
   * The object's mass.
   */
  protected double mass;
  /**
   * A construct to accumulate forces currently acting upon an object as a part
   * of determining the next position of the object.
   */
  protected ForceAccumulator accumulator;

  /**
   * Updates the position of {@code this} based on how much time has passed
   * during the frame cycle.
   *
   * @param timeStep the time passed during the frame transition
   */
  @Override
  public void update(double timeStep) {
    acceleration = accumulator.accumulate().scale(1 / mass);

    // Verlet positional integration
    position = position.add(position.subtract(oldPosition))
                .add(acceleration.scale(timeStep * timeStep));
  }
}