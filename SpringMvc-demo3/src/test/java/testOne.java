import org.junit.Test;

public class testOne {
    @Test
    public void test(){
        int n=10;
        int m=n;
        System.out.println(n);
        System.out.println(m);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("内部线程"+Thread.currentThread().getName());
            }
        });
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());

    }
}
