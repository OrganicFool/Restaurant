package GUI;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * <p>Title: Menu.java <br>
 * Description: This class generates a menu frame,<br>
 * and it contains all the logic of the order a dish.<br></p>
 *
 * @author Li Jiaxi
 * @version 1.0
 */
public class Menu {

    JFrame SecondFrame = new JFrame();


    /**
     * <p> Description: This method is constructor, it will generate the question frame.</p>

     */
    public Menu() {

        //set the size about second frame 菜单界面总体框架
        SecondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SecondFrame.setVisible(true);
        SecondFrame.setTitle("Multiple Choice Question");
        SecondFrame.setSize(500, 750);

        //图层：该panel用于呈现总菜单样式
        JPanel MenuPane = new JPanel();
        MenuPane.setLayout(null);
        MenuPane.setBounds(0, 0, 500, 750);
        MenuPane.setOpaque(false);
        MenuPane.setVisible(true); //用于控制图层显示

        //图层：该panel用于添加scrollplane模块
        JPanel scrollPlane = new JPanel();
        scrollPlane.setLayout(null);
        scrollPlane.setBounds(0, 0, 500, 750);
        scrollPlane.setOpaque(false);

        //滚动翻页模块
        JScrollPane sp = new JScrollPane();
        sp.setBounds(49, 140, 400, 510);
        sp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //默认设置为竖直滚动
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);
        scrollPlane.add(sp);
        MenuPane.add(scrollPlane);

        //set the board and style of it
        JPanel BoardPlane = new JPanel();
        BoardPlane.setLayout(null);
        BoardPlane.setBounds(44, 130, 409, 525);
        GradientPaint gradientPaint = new GradientPaint(200f, 15f, Color.PINK, 350, 15f, Color.WHITE, false);//建立渐变颜色
        Border border = BorderFactory.createDashedBorder(gradientPaint, 10f, 8);
        Border border2 = BorderFactory.createTitledBorder(border, "Dashed Border",TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 4, 10), Color.white);
        BoardPlane.setBorder(border2);
        BoardPlane.setOpaque(false);
        MenuPane.add(BoardPlane);

        //设置每个菜品的样式
















        //add the MenuPane to the frame
        SecondFrame.add(MenuPane);

        //set the backround
        ImageIcon Img2 = new ImageIcon("src/GUI/image/menu.jpg");
        JLabel JLBackround2 = new JLabel(Img2);
        JLBackround2.setBounds(0, 0, 500, 750);
        SecondFrame.getLayeredPane().add(JLBackround2, Integer.valueOf(Integer.MIN_VALUE));
        JPanel Top = (JPanel) SecondFrame.getContentPane();
        Top.setOpaque(false);
        SecondFrame.setLayout(null);

    }



}

