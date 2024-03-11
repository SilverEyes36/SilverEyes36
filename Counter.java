import java.util.Random;
public class Counter implements Runnable{
    private String name;
    Counter(String name){
        this.name = name;
    }
    public void run() {
        try{
            for(int i = 5000; i >= 0; i--){
                Random rand = new Random();
                int r = rand.nextInt(5000);
                Thread.sleep(r);
            }
            System.out.println(name+" is done");
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

}
