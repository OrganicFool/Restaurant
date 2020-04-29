package Dishes;

public class AddOnAttribute {
    private String name;
    private boolean left = true;
    private int order;
    private int maxOrder;
    private double price;

    AddOnAttribute(String name, int maxOrder, double price) {
        this.name = name;
        this.maxOrder = maxOrder;
        this.price = price;
    }

    AddOnAttribute(){}

    public void setName(String name) {
        this.name = name;
    }

    //共用区
    public String getName() {
        return name;
    }

    public boolean isLeft(){
        //检查是否还有剩余
        return left;
    }

    public double getPrice() {
        return price;
    }

    public int getOrder() {
        return order;
    }

    public int getMaxOrder() {
        return maxOrder;
    }


    //用户点单区
    public void addOrder(){
        //追加一个
        if(!left) throw new RuntimeException("Their is no "+name+" left!");
        else order++;
    }

    public void minusOrder(){
        //去掉一个
        if(order == 0) throw new RuntimeException("No "+name+" has been ordered!");
        else order--;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    //管理员区
    public void setLeft() {
        this.left = true;
    }

    public void removeLeft(){
        this.left = false;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setMaxOrder(int maxOrder) {
        this.maxOrder = maxOrder;
    }


}
