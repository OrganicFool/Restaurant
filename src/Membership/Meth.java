package Membership;

    import java.util.*;

public class Meth {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Userinfo> map = new HashMap();
        Userinfo us1 = new Userinfo("abc", "def", "709688109@qq.com", 100, 195465, 159,10);
        Userinfo user = null;

        //弄一个集合，用于将数据整理到一起
        public HashMap<String, Userinfo> getMap(Userinfo userinfo) {
                 map.put(user.getFirstname(), user);
                 return map;
             }
        public HashMap<String, Userinfo> getMap() {
                 map.put(us1.getFirstname(), us1);
                 return map;
             }
    public Userinfo login(String membershipNumber) {

                 boolean islogin = true;
                 exit:
                 do {
                         if (getMap().containsKey(membershipNumber)) {
                                        System.out.println("Please input password");
                                        String pwd = "";
                                        pwd = scanner.next();
                                        if (pwd.equals(getMap().get(membershipNumber).getPassword())) {
                                                 user = getMap().get(membershipNumber);
                                                 System.out.println("");
                                                 islogin = false;
                                            } else {
                                                System.out.println("password error");
                                            }
                                   }
                                else { System.out.println("account not found");
                                break exit;
                            }
                    } while (islogin);
                 return user;
            }
    public void inquire(String membershipNumber) {
                System.out.println("VirtualStamps：" + map.get(membershipNumber).getVirtualStamps());
            }


}
