package Order;

import Dishes.Option;

import java.util.ArrayList;

public class Pay {
    private ArrayList<String> pay_attrs;
    private ArrayList<Option> pay_opts;
    private double pay_price;
    private String payment;//支付方式
    private int virtual_stamp; //券的数量

    public ArrayList<String> getPay_attrs() {
        return pay_attrs;
    }
    public void setPay_attrs(ArrayList<String> pay_attrs) {
        this.pay_attrs = pay_attrs;
    }

    public ArrayList<Option> getPay_opts() {
        return pay_opts;
    }
    public void setPay_opts(ArrayList<Option> pay_opts) {
        this.pay_opts = pay_opts;
    }

    public double getPay_price() {
        return pay_price;
    }
    public void setPay_price(double pay_price) {
        this.pay_price = pay_price;
    }

    public String getPayment(){ return payment; }
    public void setPayment(){ this.payment = payment; }

    public int getVirtual_stamp(){ return virtual_stamp; }
    public void setVirtual_stamp(){ this.virtual_stamp = virtual_stamp; }




}
