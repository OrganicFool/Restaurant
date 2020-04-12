package Membership;

    import java.util.*;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
    import java.util.Random;

public class Meth {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Userinfo> map = new HashMap();
        Userinfo us1 = new Userinfo("dnjs","abc", "def", "709688109@qq.com", 100, 195465, "l1",10);
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
      //用于判断是否包含特殊符号的规则
      private static final String REGEX1 = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
      //用于判断是否数字的规则
              private static final String REGEX2 = "^-?\\d+(\\.\\d+)?$";
       //开户功能
      public void openUser() {
              //用户名循环跳转条件
                boolean isNickname = true;
                String nickname = "";
              do {
                  //用户名不能以数字开头，不能有特殊符号，用户名长度必须在3到6位之间
                    System.out.println("请输入你的姓名,用户名不能以数字开头，\n不能有特殊符号，用户名长度必须在3到6位之间");

                    nickname = scanner.next();
                    if (nickname.length() < 3 || nickname.length() > 6) {
                        System.out.println("用户名的长度必须在3到6位之间（含）\n");
                    } else if (isFirstNum(nickname)) {
                        System.out.println("用户名不能以数字开头\n");
                    } else if (hasSpecificSymbol(nickname)) {
                        System.out.println("用户名不能包含特殊符号\n");
                    } else {
                        isNickname = false;
                    }

        } while (isNickname);
                 Userinfo user = new Userinfo();
                 user.setNickname(nickname);
          System.out.println("Please input your fistname");
          user.setFirstname(scanner.next());
          System.out.println("Please input your surname");
          user.setSurname(scanner.next());
          System.out.println("Please input your email");
          user.setEmail(scanner.next());

         System.out.println("请输入电话号码");
                 user.setMobileNumber(scanner.nextInt());
                 boolean isPassword = true;
                 String password = "";
                 do {
            System.out.println("请输入密码");
                        password = scanner.next();

                         if (password.length() < 6 || password.length() > 10) {
                                 System.out.println("密码长度必须在6-10位，请重新设置\n");
                             }
                         System.out.println("请再次输入密码");
                        String passWord2 = scanner.next();
                        if (!password.equals(passWord2)) {
                                 System.out.println("两次输入的密码不一致，请重新输入");
                            } else {
                                 isPassword = false;
                             }
                         //System.out.println("密码强度分析：   " + strongPW(passWord));
                     } while (isPassword);
                 user.setPassword(password);
                 System.out.println("密码设置成功");
        //验证码
                //yanZhen();没做
                 // 密保，
                 //System.out.println("请随意输入一组字符，作为密保");
                 //String encrypted = scanner.next();
                 //user.setEncrypted(encrypted);
                 //初始
                 user.setVirtualStamps(0);
                 //编号
                user.setMembershipNumber(membershipnumber());
                //注册日期
                //user.setRegisterNum(registerNum());
                 System.out.println("Initial virtualstamps:0");
                 //System.out.println("Your membershipnumber： " + membershipnumber());
                 //System.out.println("日期是：" + registerNum());
                 //System.out.println(user.toString());  //测试会员信息是否完整

                 getMap(user);
            }

             //一个判断字符第一位是否是数字的方法
             public static boolean isFirstNum(String string) {
                 Pattern pattern = Pattern.compile(REGEX2);
                if (pattern.matcher(String.valueOf(string.charAt(0))).matches()) {
                         return true;
                   } else {
            return false;
                    }
             }

             //使用正则表达式，判断字符串是否包含特殊符号
             public static boolean hasSpecificSymbol(String string) {
                Pattern k = Pattern.compile(REGEX1);
                 Matcher m = k.matcher(string);
                 if (m.find()) {
                         return true;
                     } else {
                         return false;
                     }
            }
            //随机一个编号的方法
            public   int membershipnumber() {
                Random random = new Random();
                int membershipnumber =random.nextInt(999999 - 100000 + 1) + 100000;
                return membershipnumber;
           }

}
