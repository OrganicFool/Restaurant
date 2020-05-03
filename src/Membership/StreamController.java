package Membership;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class StreamController {
    private String Path = "/UserData/data";



    public int[] getMembershipNumbers(){
        //获取所有已存在的member

    }

    public boolean check(Userinfo userinfo){
        //检查是否存在这样的用户
    }

    public void writeLine(Userinfo userinfo){
        //写入一个Userinfo到文件
        try {
            //定位到最后一行
            FileWriter fw=new FileWriter(new File(Path),true);

            //记住这个顺序，读和写必须一致
            String Line = userinfo.getNickname() + " " + userinfo.getSurname() + " " + userinfo.getFirstname() + " " + userinfo.getEmail() + " "
                    + Integer.toString(userinfo.getMobileNumber()) + " " + Integer.toString(userinfo.getMembershipNumber()) + " " +
                    Integer.toString(userinfo.getVirtualStamps());
            fw.write(Line);
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Userinfo searchByNickName(String NickName){
        //根据Nickname查找特定用户名
        Userinfo ans = null;

        try{
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;//用来记录每行的字符串
            boolean flag = false;//状态标记，用来标志是否找到了这个Nickname

            while ((str = bf.readLine()) != null) {
                //用空格作为分隔符，解析每一行
                String[] info = str.split(" ");

                //如果找到相同的Nickname的话，就把这一行数据转换为Userinfo
                if(info[0].equals(NickName)){
                    flag = true;
                    ans = new Userinfo(info[0],info[1],info[2],info[3],Integer.parseInt(info[4]),
                            Integer.parseInt(info[5]),Integer.parseInt(info[6]));
                    break;
                }
            }

            //如果没找到，抛出异常
            if (!flag) throw new RuntimeException("No such Nickname");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ans;

    }

    public void removeUserInfo(Userinfo userinfo){

    }


}
