package Sklep;

public class ZamowienieTransData {

    private String id_zamowienia;
    private String datazlozenia;
    private String dataukonczenia;

    private String id_klienta;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;

    private String id_produktu;
    private String nazwa;
    private String kategoria;
    private String opis;
    private String cena;
    private String iloscdostepnych;

    public ZamowienieTransData() {
        this.id_zamowienia = "";
        this.datazlozenia = "";
        this.dataukonczenia = "";
        this.id_klienta = "";
        this.imie = "";
        this.nazwisko = "";
        this.telefon = "";
        this.email = "";
        this.id_produktu = "";
        this.nazwa = "";
        this.kategoria = "";
        this.opis = "";
        this.cena = "";
        this.iloscdostepnych = "";
    }

    public String getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(String id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public String getDatazlozenia() {
        return datazlozenia;
    }

    public void setDatazlozenia(String datazlozenia) {
        this.datazlozenia = datazlozenia;
    }

    public String getDataukonczenia() {
        return dataukonczenia;
    }

    public void setDataukonczenia(String dataukonczenia) {
        this.dataukonczenia = dataukonczenia;
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

    public String getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(String id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getIloscdostepnych() {
        return iloscdostepnych;
    }

    public void setIloscdostepnych(String iloscdostepnych) {
        this.iloscdostepnych = iloscdostepnych;
    }
}
