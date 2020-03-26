package GUI;


import javax.swing.*;

/**
 * <p>Title      : Welcome.java<br>
 * Description: This class is Welcome class, show the welcome page to the user.</p>
 *
 * @author Li Jiaxi
 * @version 1.0
 */
public class Welcome implements Runnable {
    /**
     * <p> Description: This method is constructor, it will generate the difficulty frame.<br>
     * User will choose the difficulty to answer the different questions.</p>
     */
    private JFrame FirstFrame = new JFrame();

    public Welcome() {

        //set the size of frame

        FirstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FirstFrame.setVisible(true);
        FirstFrame.setTitle("Welcome to TOTORO RAMEN");
        FirstFrame.setSize(500, 750);

        //set the backround
        ImageIcon Img = new ImageIcon("src/GUI/image/Background1.jpg");
        JLabel JLBackround = new JLabel(Img);
        JLBackround.setBounds(0, 0, 500, 750);
        FirstFrame.setLayout(null);
        FirstFrame.getLayeredPane().add(JLBackround, Integer.valueOf(Integer.MIN_VALUE));
        JPanel Top = (JPanel) FirstFrame.getContentPane();
        Top.setOpaque(false);

    }
    public void run(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println("Something wrong!");
        }
        new Menu();
        FirstFrame.dispose();

    }

}
