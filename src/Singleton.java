public class Singleton {
    private static volatile Singleton instance; //we use the volatile because a thread may call the instance while it is still constructing, this will result in a crash if not take in account
    private final String dbUser;
    private final String dbPass;

    private Singleton(String dbUser, String dbPass){ //we declare the constructor private so it can't be accessed from outside
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public static Singleton getInstance(String dbUser, String dbPass) {
        if(instance == null) { //this is the double-checked locking idiom, we would use this to reduce the wait time of the threads
            synchronized (Singleton.class){ //this prevents multiple threads to access at the same time
                if (instance == null) {
                    instance = new Singleton(dbUser, dbPass);
                }
            }
        }
        return instance;
    }

    public String getDbUser(){
        return this.dbUser;
    }
    public String getDbPass(){
        return this.dbPass;
    }
}
