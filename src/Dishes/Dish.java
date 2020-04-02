package Dishes;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dish {
    private int num;//菜品序号
    private String name;
    private ArrayList<Attribute> attrs;
    private String imageUrl;
    private String intro;



    public static ArrayList<Dish> getDishList(){
        //获取所有现有菜品列表
        List<String> childPathes = new ArrayList<String>() ;
        File file = new File(Dish.class.getResource("/").getPath()+"\\Dishes\\Data");		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory())		//若非目录(即文件)，则打印
                childPathes.add(f.toString());
        }

        Gson gson = new Gson();
        ArrayList<Dish> dishList = new ArrayList<Dish>();
        for(String jsonPath:childPathes){
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
            Dish dish = gson.fromJson(json,Dish.class);
            dishList.add(dish);
        }

        return dishList;

    }

    Dish(String dishName){
        //根据菜品名创建名称
            dishName = dishName+".json";
            boolean flag = false;
            String ans = "";
            File file = new File(this.getClass().getResource("/").getPath()+"\\Dishes\\Data");		//获取其file对象


            File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
            for(File f:fs){					//遍历File[]数组
                if(!f.isDirectory()) {    //若非目录(即文件)，则打印
                    if (f.getName().equals(dishName)) {
                        ans = dishName;
                        flag = true;
                    }
                }
            }

            if (!flag) throw new RuntimeException("sorry, there is no such dish in our database");
            else {

                StringBuffer buffer = new StringBuffer();
                try {

                    InputStream is = new FileInputStream(this.getClass().getResource("/").getPath()+"\\Dishes\\Data\\"+dishName);
                    String line; // 用来保存每行读取的内容
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    line = reader.readLine(); // 读取第一行
                    while (line != null) { // 如果 line 为空说明读完了
                        buffer.append(line); // 将读到的内容添加到 buffer 中
                        line = reader.readLine(); // 读取下一行
                    }
                    reader.close();
                    is.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                String json = buffer.substring(0);
                Gson gson = new Gson();
                Dish dish = gson.fromJson(json, Dish.class);

                this.attrs = dish.attrs;
                this.imageUrl = dish.imageUrl;
                this.intro = dish.intro;
                this.name = dish.name;
                this.num = dish.num;
            }

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public ArrayList<Attribute> getAttrs() {
        return attrs;
    }

    public ArrayList<Option> getOptions(){
        //获取所有的已选选项
        ArrayList<Option> opts =  new ArrayList<Option>();
        for(Attribute a:getAttrs()){
            for(Option o:a.getOpts()){
                if(o.isSelected()) opts.add(o);
            }
        }
        return opts;
    }

    public boolean isOrder(){
        //检查是否所有的Attribute都被选过一遍
        boolean ans = true;
        for (Attribute a:getAttrs()){
            if (!a.isSelected()) ans = false;
        }

        return ans;
    }

    public double calculatePrice(){
        //计算这份菜的价格
        ArrayList<Option> opts = getOptions();
        double price = .0;
        for (Option o:opts){
            price+=o.getPrice();
        }
        return price;
    }

    public ArrayList<String> getAttrNames(){
        ArrayList<String> ans = new ArrayList<String>();
        for (Attribute a:attrs){
                ans.add(a.getName());
        }
        return ans;
    }



}
