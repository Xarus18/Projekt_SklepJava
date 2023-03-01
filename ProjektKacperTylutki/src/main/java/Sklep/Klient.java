package Sklep;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_klienta;
    private String imie;
    private String nazwisko;
    private String telefon;
    private String email;

    @OneToOne
    @JoinColumn(name = "id_konta", referencedColumnName = "id_konta")
    private Konto konto;

    @OneToOne
    @JoinColumn(name = "id_adresu", referencedColumnName = "id_adresu")
    private Adres adres;

    @OneToMany(mappedBy = "klient")
    private  Set<Zamowienie> zamowienie;

    public Klient() {

    }

    public Klient(String imie, String nazwisko, String telefon, String email, Konto konto, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.konto = konto;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id_klienta=" + id_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", konto=" + konto +
                ", adres=" + adres +
                ", zamowienie=" + zamowienie +
                '}';
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
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
}
