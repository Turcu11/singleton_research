public class MyRunnable implements Runnable{

    @Override
    public void run() {
        Singleton DBConnection = Singleton.getInstance("root", "pass");
        System.out.println(DBConnection.getDbUser());
        System.out.println(DBConnection.getDbPass());
        Thread.currentThread().setName("Thread# 1");
        System.out.println(Thread.currentThread().getName());
    }
}
