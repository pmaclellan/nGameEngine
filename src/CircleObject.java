import processing.core.*;

public final class CircleObject extends AbstractDynamicGameObject {
  private double radius;
  private PApplet parent;

  public static class Builder {

    // Optional parameters - initialized to default values
    private Vector2D position;
    private Vector2D acceleration;
    private double mass;
    private double radius;
    private PApplet parent;

    public Builder(PApplet parent) {
      position = new Vector2D(200, 200);
      acceleration = new Vector2D();
      mass = 1;
      radius = 10;
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
    parent = builder.parent;
  }

  @Override
  public void render() {
    parent.fill(200);
    parent.ellipse((float) position.getFirst(), (float) position.getSecond(),
            (float) radius, (float) radius);
  }
}
