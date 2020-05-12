package Membership;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        Meth meth=new Meth();

        Userinfo user1=new Userinfo(10000000, "qwe","rty", "email1", 12345, 0);
        Userinfo user2=new Userinfo(10000001, "asd","fgh", "email2", 13579, 1);
        Userinfo user3=new Userinfo(10000002, "zxc","vbn", "email3", 23333, 999);

        //meth.addUserinfo(user1);
        //meth.addUserinfo(user2);
        //meth.addUserinfo(user3);


        meth.updateUser(10000002, "gyb","niubi", "email", 18846546, 548);

        StreamController s = new StreamController();
        //s.removeUserInfo(10000000);
        //int a =s.createNum();//随机数没问题
        //System.out.print(a);
        //Userinfo b=meth.getBymembershipnumber(15935745);
        //System.out.print(b);//传出用户的值也没问题。
		/*if(s.check(10000003))
			System.out.println("Bingo");
		else
			System.out.println("gg");
		 */

    }

}
