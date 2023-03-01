package Sklep;

public class ProduktTransData {

    private String id_produktu;
    private String nazwa;
    private String kategoria;
    private String opis;
    private String cena;
    private String iloscdostepnych;

    public ProduktTransData() {
        this.id_produktu = "";
        this.nazwa = "";
        this.kategoria = "";
        this.opis = "";
        this.cena = "";
        this.iloscdostepnych = "";
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

    public String getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(String id_produktu) {
        this.id_produktu = id_produktu;
    }
}
