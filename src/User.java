public class User {
        private int userId;
        private String userName;
        private String password;
        // 构造函数、getter和setter

        public int getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }
        public String getPassword() {
            return password;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
}
