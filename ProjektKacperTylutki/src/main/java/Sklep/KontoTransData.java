package Sklep;

public class KontoTransData {

    private String login;
    private String haslo;
    private String uprawnienia;

    public KontoTransData() {
        this.login = "";
        this.haslo = "";
        this.uprawnienia = "";
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
