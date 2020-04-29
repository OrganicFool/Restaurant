package Dishes;

public class Option {
    private String name;
    private int sign;
    private int repository;
    private double price;

    private boolean isSelect;

    public Option(String name, int sign, int repository, double price) {
        this.name = name;
        this.sign = sign;
        this.repository = repository;
        this.price = price;
    }

    Option(){

    }

    public Option(String name) {
        this.name = name;
    }

    public boolean isSelected() { return isSelect;}

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void select(){
        //原则上讲不宜使用这个方法，因为会造成多选的问题，如果使用，一定要在对应的attribute上进行验证
        if(isSelect) {
            throw new RuntimeException("This option has been already selected!!!");
        }
        isSelect = true;
    }

    public void removeSelect(){
        //原则上讲不宜使用这个方法，因为会造成多选的问题，如果使用，一定要在对应的attribute上进行验证
        if(!isSelect) {
            throw new RuntimeException("This option hasn't been selected yet!!!");
        }
        isSelect = false;

    }

    public void abandon(){
        isSelect = false;
    }
}
