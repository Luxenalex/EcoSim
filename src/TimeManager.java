/**
 * Created by lux on 8/5/18.
 */
public class TimeManager {

    final double BILLION = 1000000000.0;

    private double currentTime = 0;
    private double lastTime = System.nanoTime() / BILLION;
    private double passedTime = 0;
    private double unprocessedTime = 0;

    public TimeManager(){}

    public void updateTime(){
        currentTime = System.nanoTime() / BILLION;
        passedTime = currentTime - lastTime;
        lastTime = currentTime;
        unprocessedTime += passedTime;
    }

    public boolean shouldUpdate(final double timeStep) {
        return unprocessedTime >= timeStep;
    }

    public void decrementUnprocessedTime(final double value){
        unprocessedTime -= value;
    }

    public double getPassedTime() {
        return passedTime;
    }
}
