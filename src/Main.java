public class Main {
    public static void main(String[] args) {

        MyRunnable runnable1 = new MyRunnable();
        Thread thread1 = new Thread(runnable1);

        MySecondRunnable runnable2 = new MySecondRunnable();
        Thread thread2 = new Thread(runnable2);

        thread1.run();//if we reverse the order of the threads we get different results
        thread2.run();

        System.out.println("No matter how many instances we try to create, it will always return the first one");
    }
}