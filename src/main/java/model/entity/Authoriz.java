package model.entity;

public class Authoriz {

    private int idAuthoriz;
    private int idAuto;
    private int idUser;
    private int idUserAuth;

    public Authoriz(Builder builder) {
        this.idAuthoriz = builder.idAuthoriz;
        this.idAuto = builder.idAuto;
        this.idUser = builder.idUser;
        this.idUserAuth = builder.idUserAuth;
    }

    public int getIdAuthoriz() {
        return idAuthoriz;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdUserAuth() {
        return idUserAuth;
    }

    public static class Builder {
        private int idAuthoriz = 0;
        private int idAuto = 0;
        private int idUser = 0;
        private int idUserAuth = 0;

        public Builder setIdAuthoriz(int idAuthoriz) {
            this.idAuthoriz = idAuthoriz;
            return this;
        }

        public Builder setIdAuto(int idAuto) {
            this.idAuto = idAuto;
            return this;
        }

        public Builder setIdUserAuth(int idUserAuth) {
            this.idUserAuth = idUserAuth;
            return this;
        }

        public Builder setIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public Authoriz build() {
            return new Authoriz(this);
        }
    }
}

