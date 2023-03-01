package Sklep;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_adresu;
    private String miejscowosc;
    private String ulica;
    private String nrdomu;
    private String nrmieszkania;
    private String kodpocztowy;

    @OneToOne(mappedBy = "adres")
    private Pracownik pracownik;

    @OneToOne(mappedBy = "adres")
    private Klient klient;

    public Adres() {

    }

    public Adres(String miejscowosc, String ulica, String nrdomu, String nrmieszkania, String kodpocztowy) {
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrdomu = nrdomu;
        this.nrmieszkania = nrmieszkania;
        this.kodpocztowy = kodpocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id_adresu=" + id_adresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrdomu='" + nrdomu + '\'' +
                ", nrmieszkania='" + nrmieszkania + '\'' +
                ", kodpocztowy='" + kodpocztowy + '\'' +
                ", pracownik=" + pracownik +
                ", klient=" + klient +
                '}';
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
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

    public void setNrdomu(String nr_domu) {
        this.nrdomu = nr_domu;
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
