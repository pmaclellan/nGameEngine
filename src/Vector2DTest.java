import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {
  Vector2D v0 = new Vector2D();
  Vector2D v1 = new Vector2D(10, 10);
  Vector2D v2 = new Vector2D(1.0235, 0.75);
  Vector2D v3 = new Vector2D(-10, -10);
  Vector2D v4 = new Vector2D(0, 6.5);
  Vector2D v5 = new Vector2D(3, 4);

  @Test
  public void testDefaultConstructor() {
    assertNearby(0, v0.getFirst());
    assertNearby(0, v0.getSecond());
    assertNearby(0, v0.getMagnitude());
  }

  @Test
  public void testAdd_cancel() {
    Vector2D newV = v1.add(v3);
    assertNearby(0, newV.getFirst());
    assertNearby(0, newV.getSecond());
    assertNearby(0, newV.getMagnitude());
  }

  @Test
  public void testAdd_normal() {
    Vector2D newV = v1.add(v2);
    assertNearby(11.0235, newV.getFirst());
    assertNearby(10.75, newV.getSecond());
    assertNearby(Math.sqrt((11.0235*11.0235)+(10.75*10.75)), newV.getMagnitude());
  }

  @Test
  public void testSubtract() throws Exception {

  }

  @Test
  public void testScale() {
    Vector2D newV = v1.scale(5.3);
    assertNearby(53, newV.getFirst());
    assertNearby(53, newV.getSecond());
    assertNearby(v1.getMagnitude()*5.3, newV.getMagnitude());
  }

  @Test
  public void testGetMagnitude() {
    assertNearby(5, v5.getMagnitude());
  }


  private void assertNearby(double x, double y) {
    assertEquals(x, y, 0.0000001);
  }
}