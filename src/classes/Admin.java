package classes;

import exception.MyException;

public class Admin {
    private String adminGmail;
    private String adminPassword;

    public Admin(){

    }
    public Admin(String adminGmail, String adminPassword) {
        this.adminGmail = adminGmail;
        this.adminPassword = adminPassword;
    }

    public String getAdminGmail() {
        return adminGmail;
    }

    public void setAdminGmail(String adminGmail) throws MyException {
        if (!adminGmail.equals("aizat@gmail.com")){
            throw new MyException("Неправильный gmail!!!");
        }else {
            this.adminGmail = adminGmail;
        }
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) throws MyException {
        if (!adminPassword.equals("aizat130303")){
            throw new MyException("Неправильный пароль!!!");
        }else {
            this.adminPassword = adminPassword;
        }
    }

}
