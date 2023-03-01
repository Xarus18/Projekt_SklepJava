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
public class AdresController {

    @Autowired
    AdresRepository adresRepository;

    //Dodawanie nowego adresu
    @RequestMapping("/dodaj_adres")
    public String dodajAdres(Model model) {
        AdresTransData transData = new AdresTransData();
        model.addAttribute("transData", transData);
        return "dodaj_adres";
    }

    @RequestMapping(value = "/dodaj_adres", method = RequestMethod.POST)
    public String dodajAdres(Model model, AdresTransData transData) {
        String miejscowosc = transData.getMiejscowosc();
        String ulica = transData.getUlica();
        String nrdomu = transData.getNrdomu();
        String nrmieszkania = transData.getNrmieszkania();
        String kodpocztowy = transData.getKodpocztowy();

        adresRepository.save(new Adres(miejscowosc, ulica, nrdomu, nrmieszkania, kodpocztowy));

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Wstawiono do bazy nowy adres");
        return "viewmessage";
    }

    //Wyświetlanie adresów
    @RequestMapping(value = "/lista_adresow", method = RequestMethod.GET)
    public String listaAdresow(Model model) {
        List<Adres> ListaAdresow = adresRepository.findAll();
        model.addAttribute("header", "Lista Adresów");
        model.addAttribute("ListaAdresow", ListaAdresow);

        return "listaAdresow";
    }

    //Edytowanie adresu
    @RequestMapping(value = "/edytuj_adres", method = RequestMethod.GET)
    public String edytuj_adres(@RequestParam(name = "Id_adresu") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Adres> adres = adresRepository.findById(IntegerID);
        model.addAttribute("edytuj_adres", adres);
        return "edytuj_adres";
    }

    @RequestMapping(value = "/edytuj_adres", method = RequestMethod.POST)
    public String edytuj_adres(@Valid @ModelAttribute("edytuj_adres") Adres edytuj_adres, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_adres", edytuj_adres);
            return "edytuj_adres";
        } else {
            adresRepository.save(edytuj_adres);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Adres numer: " + edytuj_adres.getId_adresu() + " został zaktualizowany pomyślnie");
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
