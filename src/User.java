public class User {
        private String S_num;
        private String S_password;
        // 构造函数、getter和setter

        public String getUserName() {
            return S_num;
        }
        public String getPassword() {
            return S_password;
        }

        public void setUserName(String userName) {this.S_num= userName; }
        public void setPassword(String password) {this.S_password = password; }
}
