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
public class PracownikController {
    @Autowired
    PracownikRepository pracownikRepository;

    @Autowired
    KontoRepository kontoRepository;

    @Autowired
    AdresRepository adresRepository;

    //Wyświetlanie pracowników
    @RequestMapping(value = "/lista_pracownikow", method = RequestMethod.GET)
    public String listaPracownikow(Model model) {
        List<Pracownik> ListaPracownikow = pracownikRepository.findAll();
//        List<Konto> ListaKont = kontoRepository.findAll();
//        List<Adres> ListaAdresow = adresRepository.findAll();
        model.addAttribute("header", "Lista Pracowników");
        model.addAttribute("ListaPracownikow", ListaPracownikow);
//        model.addAttribute("ListaKont", ListaKont);
//        model.addAttribute("ListaAdresow", ListaAdresow);

        return "lista_pracownikow";
    }

    //Edytowanie pracowników
    @RequestMapping(value = "/edytuj_pracownika", method = RequestMethod.GET)
    public String edytuj_pracownika(@RequestParam(name = "Id_pracownika") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Pracownik> pracownik = pracownikRepository.findById(IntegerID);
        model.addAttribute("edytuj_pracownika", pracownik);
        return "edytuj_pracownika";
    }

    @RequestMapping(value = "/edytuj_pracownika", method = RequestMethod.POST)
    public String edytuj_pracownika(@Valid @ModelAttribute("edytuj_pracownika") Pracownik edytuj_pracownika, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_pracownika", edytuj_pracownika);
            return "edytuj_pracownika";
        } else {
            pracownikRepository.save(edytuj_pracownika);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Pracownik numer: " + edytuj_pracownika.getId_pracownika() + " został zaktualizowany pomyślnie");
            return "wynik_operacji_wiadomosc";
        }
    }

    //Dodawanie nowego pracownika
    @RequestMapping("/dodaj_pracownika")
    public String dodajPracownik(Model model) {
        PracownikTransData transData = new PracownikTransData();
        model.addAttribute("transData", transData);
        return "dodaj_pracownika";
    }

    @RequestMapping(value = "/dodaj_pracownika", method = RequestMethod.POST)
    public String dodajPracownik(Model model, PracownikTransData transData) {

        Adres adres = new Adres();
        adres.setMiejscowosc(transData.getMiejscowosc());
        adres.setUlica(transData.getUlica());
        adres.setNrdomu(transData.getNrdomu());
        adres.setNrmieszkania(transData.getNrmieszkania());
        adres.setKodpocztowy(transData.getKodpocztowy());
        adresRepository.save(adres);

        Konto konto = new Konto();
        konto.setLogin(transData.getLogin());
        konto.setHaslo(transData.getHaslo());
        konto.setUprawnienia("admin");
        kontoRepository.save(konto);

        Pracownik pracownik = new Pracownik();
        pracownik.setImie(transData.getImie());
        pracownik.setNazwisko(transData.getNazwisko());
        pracownik.setTelefon(transData.getTelefon());
        pracownik.setEmail(transData.getEmail());


        pracownikRepository.save(pracownik);

        model.addAttribute("icon", "success");
        model.addAttribute("header", "Gratulacje!");
        model.addAttribute("message", "Pracownik " + pracownik.getImie() +" "+ pracownik.getNazwisko() +" został dodany pomyślnie");
        return "viewmessage";
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
