package Membership;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StreamController {
    private String Path = "src/data";

    public ArrayList getMembershipnumbers(){
        ArrayList<Integer> nums=new ArrayList<>();

        try{
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;

            while ((str = bf.readLine()) != null) {
                String[] info = str.split("\\s+");
                int a =Integer.parseInt(info[0]);
                nums.add(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nums;
    }

    public boolean check(int num){
        int jug = 0;
        try {
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            while ((str = bf.readLine()) != null) {
                String[] info = str.split("\\s+");
                int a = Integer.parseInt(info[0]);
                if (a == num)
                    jug++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if(jug == 0)
            return false;
        else
            return true;
    }

    public void writeLine(Userinfo userinfo){

        try {

            FileWriter fw=new FileWriter(new File(Path),true);
            String Line = Integer.toString(userinfo.getMembershipNumber()) +" " + userinfo.getFirstname() + " " + userinfo.getSurname()
                    + " " + userinfo.getEmail() + " "
                    + Integer.toString(userinfo.getMobileNumber()) + " "
                    + Integer.toString(userinfo.getVirtualStamps());
            fw.write(Line);
            fw.write("\n");
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Userinfo SearchBymembershipnumber(int membershipnumber){

        Userinfo ans = null;
        try{
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            boolean flag = false;
            String m=Integer.toString(membershipnumber);
            while ((str = bf.readLine()) != null) {

                String[] info = str.split("\\s+");
                if(info[0].equals(m)){
                    flag = true;
                    ans = new Userinfo(Integer.parseInt(info[0]),info[1],info[2],info[3],Integer.parseInt(info[4]),
                            Integer.parseInt(info[5]));
                    break;
                }
            }

            if (!flag) throw new RuntimeException("No such membershipnumber");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ans;

    }

    public void removeUserInfo(int membershipnumber) throws IOException {

        ArrayList<String> afdel = new ArrayList<>();
        try{
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;

            while ((str = bf.readLine()) != null) {
                String[] info = str.split("\\s+");
                int a =Integer.parseInt(info[0].trim());
                if(a != membershipnumber)
                    afdel.add(str);
            }


            FileWriter fw = new FileWriter(Path,false);
            for (int i = 0; i < afdel.size(); i++) {
                fw.write(afdel.get(i));
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int createNum() {
        int newNum = 0;
        int jug = 0;

        try {
            while (jug == 0) {
                newNum = (int) (Math.random() * (99999999 - 10000000 + 1) + 10000000);

                FileReader fr = new FileReader(Path);
                BufferedReader bf = new BufferedReader(fr);
                String str;

                while ((str = bf.readLine()) != null) {
                    String[] info = str.split("\\s+");
                    int a = Integer.parseInt(info[0]);
                    if (a != newNum)
                        jug++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newNum;
    }

    public void useStamp(int membershipnumber){
        String[] afuse = new String[6];
        int stamp = 0;
        String Line;

        try{
            FileReader fr = new FileReader(Path);
            BufferedReader bf = new BufferedReader(fr);
            String str;

            while ((str = bf.readLine()) != null) {
                String[] info = str.split("\\s+");
                int a =Integer.parseInt(info[0]);
                if(a == membershipnumber)
                    System.arraycopy(info, 0, afuse, 0, info.length);
            }

            this.removeUserInfo(membershipnumber);
            stamp = Integer.parseInt(afuse[5]);
            stamp = stamp - 1;
            afuse[5] = String.valueOf(stamp);

            Line = afuse[0] + " " + afuse[1] + " " + afuse[2] + " " + afuse[3] + " " + afuse[4] + " " + afuse[5];
            FileWriter fw = new FileWriter(new File(Path),true);
            fw.write(Line);//���µ���Ϣд���ļ�
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
