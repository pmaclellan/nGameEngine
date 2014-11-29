/**
 * {@code GameObject}s are at the heart of the game engine.  They include all
 * objects in the game world that will be drawn to the screen...
 */
public interface GameObject {

  default void update(double timeStep) {}

  void render();
}
