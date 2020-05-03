package Membership;
    import java.io.Serializable;


    public class Userinfo implements Serializable {

        private int membershipNumber;
        private String firstname;
        private String surname;
        private String email;
        private int mobileNumber;
        private int virtualStamps;

        public int getMembershipNumber() {
            return membershipNumber;
        }
        public void setMembershipNumber(int membershipNumber) {
            this.membershipNumber = membershipNumber;
        }

        public String getFirstname() {
            return firstname;
        }
        public void setFirstname(String firstname) { this.firstname = firstname; }

        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public int getMobileNumber() {
            return mobileNumber;
        }
        public void setMobileNumber(int mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public int getVirtualStamps() {
            return virtualStamps;
        }
        public void setVirtualStamps(int virtualStamps) {
            this.virtualStamps = virtualStamps;
        }

        public Userinfo() {
            super();
        }

        public Userinfo(int membershipNumber,String firstname, String surname, String email,int mobileNumber,  int virtualStamps) {
            super();
            this.membershipNumber = membershipNumber;
            this.firstname = firstname;
            this.surname = surname;
            this.email = email;
            this.mobileNumber = mobileNumber;
            this.virtualStamps = virtualStamps;

        }

        public String toString() {
            return "User{" +
                    "\tmembershipNumber\t" + membershipNumber +
                    "\tfirstname\t" + firstname +
                    "\tsurname\t" + surname +
                    "\temail\t" + email +
                    "\tmobileNumber\t" + mobileNumber +
                    "\tvirtualStamps\t" + virtualStamps +
                    '}';
        }
    }
    

