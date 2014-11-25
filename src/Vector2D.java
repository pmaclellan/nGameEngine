/**
 * A class to store two-dimensional vectors.  Provides methods for many common
 * vector operations.
 *
 * <p>These vectors can be used to represent positional points in space as well
 * as more traditional vectors such as velocities, forces, and accelerations.
 */
public final class Vector2D {
  private double first;
  private double second;

  /**
   * Constructs a zero vector
   */
  public Vector2D() {
    first = 0;
    second = 0;
  }

  public int firstAsInt(int max) {
    double normalizedFirst = this.normalize().getFirst();
    return (int) Math.round(normalizedFirst * max);
  }

  public int secondAsInt(int max) {
    double normalizedSecond = this.normalize().getSecond();
    return (int) Math.round(normalizedSecond * max);
  }

  /**
   * Constructs a vector with the given parameters.
   *
   * @param first the first element
   * @param second the second element
   */
  public Vector2D(double first, double second) {
    this.first = first;
    this.second = second;
  }

  public double getFirst() {
    return first;
  }

  public double getSecond() {
    return second;
  }

  public double getMagnitude() {
    return Math.sqrt(first*first + second*second);
  }

  /**
   * Adds the given Vector2D to {@code this}.
   *
   * @param v the Vector2D to be added
   * @return the new Vector2D
   */
  public Vector2D add(Vector2D v) {
    first += v.getFirst();
    second += v.getSecond();
    return this;
  }

  /**
   * Subtracts the given Vector2D from {@code this}.
   *
   * @param v the Vector2D to be subtracted
   * @return the new Vector2D
   */
  public Vector2D subtract(Vector2D v) {
    first -= v.getFirst();
    second -= v.getSecond();
    return this;
  }

  /**
   * Scales {@code this} by the given scalar factor.
   *
   * @param factor the factor to scale by
   * @return the scaled Vector2D
   */
  public Vector2D scale(double factor) {
    first *= factor;
    second *= factor;
    return this;
  }

  /**
   * Sets the magnitude of {@code this}.
   *
   * @param newMag the magnitude to be scaled to
   * @return the scale Vector2D
   */
  public Vector2D setMagnitude(double newMag) {
    if (getMagnitude() != 0) {
      scale(newMag / getMagnitude());
    }
    return this;
  }

  /**
   * Normalizes {@code this} to a unit vector with magnitude 1.0
   *
   * @return the unit vector corresponding to {@code this}
   */
  public Vector2D normalize() {
    setMagnitude(1.0);
    return this;
  }
}
