package modelos;

public class datosJDBC {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String user = "usr";
    private final String password = "pswd";
    private final String url = "jdbc:mysql://localhost:3306/vehicles-manager";

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}
