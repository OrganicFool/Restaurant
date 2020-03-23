package Dish;

import java.util.ArrayList;
import java.util.HashMap;

public class Attribute {
    private String name;
    private int sign;
    private ArrayList<Option> Opts;

    Attribute(HashMap<String,String> map){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public ArrayList<Option> getOpts() {
        return Opts;
    }

    public void setOpts(ArrayList<Option> opts) {
        Opts = opts;
    }

    public boolean select(int num){
        //在Attribute这一级选择选项（不建议使用）
        //返回值为索引是否越界
        return true;
    }



}
