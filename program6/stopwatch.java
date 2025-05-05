
public class Stopwatch {
    private long startTime;
    private long stopTime;

    public Stopwatch() {
        startTime = 0;
        stopTime = 0;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        stopTime = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return stopTime - startTime;
    }
}