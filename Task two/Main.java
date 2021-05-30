package HW_12;

public class Main {
    public static void main(String[] args) {

        MyThreadPoolExecutor service = new MyThreadPoolExecutor(3);
        service.execute(new MyRunnable());

        service.shutdown();

    }
}