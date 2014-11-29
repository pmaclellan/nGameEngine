import org.junit.Test;

import static org.junit.Assert.*;

public class ForceAccumulatorTest {
  Vector2D force1 = new Vector2D(10, 0);
  Vector2D force2 = new Vector2D(0, 10);
  Vector2D force3 = new Vector2D(-5.2, 1);
  Vector2D force4 = new Vector2D(75, -0.63);

  @Test
  public void testAddForce() {
    ForceAccumulator fa = new ForceAccumulator();
    assertEquals(0, fa.size());
    fa.addForce(force1);
    fa.addForce(force2);
    assertEquals(2, fa.size());
  }

  @Test
  public void testClearForces(){
    ForceAccumulator fa = new ForceAccumulator();
    fa.addForce(force1);
    fa.addForce(force2);
    assertEquals(2, fa.size());
    fa.clearForces();
    assertEquals(0, fa.size());
  }

  @Test
  public void testAccumulate() {
    ForceAccumulator fa = new ForceAccumulator();
    fa.addForce(force1);
    fa.addForce(force2);
    fa.addForce(force4);
    fa.addForce(force3);

    assertEquals(force1.add(force3.add(force2.add(force4))).getMagnitude(),
                 fa.accumulate().getMagnitude(), 0.000001);
  }
}