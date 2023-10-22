public class MySecondRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("-----------------------");
        Singleton DBConnection2 = Singleton.getInstance("admin", "1234");
        System.out.println(DBConnection2.getDbUser());
        System.out.println(DBConnection2.getDbPass());
        Thread.currentThread().setName("Thread# 2");
        System.out.println(Thread.currentThread().getName());
    }
}
