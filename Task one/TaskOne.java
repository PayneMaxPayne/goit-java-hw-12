package HW_12;

import java.util.concurrent.*;

public class TaskOne {
    private static final String INPUT = "OOHHHH";
    public static void main(String[] args) {
        int numberOfMolecules = INPUT.length()/3;

        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("\nmolecule's done"));

        for (int i = 0; i < numberOfMolecules; i++) {
            service.execute(new H(barrier));
            service.execute(new H(barrier));
            service.execute(new O2(barrier));
        }
        service.shutdown();

    }

}

class H implements Runnable{
    private final String name = "H";
    private final CyclicBarrier cyclicBarrier;

    public H(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseHydrogen() {
        System.out.print(name);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        releaseHydrogen();
    }
}

class O2 implements Runnable{
    private final String name = "O";
    private final CyclicBarrier cyclicBarrier;

    public O2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseOxygen() {
        System.out.print(name);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        releaseOxygen();
    }
}