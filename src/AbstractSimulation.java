import Rendering.Renderer;


public abstract class AbstractSimulation {
    public abstract void update(SimulationRunner simulationRunner, float deltaTime);
    public abstract void render(SimulationRunner simulationRunner, Renderer renderer);
}
