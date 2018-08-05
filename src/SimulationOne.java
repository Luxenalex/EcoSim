import Rendering.Renderer;
import Utility.Position;
import gfx.Image;

/**
 * Created by lux on 8/5/18.
 */
public class SimulationOne extends AbstractSimulation {

    final int TILE_SIZE = 32;

    Image grass;
    Image rabbit;
    Image fox;

    public SimulationOne(){
        grass = new Image("/grass.png");
        rabbit = new Image("/rabbit.png");
        fox = new Image("/fox.png");
    }

    @Override
    public void update(SimulationRunner simulationRunner, float deltaTime){

    }

    @Override
    public void render(SimulationRunner simulationRunner, Renderer renderer){

        renderer.addImageToDraw(grass, new Position(0, 0));
        renderer.addImageToDraw(rabbit, new Position(15, 15));
        renderer.addImageToDraw(fox, new Position(39, 15));
    }

    public static void main(String[] args){
        SimulationRunner simulationRunner = new SimulationRunner(new SimulationOne());
        simulationRunner.start("Test run");
    }

}
