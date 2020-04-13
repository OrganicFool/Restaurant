package Order;

import Dishes.Dish;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String order_date;
    private String order_dish;//菜名
    private float order_price;
    private String order_pay; //支付方式
    private String order_num; //取餐号
    private String vip_num;//会员号
    private boolean isVip;
    private int count = 1; //初始化取餐号

    public String getOrder_date() {
        return order_date;
    }
    public void date() {
        String date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        date = df.format(new Date());// new Date()为获取当前系统时间
        this.order_date = date;
    }

    public String getOrder_dish() {
        return order_dish;
    }
    public void setOrder_dish(String order_dish) {
        this.order_dish = order_dish;
    }

    public float getOrder_price() {
        return order_price;
    }
    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    public String getOrder_pay() {
        return order_pay;
    }
    public void setOrder_pay(String order_pay) {
        this.order_pay = order_pay;
    }

    public String getOrder_num() { return order_num; }
    public void setOrder_num() {
        if(count >= 100){ count = 0;}
        count++;
        Format f1=new DecimalFormat("000");
        this.order_num = f1.format(count);
    }//没有加每天清零 只是1到100循环

    public String getVip_num() { return vip_num; }
    public void setVip_num(String vip_num) { this.vip_num = vip_num; }

    public boolean getIsVip() { return isVip; }
    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public void addDish(Object object){
        //添加菜品
    }
    public void csvheader(){
        if(isVip){
            try{
                CsvWriter csvWriter = new CsvWriter("/orderData/vip.csv",',', Charset.forName("GBK"));
                ArrayList<Object> header = new ArrayList();
                Dish dish = new Dish(order_dish);
                header.add("date");
                header.add("VIP number");
                header.add("dish name");
                for(int i = 0; i < dish.getAttrs().size(); i++){
                    header.add(dish.getAttrs().get(i));
                }
                header.add("price");
                header.add("payment");
                String[] array = (String[])header.toArray(new String[header.size()]);
                csvWriter.writeRecord(array);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try{
                CsvWriter csvWriter = new CsvWriter("/orderData/not_vip.csv",',', Charset.forName("GBK"));
                ArrayList<Object> header = new ArrayList();
                Dish dish = new Dish(order_dish);
                header.add("date");
                header.add("dish name");
                for(int i = 0; i < dish.getAttrs().size(); i++){
                    header.add(dish.getAttrs().get(i));
                }
                header.add("price");
                header.add("payment");
                String[] array = (String[])header.toArray(new String[header.size()]);
                csvWriter.writeRecord(array);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void storeOrder(){
        if(isVip){
            //把会员订单存进会员json
            //订单里有：时间 会员号 菜名 各种属性名以及选项 总价格
            try{
                CsvWriter csvWriter = new CsvWriter("/orderData/vip.csv",',', Charset.forName("GBK"));
                ArrayList<Object> content = new ArrayList();
                Dish dish = new Dish(order_dish);//菜名
                content.add(order_date);//下单时间
                content.add(vip_num);//会员号
                content.add(order_dish);
                for(int i = 0; i < dish.getOptions().size(); i++){ content.add(dish.getOptions().get(i)); }
                content.add(order_price);
                content.add(order_pay);
                String[] array = (String[])content.toArray(new String[content.size()]);
                csvWriter.writeRecord(array);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //里面没有会员号
            try{
                CsvWriter csvWriter = new CsvWriter("/orderData/not_vip.csv",',', Charset.forName("GBK"));
                ArrayList<Object> content = new ArrayList();
                Dish dish = new Dish(order_dish);
                content.add(order_date);
                content.add(order_dish);
                for(int i = 0; i < dish.getOptions().size(); i++){ content.add(dish.getOptions().get(i)); }
                content.add(order_price);
                content.add(order_pay);
                String[] array = (String[])content.toArray(new String[content.size()]);
                csvWriter.writeRecord(array);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printOrder() {
        
    }
}
