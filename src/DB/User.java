/**
 * Represents a user with personal and login information.
 */
public class User {
    public String Name; // The user's full name
    public String UserName; // The user's chosen username
    public String UserSurname; // The user's surname
    public String UserEmail; // The user's email address (used as a unique identifier)
    public String UserPassword; // The hashed password for user authentication
    public String PhoneNumber; // The user's phone number

    /**
     * Constructor to initialize a User object with the provided information.
     *
     * @param Name        The full name of the user.
     * @param Username    The chosen username for the user.
     * @param Surname     The surname of the user.
     * @param UserEmail   The email address of the user.
     * @param UserHash    The hashed password for the user.
     * @param PhoneNumber The phone number of the user.
     */
    public User(String Name, String Username, String Surname, String UserEmail, String UserHash, String PhoneNumber) {
        this.Name = Name; // Assigns the full name to the Name field
        this.UserName = Username; // Assigns the username to the UserName field
        this.UserSurname = Surname; // Assigns the surname to the UserSurname field
        this.UserEmail = UserEmail; // Assigns the email to the UserEmail field
        this.UserPassword = UserHash; // Assigns the hashed password to the UserPassword field
        this.PhoneNumber = PhoneNumber; // Assigns the phone number to the PhoneNumber field
    }
}
