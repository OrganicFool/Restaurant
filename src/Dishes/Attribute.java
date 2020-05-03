package Dishes;

import java.util.ArrayList;
import java.util.HashMap;

public class Attribute {
    private String name;
    private int sign;
    private ArrayList<Option> opts = new ArrayList<Option>();

    Attribute(){

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
        return opts;
    }

    public void setOpts(ArrayList<Option> opts) {
        this.opts = opts;
    }

    public void select(int num){
        if(isSelected()||isMultiSelected()) throw new RuntimeException("This Attribute "+name+" has already been selected!!!");
        opts.get(num).select();
    }
    public boolean isSelected(){
        //检查这一个attribute是否被选过
        boolean ans = false;
        for(Option o:opts){
            if (o.isSelected()) {
                ans = true;
                break;
            }
        }

        return ans;
    }

    public boolean isMultiSelected(){
        //检查这一个attribute是否发生过多选的情况
        int count = 0;
        for (Option o:getOpts()){
            if (o.isSelected()) count++;
        }
        return count>1;
    }

    public void removeSelection(int index){
        //移除某个已选的选项
        if (!isSelected()) throw new RuntimeException("This Attribute "+name+" hasn't been selected yet!!!");
        opts.get(index).removeSelect();
    }

    public void select(String name){
        //根据名称选择选项
        if(isSelected()||isMultiSelected()) throw new RuntimeException("This Attribute "+this.name+" has already been selected!!!");
        boolean flag = false;
        for (Option o:opts){
            if(o.getName().equals(name)){
                flag = true;
                o.select();
            }
        }
        if(!flag) throw new RuntimeException("There is no such option "+name);
    }


    public void removeSelect(String name){
        //根据名称移除选项
        if(!isSelected()) throw new RuntimeException("This Attribute "+this.name+" hasn't been selected yet!!!");
        boolean flag = false;
        for (Option o:opts){
            if(o.getName().equals(name)){
                flag = true;
                o.removeSelect();
            }
        }
        if(!flag) throw new RuntimeException("There is no such option "+name);
    }

    public void addOption(Option option){
        //添加选项
        opts.add(option);
    }

    public void reindexOption(int[] indexs){
        //改变选项顺序(强迫症首选）
    }

    public void removeOption(String name){
        //根据名称移除选项
        int index = 0;
        for(Option a:opts){
            if (a.getName() == name) break;
            index++;
        }
        if (index == opts.size()) throw new RuntimeException("Their is no such Option!");
        else opts.remove(index);
    }

    public void removeOption(int index){
        //根据索引移除选项
        opts.remove(index);
    }

    public void clean(){
        //清空选项
        for(Option o:opts){
            o.abandon();
        }
    }

    public void safeSelect(int num){
        clean();
        select(num);
    }

    public void safeSelect(String name){
        clean();
        select(name);
    }




}
