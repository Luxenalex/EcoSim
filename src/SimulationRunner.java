import Rendering.Renderer;
import Rendering.Window;

/**
 * Sets up and runs simulation logic.
 */
public class SimulationRunner implements Runnable{

    final double TIME_STEP = 1.0 / 60.0;
    Thread gameLoop;
    Window window;
    Renderer renderer;
    boolean isRunning;
    AbstractSimulation simulation;

    public SimulationRunner(AbstractSimulation simulation){
        this.simulation = simulation;
    }

    public void start(String name){
        window = new Window();
        renderer = new Renderer(window);

        gameLoop = new Thread(this, name);
        gameLoop.start();
    }

    public void stop(){
        gameLoop.interrupt();
    }

    @Override
    public void run(){

        if(isRunning){
            return;
        }

        isRunning = true;
        window.setVisible(true);

        boolean render;
        TimeManager timeManager = new TimeManager();

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(isRunning){

            render = false;

            timeManager.updateTime();
            frameTime += timeManager.getPassedTime();

            while(timeManager.shouldUpdate(TIME_STEP)){
                timeManager.decrementUnprocessedTime(TIME_STEP);
                render = true;
                simulation.update(this, (float)TIME_STEP);
                simulation.render(this, renderer);

                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }

            if(render){
                renderer.clear();
                simulation.render(this, renderer);
                window.update();
                frames++;
            }
            else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.err.println("Simulation loop sleep error. " + e.getMessage());
                }
            }
        }

    }




}












