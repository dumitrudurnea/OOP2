package first;

public class CounterOutTask implements Task {
    private static int counter = 0;
    
    /*public CounterOutTask() {
        counter++;
    }*/

    @Override
    public void execute() {
        counter++;
        System.out.println("Counter value: " + counter);
    }
}