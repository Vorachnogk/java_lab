package model.entity;

public class Auto {
    private int idAuto;
    private  String nameAuto;
    private  String numberAuto;

    public Auto(Builder builder) {
        this.idAuto = builder.idAuto;
        this.nameAuto = builder.nameAuto;
        this.numberAuto = builder.numberAuto;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public String getNameAuto() {
        return nameAuto;
    }

    public String getNumberAuto() {
        return numberAuto;
    }

    public static class  Builder{
        private int idAuto = 0;
        private  String nameAuto = "";
        private  String numberAuto = "";

        public Builder setIdAuto(int idAuto) {
            this.idAuto = idAuto;
            return this;
        }

        public Builder setNameAuto(String nameAuto) {
            this.nameAuto = nameAuto;
            return this;
        }

        public Builder setNumberAuto(String numberAuto) {
            this.numberAuto = numberAuto;
            return this;
        }
        public Auto build() {
            return new Auto(this);
        }
    }
}
