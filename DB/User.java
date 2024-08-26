
public class User {
    public String UserName;
    public String UserSurname;
    public String UserEmail;
    public String UserHash;
    public String PhoneNumber;
    public User(String Username,String Surname, String UserEmail,String Password,String PhoneNumber,Boolean needsHash) {
        this.UserName = Username;
        this.UserSurname = Surname;
        this.UserEmail = UserEmail;
        if (needsHash) {
            try {
                this.UserHash = PasswordHashing.hashPassword(Password);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            this.UserHash = Password;
        }
        this.PhoneNumber = PhoneNumber;
    }
}


