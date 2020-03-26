package Membership;

    import java.util.*;

public class Meth {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Userinfo> map = new HashMap();
        Userinfo us1 = new Userinfo("abc", "def", "709688109@qq.com", 100, 195465, 10);
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

}
