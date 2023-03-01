package Sklep.Controller;

import Sklep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class Home {

    @Autowired
    KontoRepository kontoRepository;

    public String login;

    @RequestMapping("/home")
    public String menu(){
        return "index";
    }

    //Logowanie
    @RequestMapping("/login")
    public String logowanie(Model model) {
        KontoTransData transData = new KontoTransData();
        model.addAttribute("transData", transData);
        return "logowanie";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logowanie(Model model, KontoTransData transData) {
        String login = transData.getLogin();
        String haslo = transData.getHaslo();
        Konto konto = kontoRepository.findAll().stream().
                filter(konto1 -> login.equals(konto1.getLogin()))
                .findAny()
                .orElse(null);
        if (konto != null){
            if (konto.getLogin().equals(login) && konto.getHaslo().equals(haslo)) {
                return "index";
            }
        }
        model.addAttribute("header", "Uwaga");
        model.addAttribute("message", "Błędny login lub hasło!");
        return "viewmessage";
    }

    //Rejestracja
    @RequestMapping("/rejestracja")
    public String rejestracja(){
        return "rejestracja";
    }

    //Obsługa uprawnień
    @RequestMapping("/403")
    public String error403(Model model){
        model.addAttribute("header", "Uwaga");
        model.addAttribute("message","Nie posiadasz odpowiednich uprawnień!");
        return "viewmessage";
    }
}
