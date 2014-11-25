import processing.core.*;

public final class CircleObject extends AbstractDynamicGameObject {
  private double radius;

  /**
   * Object's color represented as simple 32-bit {@code int}.
   */
  protected int color = 0xFF0000FF;

  private PApplet parent;

  public static class Builder {

    // Optional parameters - initialized to default values
    private Vector2D position;
    private Vector2D acceleration;
    private double mass;
    private double radius;
    private int color;
    private int strokeColor;
    private PApplet parent;

    public Builder(PApplet parent) {
      position = new Vector2D(200, 200);
      acceleration = new Vector2D();
      mass = 1;
      radius = 10;
      strokeColor = 0;
      this.parent = parent;
    }

    public Builder mass(double mass) {
      this.mass = mass;
      return this;
    }

    public Builder position(Vector2D position) {
      this.position = position;
      return this;
    }

    public Builder acceleration(Vector2D acceleration) {
      this.acceleration = acceleration;
      return this;
    }

    public Builder radius(double radius) {
      this.radius = radius;
      return this;
    }

    public Builder color(int color) {
      this.color = color;
      return this;
    }

    public Builder strokeColor(int strokeColor) {
      this.strokeColor = strokeColor;
      return this;
    }

    public CircleObject build() {
      return new CircleObject(this);
    }
  }

  private CircleObject(Builder builder) {
    position = builder.position;
    oldPosition = position;
    acceleration = builder.acceleration;
    accumulator = new ForceAccumulator();
    mass = builder.mass;
    radius = builder.radius;
    color = builder.color;
    parent = builder.parent;
  }

  @Override
  public void render() {
    parent.fill(color);
    parent.stroke(color);
    /*parent.ellipse((float) position.firstAsInt(parent.width),
                   (float) position.secondAsInt(parent.height),
                   (float) radius,
                   (float) radius);

    System.out.println("secAsInt: " + position.secondAsInt(parent.width));*/

    parent.ellipse((float) position.getFirst(),
            (float) position.getSecond(),
            (float) radius,
            (float) radius);
  }
}
