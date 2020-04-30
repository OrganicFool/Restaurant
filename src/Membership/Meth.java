package Membership;

    import java.io.*;
    import java.util.*;
    import java.util.Random;

public class Meth {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Userinfo> map = new HashMap();
        Userinfo us1 = new Userinfo("dnjs","abc", "def", "709688109@qq.com", 100,  1,10);
        Userinfo user = null;

        //弄一个集合，用于将数据整理到一起
        public HashMap<String, Userinfo> getMap(Userinfo userinfo) {
                 map.put(user.getNickname(), user);
                 return map;
             }
        public HashMap<String, Userinfo> getMap() {
                 map.put(us1.getNickname(), us1);
                 return map;
             }

    //random membershipnumber(no duplication/无重复随机数)
    public   int membershipnumber() {
                int[] intRandom = new int[999999];
                List mylist = new ArrayList(); //make a set to save the random membershipnumber，and judge it is duplicated or not.
                Random random = new Random();
                int membershipnumber = random.nextInt(99999999)%(90000000)+10000000;
                while(mylist.size() < 90000000) {
                    if(!mylist.contains(membershipnumber)) {
                        mylist.add(membershipnumber); //add data into set
                    }
                }
                for(int i = 0;i <mylist.size();i++) {
                    intRandom[i] = (Integer)(mylist.get(i));
                }
                return membershipnumber;
           }

    public  void saveFile() {
        File file = new File("D:\\userinfo.txt");
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\userinfo.txt")))){
            oos.writeObject(map);
            System.out.println("保存成功");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void addUserinfo(Userinfo userinfo){
        map.put(userinfo.getNickname(), userinfo);
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
        if(map != null && map.size()>0){
            //.get(Nickname)实际上就是获取Nickname.获取的是map列表中的信息.
            Userinfo userinfo = (Userinfo)this.map.get(Nickname);
            return userinfo;
        }
        return null;
    }
    /**
     * 根据输入的surname和membershipnumber,查找信息
     * @return
     */
    public ArrayList searchIDandSurname(String surname,String membershipnumber){
        ArrayList result = new ArrayList();
        for(Object key:this.map.keySet()){
            Userinfo obj =(Userinfo)this.map.get(key);
            System.out.println(obj);
            if(obj.getSurname().contains(membershipnumber)){
                result.add(obj);
            }
        }
        return result;
    }
    /**
     * 修改一个
     */
    public boolean updateUserinfo(Userinfo userinfo){
        if(map != null && map.size()>0){
            /**
             * 判断有没有这个user.找到后再变更
             */
            Userinfo userinfo1 = this.getByNickname(userinfo.getNickname());
            if(userinfo1 == null){
                return false;
            }
            this.map.put(userinfo.getNickname(), userinfo);
            return true; //对于删除的结果给一个返回值
        }
        return false;  //没找到对象给返回值
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

