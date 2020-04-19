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
          //firstname
          System.out.println("Please input your fistname");
          user.setFirstname(scanner.next());
          //surname
          System.out.println("Please input your surname");
          user.setSurname(scanner.next());
          //check email
                  boolean isEmail=true;
                  String email="";
                  do{
                      System.out.println("Please input your email");
                      email=scanner.next();
                      if(email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
                      {
                          System.out.println("right");
                      }
                      else
                      {
                          System.out.println("Err");
                      }
                  }while(isEmail);
           user.setEmail(email);
           //mobilenumber
          System.out.println("Please input your mobile number");
          user.setMobileNumber(scanner.nextInt());
          //password
                 boolean isPassword = true;
                 String password = "";
                 do {   System.out.println("Please input your password");
                        password = scanner.next();
                        if (password.length() < 6 || password.length() > 10) {
                                 System.out.println("The length of password must between 3-6，please reset\n");
                             }
                         System.out.println("please input password again");
                         String passWord2 = scanner.next();
                        if (!password.equals(passWord2)) {
                                 System.out.println("Two password are different，please reset");
                            } else {
                                    isPassword = false;
                             }
                         System.out.println("Password analyse：   " + strongPW(password));
                     } while (isPassword);
                 user.setPassword(password);
                 System.out.println("set password successfully");

                 //验证码
                 //yanZhen();没做
                 //密保
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
                 System.out.println("Your membershipnumber： " + membershipnumber());
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

    public String strongPW(String string) {
                //将密码拆分成char数组，遍历这个数组，如果有数字则+1分，有英文小写字母+1分，有英文大写字母+1分，有特殊符号+1分
                int total = 0;  //给密码强度量化打分
                int hasNum = 0;   //有数字
                int hasUpLetter = 0;  //有大写英文字母
                int hasLowLetter = 0; //有小写英文字母
                int hasSpecial = 0; //有特殊符号
                 //设置密码强度的变量名
                String strong = "";
                //将传入的密码拆分成char数组
                char[] c = string.toCharArray();
                //遍历这个数组
                for (int i = 0; i < c.length; i++) {
                         //数字0-9
                         if ((int) (c[i]) >= 48 && (int) (c[i]) <= 57) {
                                 hasNum = 1;  //有数字则+1
                                 //小写英文字母
                          } else if ((int) (c[i]) >= 97 && (int) (c[i]) <= 122) {
                               hasLowLetter = 1; //有英文小写字母则+1
                                //大写英文字母
                        } else if ((int) (c[i]) >= 65 && (int) (c[i]) <= 90) {
                            hasUpLetter = 1; //有英文大写字母则+1
                                //键盘里面的所有特殊符号
                             } else {
                                 hasSpecial = 1;
                             }
                     }
                 total = hasLowLetter + hasNum + hasSpecial + hasUpLetter;
                switch (total) {
                        case 1:
                                 strong = "very strong";
                                 break;
                        case 2:
                                 strong = "strong";
                                 break;
                         case 3:
                                 strong = "normal";
                                 break;
                        default:
                                 strong = "not weak";
                                break;
                     }
                 return strong;
             }


            //random menbershipnumber
            public   int membershipnumber() {
                Random random = new Random();
                int membershipnumber =random.nextInt(999999 - 100000 + 1) + 100000;
                return membershipnumber;
           }

}
