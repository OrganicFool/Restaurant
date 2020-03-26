package Order;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String order_date;
    private ArrayList<Object> order_dish;
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

    public ArrayList<Object> getOrder_dish() {
        return order_dish;
    }
    public void setOrder_dish(ArrayList<Object> order_dish) {
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

    public void storeOrder(boolean isVip){
        if(isVip){
            //把会员订单存进会员json
        }else{
            //把非会员订单存进非会员json
        }
    }

    public void printOrder() {
        //读取json,生成txt
    }
}
