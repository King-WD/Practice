import java.util.List;

public class AdminService {
    private final AdminDAO adminDAO;

    public AdminService() {
        this.adminDAO= new AdminDAO();
    }

    public Teacher displayQuery(String T_num) {
        return adminDAO.Query(T_num);
    }

    public boolean displayInsert(String[] T_infos){
        return adminDAO.Insert(T_infos) > 0;
    }

    public boolean displayDelete(String T_num) {
        return adminDAO.Delete(T_num) > 0;
    }

    public boolean displaySave(String[] selects) {
        return adminDAO.Save(selects) > 0;
    }

    public Student displayQueryS(String S_num){
        return adminDAO.QueryS(S_num);
    }

    public boolean displayInsertS(String[] S_infos){
        return adminDAO.InsertS(S_infos) > 0;
    }

    public boolean displayDeleteS(String S_num) {
        return adminDAO.DeleteS(S_num) > 0;
    }

    public boolean displaySaveS(String[] selects) {
        return adminDAO.SaveS(selects) > 0;
    }

    public List<String> displayTotal(String S_addr){
        return adminDAO.Total(S_addr);
    }

    public String SureChange(String Old,String New,String Sure,String Admin_num){
        if(!Old.equals(adminDAO.getOld(Admin_num))){
            return "原密码错误或为空!请重新输入";
        }
        else if(!New.equals(Sure)){
            return "两次密码不相等!请重新输入";
        }
        else{
            adminDAO.changePassword(Admin_num,New);
            return "密码修改成功";
        }
    }

    public boolean SureChangeST(String identity,String account,String password){
        if(identity.equals("教师")){
            return adminDAO.changePasswordT(account,password);
        }
        else if(identity.equals("学生")){
            return adminDAO.changePasswordS(account,password);
        }
        return false;
    }
}
