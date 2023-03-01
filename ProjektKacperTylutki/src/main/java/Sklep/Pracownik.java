package Sklep;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_pracownika;
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

    public Pracownik() {

    }

    public Pracownik(String imie, String nazwisko, String telefon, String email, Konto konto, Adres adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.konto = konto;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return String.format("Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon=" + telefon +
                ", email='" + email + '\'' +
                '}');
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
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
