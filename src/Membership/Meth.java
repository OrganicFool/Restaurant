package Membership;

    import java.io.*;
    import java.util.*;
    import java.util.Random;

public class Meth {
        Scanner scanner = new Scanner(System.in);
        Userinfo us1 = new Userinfo("dnjs","abc", "def", "709688109@qq.com", 100,  1,10);
        Userinfo user = null;

        //弄一个集合，用于将数据整理到一起

    //random membershipnumber(no duplication/无重复随机数)
    public   int membershipnumber() {
                //操作StreamController获取已存在的ID

                //创建新的ID
           }


    public void addUserinfo(Userinfo userinfo){
        //直接写入到StreamController里面
    }
    /**
     * 重载
     */
    public void addUser(String nickname,String firstname, String surname, String email, int mobileNumber, int membershipNumber,  int virtualStamps){
        Userinfo userinfo = new Userinfo();   //调用Student类
        this.addUserinfo(userinfo); //直接addStudent这个类中的方法.

    }


    /**
     * 根据姓名获取一个user信息
     * @return
     */
    public Userinfo getByNickname(String Nickname){
        //直接操作controller
    }
    /**
     * 根据输入的surname和membershipnumber,查找信息
     * @return
     */
    public ArrayList searchIDandSurname(String surname,String membershipnumber){
        //直接操作controller
    }
    /**
     * 修改一个
     */
    public boolean updateUserinfo(Userinfo userinfo){
        //先根据ID找到对应的Userinfo的行，并删除行
        //重新加入用户
    }
    /**
     * 修改重载
     */
    public boolean updateUserinfo(String nickname,String firstname, String surname, String email, int mobileNumber, int membershipNumber,  int virtualStamps){
        Userinfo userinfo=this.getByNickname(nickname);
        userinfo.setNickname(nickname);
        userinfo.setFirstname(firstname);
        userinfo.setSurname(surname);
        userinfo.setEmail(email);
        userinfo.setMobileNumber(mobileNumber);
        userinfo.setMembershipNumber(membershipNumber);
        userinfo.setVirtualStamps(virtualStamps);
        return updateUserinfo(userinfo);
    }
}

