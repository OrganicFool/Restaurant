package GUI;

public class Main {

    public static void main(String[] args) {
        Welcome welcome = new Welcome();

        //use thread to control the welcome page
        Thread thread1 = new Thread(welcome);
        thread1.start();
    }
}
