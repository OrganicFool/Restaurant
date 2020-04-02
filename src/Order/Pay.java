package Order;

import java.util.ArrayList;

public class Pay {
    private ArrayList<Object> pay_dish;
    private float pay_price;
    private String payment;//支付方式
    private int virtual_stamp; //券的数量

    public ArrayList<Object> getPay_dish() {
        return pay_dish;
    }
    public void setPay_dish(ArrayList<Object> pay_dish) {
        this.pay_dish = pay_dish;
    }

    public float getPay_price() {
        return pay_price;
    }
    public void setPay_price(float pay_price) {
        this.pay_price = pay_price;
    }

    public String getPayment(){ return payment; }
    public void setPayment(){ this.payment = payment; }

    public int getVirtual_stamp(){ return virtual_stamp; }
    public void setVirtual_stamp(){ this.virtual_stamp = virtual_stamp; }




}
