public abstract class User implements Aunthenticable {
    private String username;
    private String password;

    @Override
    public boolean authenticate() {
        return false;
    }

    @Override
    public String otp() {
        return "";
    }

    @Override
    public String passkey() {
        return "";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    abstract String getPermissions();
}
