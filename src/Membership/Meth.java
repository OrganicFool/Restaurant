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
              //user loop
                boolean isNickname = true;
                String nickname = "";
              do {
                  //Please input your nickname,which can't start with number，no special characters，length should between 3-6
                    System.out.println("Please input your nickname,which can't start with number，\nno special characters，length should between 3-6");
                    nickname = scanner.next();
                    if (nickname.length() < 3 || nickname.length() > 6) {
                        System.out.println("length should between 3-6\n");
                    } else if (isFirstNum(nickname)) {
                        System.out.println("can't start with number\n");
                    } else if (hasSpecificSymbol(nickname)) {
                        System.out.println("no special characters\n");
                    } //else if (hasDuplication(nickname)) {
                        //System.out.println("用户名不能重复\n");}
                    else {
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
                //put password into char[]，traverse this array，number,+1;minuscule,+1;capital letter,+1;special characters
                int total = 0;  //the level of password
                int hasNum = 0;   //number
                int hasUpLetter = 0;  //capital letter
                int hasLowLetter = 0; //minuscule
                int hasSpecial = 0; //special number
                 //set name of strength
                String strong = "";
                //put password into char[]
                char[] c = string.toCharArray();
                //traverse this array
                for (int i = 0; i < c.length; i++) {
                         //0-9
                         if ((int) (c[i]) >= 48 && (int) (c[i]) <= 57) {
                                 hasNum = 1;  //number,+1
                                 //minuscule
                          } else if ((int) (c[i]) >= 97 && (int) (c[i]) <= 122) {
                               hasLowLetter = 1; //minuscule,+1
                                //capital letter
                        } else if ((int) (c[i]) >= 65 && (int) (c[i]) <= 90) {
                            hasUpLetter = 1; //capital letter,+1
                                //special characters
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


            //random membershipnumber(no duplication/无重复随机数)
            public   int membershipnumber() {
                int[] intRandom = new int[999999];
                List mylist = new ArrayList(); //make a set to save the random membershipnumber，and judge it is duplicated or not.
                Random random = new Random();
                int membershipnumber = random.nextInt(1000000);
                while(mylist.size() < 999999) {
                    if(!mylist.contains(membershipnumber)) {
                        mylist.add(membershipnumber); //add data into set
                    }
                }
                for(int i = 0;i <mylist.size();i++) {
                    intRandom[i] = (Integer)(mylist.get(i));
                }
                return membershipnumber;
           }
    public String verificationCode() {
                //make a vericationCode send to mobile or email
                String code = "";
                for (int i = 0; i < 6; i++) {
                        //random a boolean
                         boolean boo = ((int) (Math.random() * 2)) == 0 ? true : false;
                        if (boo) {
                                //if true，random a number
                                code += (int) (Math.random() * 10);
                            } else {
                                //if false，random a char array
                                 int temp = ((int) (Math.random() * 2)) == 0 ? 65 : 97;
                                //if tit starts with 65,ouput capital letter,A，if it starts with 97,it's the begin of minuscule
                            //26 is total numbers
                                char ch = (char) ((int) (Math.random() * 26) + temp);
                                code += String.valueOf(ch);
                           }
                     }
                return code;
            }

}
