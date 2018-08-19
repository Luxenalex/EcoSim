import Rendering.Renderer;
import Utility.Position;
import gfx.Image;

import java.util.Random;

/**
 * Created by lux on 8/5/18.
 */
public class SimulationOne extends AbstractSimulation {

    final int TILE_SIZE = 32;

    Image grass;
    Image rabbit;
    Image fox;

    Position grassPosition;
    Position rabbitPosition;
    Position foxPosition;


    public SimulationOne(){
        grass = new Image("/grass.png");
        rabbit = new Image("/rabbit.png");
        fox = new Image("/fox.png");

        rabbitPosition = new Position(100, 100);
        foxPosition = new Position(200, 200);
    }

    @Override
    public void update(SimulationRunner simulationRunner, float deltaTime){
    }

    @Override
    public void render(SimulationRunner simulationRunner, Renderer renderer){

        renderTerrain(simulationRunner, renderer);

        Random random = new Random();
        rabbitPosition.setX(rabbitPosition.getX() + (random.nextInt(4 + 1 + 4) - 4) );
        rabbitPosition.setY(rabbitPosition.getY() + (random.nextInt(4 + 1 + 4) - 4) );
        foxPosition.setX(foxPosition.getX() + (random.nextInt(4 + 1 + 4) - 4) );
        foxPosition.setY(foxPosition.getY() + (random.nextInt(4 + 1 + 4) - 4) );

        renderer.addImageToDraw(rabbit, rabbitPosition);
        renderer.addImageToDraw(fox, foxPosition);
    }

    private void renderTerrain(SimulationRunner simulationRunner, Renderer renderer){

        // TODO : Window dimensions hardcoded, fix!
        for (int i = 0; i  * TILE_SIZE < 860 ; i++){
            for (int j = 0; j * TILE_SIZE < 640; j++ ){
                renderer.addImageToDraw(grass, new Position(i * TILE_SIZE, j * TILE_SIZE));
            }
        }
    }

    public static void main(String[] args){
        SimulationRunner simulationRunner = new SimulationRunner(new SimulationOne());
        simulationRunner.start("Test run");
    }

}
