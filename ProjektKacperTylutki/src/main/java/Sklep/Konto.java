package Sklep;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Konto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id_konta;
    private String login;
    private String haslo;
    private String uprawnienia;

    @OneToOne(mappedBy = "konto")
    private Pracownik pracownik;

    @OneToOne(mappedBy = "konto")
    private Klient klient;

    public Konto() {

    }

    public Konto(String login, String haslo, String uprawnienia) {
        this.id_konta = id_konta;
        this.login = login;
        this.haslo = haslo;
        this.uprawnienia = uprawnienia;
    }

    @Override
    public String toString() {
        return String.format("Konto{" +
                "id_konta=" + id_konta +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", uprawnienia='" + uprawnienia + '\'' +
                '}');
    }

    public int getId_konta() {
        return id_konta;
    }

    public void setId_konta(int id_konta) {
        this.id_konta = id_konta;
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
