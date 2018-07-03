
public class GuruMultithread implements Runnable{

    /**
     * @param args
     */
    public static void main(String[] args) {
             Thread guruthread1 = new Thread();
             guruthread1.start();
             Thread guruthread2 = new Thread();
             guruthread2.start();
             System.out.println("Thread names are following ");
             System.out.println(guruthread1.getName());
             System.out.println(guruthread2.getName());
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}