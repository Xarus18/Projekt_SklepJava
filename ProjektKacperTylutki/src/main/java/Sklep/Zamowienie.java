package Sklep;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_zamowienia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String datazlozenia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataukonczenia;

    @ManyToOne
    private Klient klient;

    @ManyToOne
    private Produkt produkt;

    public Zamowienie() {

    }

    public Zamowienie(String datazlozenia, String dataukonczenia, Klient klient, Produkt produkt) {
        this.datazlozenia = datazlozenia;
        this.dataukonczenia = dataukonczenia;
        this.klient = klient;
        this.produkt = produkt;
    }

    @Override
    public String toString() {
        return String.format("Zamowienie{" +
                "id_zamowienia=" + id_zamowienia +
                ", datazlozenia='" + datazlozenia + '\'' +
                ", dataukonczenia='" + dataukonczenia + '\'' +
                '}');
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
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
}
