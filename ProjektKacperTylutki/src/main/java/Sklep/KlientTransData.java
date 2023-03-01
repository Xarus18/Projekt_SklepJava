package Sklep;

public class KlientTransData {

    private String id_klienta;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;

    private String miejscowosc;
    private String ulica;
    private String nrdomu;
    private String nrmieszkania;
    private String kodpocztowy;

    private String login;
    private String haslo;
    private String uprawnienia;


    public KlientTransData() {
        this.id_klienta = "";
        this.imie = "";
        this.nazwisko = "";
        this.telefon = "";
        this.email = "";
        this.miejscowosc = "";
        this.ulica = "";
        this.nrdomu = "";
        this.nrmieszkania = "";
        this.kodpocztowy = "";
        this.login = "";
        this.haslo = "";
        this.uprawnienia = "";
    }

    public String getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(String uprawnienia) {
        this.uprawnienia = uprawnienia;
    }
}
