package Sklep;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_produktu;
    private String nazwa;
    private String kategoria;
    private String opis;
    private int cena;
    private int iloscdostepnych;
    private String wycofany;

    @OneToMany
    private Set<Zamowienie> zamowienie;

    public Produkt(){

    }

    public Produkt(String nazwa, String kategoria, String opis, int cena, int iloscdostepnych, String wycofany){
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.opis = opis;
        this.cena = cena;
        this.iloscdostepnych = iloscdostepnych;
        this.wycofany = wycofany;
    }

    @Override
    public String toString(){
        return String.format(
                "Course[id_produktu=%d, nazwa='%s', kategoria='%s', opis='%s', cena='%d', iloscdostepnych='%d', wycofany='%s]",id_produktu, nazwa, kategoria, opis, cena, iloscdostepnych, wycofany);
    }

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
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

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getIloscdostepnych() {
        return iloscdostepnych;
    }

    public void setIloscdostepnych(int iloscdostepnych) {
        this.iloscdostepnych = iloscdostepnych;
    }

    public String getWycofany() {
        return wycofany;
    }

    public void setWycofany(String wycofany) {
        this.wycofany = wycofany;
    }
}
