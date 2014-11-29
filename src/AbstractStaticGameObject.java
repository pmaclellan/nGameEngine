/**
 * A subset of {@link GameObject}s that are NOT able to move about the screen.
 * The positions of these objects are fixed and cannot change.  They are also
 * considered to have infinite mass.
 */
public class AbstractStaticGameObject implements GameObject {
  protected final Vector2D position;
  protected final double mass = 0; // represents infinite mass

  AbstractStaticGameObject(Vector2D position) {
    this.position = position;
  }

  AbstractStaticGameObject(double x, double y) {
    position = new Vector2D(x, y);
  }

  @Override
  public void render() {}
}
