package Sklep.Controller;

import Sklep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class KontoController {

    @Autowired
    KontoRepository kontoRepository;

    //Dodawanie nowego konta
    @RequestMapping("/dodaj_konto")
    public String dodajKonto(Model model) {
        KontoTransData transData = new KontoTransData();
        model.addAttribute("transData", transData);
        return "dodaj_konto";
    }

    @RequestMapping(value = "/dodaj_konto", method = RequestMethod.POST)
    public String dodajKonto(Model model, KontoTransData transData) {
        String login = transData.getLogin();
        String haslo = transData.getHaslo();
        String uprawnienia = transData.getUprawnienia();

        kontoRepository.save(new Konto());

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Wstawiono do bazy nowe konto");
        return "viewmessage";
    }

    //Wyświetlanie kont
    @RequestMapping(value = "/lista_kont", method = RequestMethod.GET)
    public String listaKont(Model model) {
        List<Konto> ListaKont = kontoRepository.findAll();
        model.addAttribute("header", "Lista Kont");
        model.addAttribute("ListaKont", ListaKont);

        return "listaKont";
    }

    //Edytowanie konta
    @RequestMapping(value = "/edytuj_konta", method = RequestMethod.GET)
    public String edytuj_konto(@RequestParam(name = "Id_konta") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Konto> konto = kontoRepository.findById(IntegerID);
        model.addAttribute("edytuj_konto", konto);
        return "edytuj_konto";
    }

    @RequestMapping(value = "/edytuj_konto", method = RequestMethod.POST)
    public String edytuj_konto(@Valid @ModelAttribute("edytuj_konto") Konto edytuj_konto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_konto", edytuj_konto);
            return "edytuj_konto";
        } else {
            kontoRepository.save(edytuj_konto);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Konto o loginie: " + edytuj_konto.getLogin() + " zostało zaktualizowane pomyślnie");
            return "wynik_operacji_wiadomosc";
        }
    }

    //Obsługa błędow
    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}
