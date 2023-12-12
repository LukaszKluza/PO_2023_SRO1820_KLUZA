package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {

    private final List<Simulation> simulations;
    private final List<Thread> simulationsThread;
    private final ExecutorService threadPool;

    public SimulationEngine(List<Simulation> simulations) {
        this.simulations = simulations;
        this.simulationsThread = new ArrayList<>();
        this.threadPool = Executors.newFixedThreadPool(4);
    }

    public void runSync() {
        for (Simulation simulation : simulations) {
            simulation.run();
        }
    }

    public void runAsync() {
        for (Simulation simulation : simulations) {
            Thread simulationThread = new Thread(simulation);
            simulationsThread.add(simulationThread);
            simulationThread.start();
        }
        awaitSimulationsEnd();
    }
//Lepsza jest pula wątków poniewasz pozwala kontrolować ilość wątków w puli, co pomaga zoptymalizować wykorzystanie
// zasobów i daje nam to więszką kontrolę nad tym cos się dzeje
    public void runAsyncInThreadPool() {
        for (Simulation simulation : simulations) {
            threadPool.submit(simulation);
        }
        awaitSimulationsEnd();
    }

    private void awaitSimulationsEnd(){
        try {
            for (Thread simulationThread : simulationsThread) {
                simulationThread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        threadPool.shutdown();

        try {
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
