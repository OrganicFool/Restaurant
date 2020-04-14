package Order;

import Dishes.Dish;

public class Test {
    public static void main(String[] args) {

        Order order = new Order();
        order.printOrder();

    }

    public static void pay_example(){
        Pay pay = new Pay();
        Dish dish2 = new Dish("HandPulledNoodle");

        pay.setPay_attrs(dish2.getAttrNames()); //属性名
        pay.setPay_opts(dish2.getOptions()); //选项名
        pay.setPay_price(dish2.calculatePrice());//总价格
        System.out.println(pay.getPay_price());
        System.out.println(pay.getPay_attrs());
        System.out.println(pay.getPay_opts());
    }
}
