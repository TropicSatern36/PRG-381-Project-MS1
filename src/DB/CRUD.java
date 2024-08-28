import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
    private DatabaseConnection connection;

    public CRUD(DatabaseConnection connection) {
        this.connection = connection;
        // This query creates the tables if they don't already exist
        String sql = """
                CREATE TABLE IF NOT EXISTS public.library
                (
                    bookid integer NOT NULL DEFAULT nextval('library_bookid_seq'::regclass),
                    bookname character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    author character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    date_rented timestamp without time zone NOT NULL,
                    CONSTRAINT library_pkey PRIMARY KEY (bookid)
                )
                TABLESPACE pg_default;
                ALTER TABLE IF EXISTS public.library
                    OWNER to postgres;
                CREATE TABLE IF NOT EXISTS public.users
                (
                    useremail character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    usersurname character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
                    userphone character varying(10) COLLATE pg_catalog."default" NOT NULL,
                    CONSTRAINT users_pkey PRIMARY KEY (useremail)
                )
                TABLESPACE pg_default;
                ALTER TABLE IF EXISTS public.users
                    OWNER to postgres;
                CREATE TABLE IF NOT EXISTS public.userlibrary
                (
                    useremail character varying(50) COLLATE pg_catalog."default",
                    bookid bigint,
                    name character varying(50) COLLATE pg_catalog."default",
                    CONSTRAINT userlibrary_bookid_fkey FOREIGN KEY (bookid)
                        REFERENCES public.library (bookid) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION,
                    CONSTRAINT userlibrary_name_fkey FOREIGN KEY (name)
                        REFERENCES public.users (useremail) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION,
                    CONSTRAINT userlibrary_useremail_fkey FOREIGN KEY (useremail)
                        REFERENCES public.users (useremail) MATCH SIMPLE
                        ON UPDATE NO ACTION
                        ON DELETE NO ACTION
                )
                TABLESPACE pg_default;
                ALTER TABLE IF EXISTS public.userlibrary
                    OWNER to postgres; """;

        // This code runs the SQL query to create the tables
        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.execute(); // Execute the SQL statement
        } catch (Exception e) {
            // Print an error message if something goes wrong

        }
    }

    // Insert methods for adding data to the database

    /**
     * Adds a new User to the `public.users` table.
     *
     * @param user The User object with the data to be inserted.
     */
    public void insert(User user) {
        String sql = """
                INSERT INTO public.users (useremail, username, usersurname, name, userphone, userpassword)
                VALUES (?, ?, ?, ?, ?, ?);
                """;

        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.UserEmail);
            pstmt.setString(2, user.UserName);
            pstmt.setString(3, user.UserSurname);
            pstmt.setString(4, user.Name);
            pstmt.setString(5, user.PhoneNumber);
            pstmt.setString(6, user.UserPassword); // Password is hashed
            pstmt.executeUpdate(); // Run the SQL command to insert the user
        } catch (SQLException e) {
        }
    }

    /**
     * Gets a User from the `public.users` table using their email.
     *
     * @param email The email of the user to find.
     * @return A User object with the user's details, or null if not found.
     */
    public User getUserByEmail(String email) {
        String sql = """
                SELECT useremail, username, usersurname, name, userphone, userpassword
                FROM public.users
                WHERE useremail = ?;
                """;

        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email); // Set the email to search for
            ResultSet rs = pstmt.executeQuery(); // Run the query and get results

            if (rs.next()) { // If there is a result
                return new User(
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("usersurname"),
                        rs.getString("useremail"),
                        rs.getString("userpassword"),
                        rs.getString("userphone"));
            }
        } catch (SQLException e) {
        }
        return null; // Return null if no user is found
    }

    /**
     * Updates an existing User's details in the `public.users` table.
     *
     * @param user The User object with the updated data.
     */
    public void update(User user) {
        String sql = """
                UPDATE public.users
                SET username = ?, usersurname = ?, name = ?, userphone = ?, userpassword = ?
                WHERE useremail = ?;
                """;

        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.UserName);
            pstmt.setString(2, user.UserSurname);
            pstmt.setString(3, user.Name);
            pstmt.setString(4, user.PhoneNumber);
            pstmt.setString(5, user.UserPassword); // Password is hashed
            pstmt.setString(6, user.UserEmail); // Specify which user to update
            pstmt.executeUpdate(); // Run the SQL command to update the user
        } catch (SQLException e) {
        }
    }

    // Insert methods for adding UserLibrary and Books records

    /**
     * Adds a new UserLibrary record to the `public.userlibrary` table.
     *
     * @param userLibrary The UserLibrary object with the data to be inserted.
     */
    public void insert(UserLibrary userLibrary) {
        String sql = """
                INSERT INTO public.userlibrary (useremail, bookid, date_rented)
                VALUES (?, ?, ?);
                """;

        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userLibrary.Name);
            pstmt.setString(2, userLibrary.Book);
            pstmt.setDate(3, new java.sql.Date(userLibrary.DateRented.getTime())); // Convert Date to SQL Date
            pstmt.executeUpdate(); // Run the SQL command to insert the record
        } catch (SQLException e) {
        }
    }

    /**
     * Gets a UserLibrary record from the `public.userlibrary` table using email and
     * book ID.
     *
     * @param email  The email of the user.
     * @param bookId The ID of the book.
     * @return A UserLibrary object with the record's details, or null if not found.
     */
    public UserLibrary getUserLibraryByEmailAndBookId(String email, int bookId) {
        String sql = """
                SELECT useremail, bookid, date_rented
                FROM public.userlibrary
                WHERE useremail = ? AND bookid = ?;
                """;
        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email); // Set the email to search for
            pstmt.setInt(2, bookId); // Set the book ID to search for
            ResultSet rs = pstmt.executeQuery(); // Run the query and get results

            if (rs.next()) { // If there is a result
                return new UserLibrary(
                        rs.getString("useremail"),
                        rs.getString("bookid"),
                        rs.getDate("date_rented")); // Create and return a UserLibrary object
            }
        } catch (SQLException e) {
        }
        return null; // Return null if no record is found
    }

    /**
     * Updates an existing UserLibrary record in the `public.userlibrary` table.
     *
     * @param userLibrary The UserLibrary object with the updated data.
     */
    public void update(UserLibrary userLibrary) {
        String sql = """
                UPDATE public.userlibrary
                SET date_rented = ?
                WHERE useremail = ? AND bookid = ?;
                """;

        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, new java.sql.Date(userLibrary.DateRented.getTime())); // Convert Date to SQL Date
            pstmt.setString(2, userLibrary.Name);
            pstmt.setString(3, userLibrary.Book); // Specify which record to update
            pstmt.executeUpdate(); // Run the SQL command to update the record
        } catch (SQLException e) {
        }
    }

    /**
     * Adds a new Book to the `public.library` table.
     *
     * @param book The Books object with the data to be inserted.
     */
    public void insert(Books book) {
        String sql = """
                INSERT INTO public.library (bookname, author, date_rented, price)
                VALUES (?, ?, ?, ?);
                """;
        try (Connection conn = connection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.Book);
            pstmt.setString(2, book.Author);
            pstmt.setDate(3, new java.sql.Date(book.DateRented.getTime())); // Convert Date to SQL Date
            pstmt.setDouble(4, book.Price);
            pstmt.executeUpdate(); // Run the SQL command to insert the book
        } catch (SQLException e) {
        }
    }

    // You can add more methods to retrieve and update Books records similarly
}
