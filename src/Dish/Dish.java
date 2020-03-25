package Dish;

import java.util.ArrayList;

public class Dish {
    private String Name;
    private ArrayList<Attribute> Attrs;

    public static ArrayList<Dish> getDishList(){
        return null;
    }

    Dish(String dishName){
        //根据菜品名创建名称

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Attribute> getAttrs() {
        return Attrs;
    }

    public void setAttrs(ArrayList<Attribute> attrs) {
        Attrs = attrs;
    }

    public int getAttrNum(){
        return Attrs.size();
    }

    public boolean isOrder(){
        //检查是否所有的Attribute都被选过一遍
        return true;
    }

    public float calculatePrice(){
        //计算这份菜的价格
        return 0;
    }



}
