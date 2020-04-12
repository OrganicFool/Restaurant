package Dishes;

import Dishes.Dish;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SerialzationTest {
    public static void main(String[] args) {
//        String jsonPath = "E:\\360MoveData\\Users\\22923\\Desktop\\project\\Restaurant\\src\\Dishes\\Data\\Noodle.json";
//        StringBuffer buffer = new StringBuffer();
//        try{
//
//            InputStream is = new FileInputStream(jsonPath);
//            String line; // 用来保存每行读取的内容
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            line = reader.readLine(); // 读取第一行
//            while (line != null) { // 如果 line 为空说明读完了
//                buffer.append(line); // 将读到的内容添加到 buffer 中
//                line = reader.readLine(); // 读取下一行
//            }
//            reader.close();
//            is.close();
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

        example();


        Gson gson = new Gson();


        Dish dish2 = Dish.getDishList().get(0);
        System.out.println(dish2.getIntro());
        System.out.println(dish2.getAttrs().get(0).getOpts().get(0).getName());
        System.out.println(dish2.getAttrs().get(1).getOpts().get(1).getName());

        System.out.println(dish2.getAttrs().get(1).isMultiSelected());
        System.out.println(dish2.getAttrs().get(1).isSelected());


        dish2.getAttrs().get(1).select("Soft");

        System.out.println(dish2.getAttrs().get(1).isMultiSelected());
        System.out.println(dish2.getAttrs().get(1).isSelected());
        System.out.println(dish2.getAttrs().get(1).getOpts().get(1).isSelected());

        dish2.getAttrs().get(1).getOpts().get(2).select();

        System.out.println(dish2.getAttrs().get(1).isMultiSelected());

        dish2.getAttrs().get(1).select("Soft");




    }
    public static void example(){
        //根据名称创建菜品
        Dish dish = new Dish("Noodle");
        ArrayList<Dish> dishList = Dish.getDishList();
        Dish dish2 = dishList.get(0);

        //获取dish下所有菜品（attribute）
        ArrayList<Attribute> attrs = dish2.getAttrs();
        //获取attribute下所有选项（option）
        ArrayList<Option> opts =attrs.get(0).getOpts();
        //根据选项的索引选择
        attrs.get(0).select(1);
        //根据选项的名称选择
        attrs.get(1).select("Medium");
        //根据option对象选择option
        attrs.get(0).getOpts().get(0).select();
        //检测这个attribute是否被选择过了
        attrs.get(0).isSelected();
        //检测这个attribute是否发生了多选的情况
        attrs.get(0).isMultiSelected();
        //检测是否dish中的每个属性都被选过了
        dish.isOrder();

    }
}
