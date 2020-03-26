package Membership;
    import java.io.Serializable;


    public class Userinfo implements Serializable {
        private String firstname;
        private String surname;
        private String email;
        private int mobileNumber;
        private int membershipNumber;
        private int virtualStamps;

        public Userinfo() {
        }

        public Userinfo(String firstname, String surname, String email, int mobileNumber, int membershipNumber, int virtualStamps) {
            this.firstname = firstname;
            this.surname = surname;
            this.email = email;
            this.mobileNumber = mobileNumber;
            this.membershipNumber = membershipNumber;
            this.virtualStamps = virtualStamps;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

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

        public int getMembershipNumber() {
            return membershipNumber;
        }

        public void setMembershipNumber(int membershipNumber) {
            this.membershipNumber = membershipNumber;
        }

        public int getVirtualStamps() {
            return virtualStamps;
        }

        public void setVirtualStamps(int virtualStamps) {
            this.virtualStamps = virtualStamps;
        }

        public String toString() {
            return "User{" +
                    "\tfirstname\t" + firstname +
                    "\tsurname\t" + surname +
                    "\temail\t" + email +
                    "\tmobileNumber\t" + mobileNumber +
                    "\tmembershipNumber\t" + membershipNumber +
                    "\tvirtualStamps\t" + virtualStamps +
                    '}';
        }
    }
    

