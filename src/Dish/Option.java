package Dish;

public class Option {
    private String name;
    private int sign;
    private int repository;
    private float price;
    private boolean isSelected = false;

    Option(){

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

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void select(){
        isSelected = true;
    }

    public void abandon(){
        isSelected = false;
    }
}
