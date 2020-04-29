package Dishes;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Repository {
     public void updateByUser(Dish dish){
         synchronized (Repository.class){

         }

    }

    public void updateByManagement(Dish dish){
        synchronized (Repository.class){
            Gson gson = new Gson();
            String response = gson.toJson(dish);

            String dishName = dish.getName() + ".json";
            try {
                File file = new File(this.getClass().getResource("/").getPath() + "/Dishes/Data/" + dishName);

                if (file.exists()) { // 如果已存在,删除旧文件
                    file.delete();
                }
                file.createNewFile();

                InputStream is = new FileInputStream(file);
                Writer write = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                write.write(response);
                write.flush();
                write.close();

            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public void removeByManagement(String dishName){
         synchronized (Repository.class){
             File file = new File(this.getClass().getResource("/").getPath() + "/Dishes/Data/" + dishName + ".json");
             file.delete();
         }
    }

    public static void main(String[] args) {
        //concurrency test
        concurrency();

        //function test
        function();

    }
    static void concurrency(){

    }

    static void function(){
         //创建具体的dish对象
         Dish dish = new Dish();
         dish.setName("LaMian");
         dish.setImageUrl("123");
         dish.setIntro("HaoChi");
         dish.setNum(1);

         //创建一个具体的attribute

         Attribute a1 = new Attribute();
         a1.setName("tang");
         a1.addOption(new Option("diyu",0,100,29.9));
         a1.addOption(new Option("tungu",0,100,29.9));
         a1.addOption(new Option("qingtang",0,100,29.9));

         Attribute a2 = new Attribute();
         a2.setName("mian");
         a2.addOption(new Option("ruan",0,100,39.9));
         a2.addOption(new Option("zhong",0,100,39.9));
         a2.addOption(new Option("ying",0,100,39.9));

         dish.addAttribute(a1);
         dish.addAttribute(a2);

         //创建一个addOn类型的Attribute
         AddOnAttribute a3 = new AddOnAttribute("jiemo",3,1.0);
         AddOnAttribute a4 = new AddOnAttribute("lajiao",3,1.0);

         dish.addAddOnAttribute(a3);
         dish.addAddOnAttribute(a4);

         System.out.println(dish);


         //去除索引为1的attribute（面条种类）
         dish.removeAttribute(1);
        //去除名称为“jiemo”的addOnAttribute（芥末）
         dish.removeAddOnAttribute("jiemo");

         System.out.println("_______________________________________________________________________");
         System.out.println(dish);

         //保存为json（可能会覆盖，慎用）
         new Repository().updateByManagement(dish);

        //移除该商品（慎用）

//        new Repository().removeByManagement("LaMian");


    }
}
