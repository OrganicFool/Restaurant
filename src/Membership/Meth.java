package Membership;
import java.io.IOException;

public class Meth {

    Userinfo us1 = new Userinfo(159789,"abc", "def", "709688109@qq.com", 100,  10);

    public  void addUserinfo(Userinfo userinfo){
        StreamController s = new StreamController();
        s.writeLine(userinfo);
    }

/*    public void addUser(int membershipNumber,String firstname, String surname, String email, int mobileNumber,int virtualStamps){//ǰ̨�����ݽ�����
        Userinfo userinfo = new Userinfo();
        this.addUserinfo(userinfo);
    }
    没看懂这个方法存在的意义
*/

    public Userinfo getBymembershipnumber(int membershipnumber){
        StreamController s=new StreamController();
        Userinfo a=s.SearchBymembershipnumber(membershipnumber);
        return a;
    }

    public void updateUser(int membershipNumber,String firstname, String surname, String email, int mobileNumber,int virtualStamps) throws IOException {
        StreamController s = new StreamController();
        s.removeUserInfo(membershipNumber);
        Userinfo userinfo = new Userinfo(membershipNumber, firstname, surname, email, mobileNumber, virtualStamps);
        this.addUserinfo(userinfo);
    }

    public void usestamp(int membershipnumber){
        StreamController s=new StreamController();
        s.useStamp(membershipnumber);
    }
}
