package model.entity;

public class User {

    public enum ROLE{
        UNKNOWN,
        USER,
        ADMIN
    }

    private long idUser;
    private String name;
    private String login;
    private String pass;
    private ROLE role;

    private User(Builder builder) {
        this.idUser = builder.idUser;
        this.name = builder.name;
        this.login = builder.login;
        this.pass = builder.pass;
        this.role = builder.role;
    }

    public long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role.toString();
    }

    public ROLE userRole() {
        return this.role;
    }

    public static class Builder {
        private long idUser = 0;
        private String name = "";
        private String login = "";
        private String pass = "";
        private ROLE role = ROLE.UNKNOWN;

        public Builder setIdUser(long id) {
            this.idUser = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.pass = password;
            return this;
        }
        public Builder setRole(String stringRole) {
            this.role = ROLE.valueOf(stringRole.toUpperCase());
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
