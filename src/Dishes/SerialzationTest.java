package Dishes;

import Dishes.Dish;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SerialzationTest {
    public static void main(String[] args) {
        String jsonPath = "E:\\360MoveData\\Users\\22923\\Desktop\\project\\Restaurant\\src\\Dishes\\Data\\HandPulledNoodle.json";
        StringBuffer buffer = new StringBuffer();
        try{

            InputStream is = new FileInputStream(jsonPath);
            String line; // 用来保存每行读取的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            line = reader.readLine(); // 读取第一行
            while (line != null) { // 如果 line 为空说明读完了
                buffer.append(line); // 将读到的内容添加到 buffer 中
                line = reader.readLine(); // 读取下一行
            }
            reader.close();
            is.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        String json = buffer.substring(0);
        System.out.println(json);

        Gson gson = new Gson();
        Dish dish = gson.fromJson(json,Dish.class);

        Dish dish2 = new Dish("HandPulledNoodle");
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
}
