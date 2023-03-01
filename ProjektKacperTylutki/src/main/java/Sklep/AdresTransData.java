package Sklep;

public class AdresTransData {
    private String miejscowosc;
    private String ulica;
    private String nrdomu;
    private String nrmieszkania;
    private String kodpocztowy;

    public AdresTransData() {
        this.miejscowosc = "";
        this.ulica = "";
        this.nrdomu = "";
        this.nrmieszkania = "";
        this.kodpocztowy = "";
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(String nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getNrmieszkania() {
        return nrmieszkania;
    }

    public void setNrmieszkania(String nrmieszkania) {
        this.nrmieszkania = nrmieszkania;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }
}
