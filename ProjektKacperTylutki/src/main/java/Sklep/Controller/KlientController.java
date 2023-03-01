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
public class KlientController {

    @Autowired
    KlientRepository klientRepository;

    @Autowired
    KontoRepository kontoRepository;

    @Autowired
    AdresRepository adresRepository;

    //Dodawanie nowego klienta
    @RequestMapping("/dodaj_klienta")
    public String dodajKlient(Model model) {
        KlientTransData transData = new KlientTransData();
        model.addAttribute("transData", transData);
        return "dodaj_klienta";
    }

    @RequestMapping(value = "/dodaj_klienta", method = RequestMethod.POST)
    public String dodajKlient(Model model, KlientTransData transData) {

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
        konto.setUprawnienia("user");
        kontoRepository.save(konto);

        Klient klient = new Klient();
        klient.setImie(transData.getImie());
        klient.setNazwisko(transData.getNazwisko());
        klient.setTelefon(transData.getTelefon());
        klient.setEmail(transData.getEmail());


        klientRepository.save(klient);

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Wstawiono do bazy nowego klienta");
        return "viewmessage";
    }

    //Wyświetlanie klientów
    @RequestMapping(value = "/lista_klientow", method = RequestMethod.GET)
    public String listaKlientow(Model model) {
        List<Klient> ListaKlientow = klientRepository.findAll();
        model.addAttribute("header", "Lista Klientow");
        model.addAttribute("ListaKlientow", ListaKlientow);

        return "listaKlientow";
    }

    //Edytowanie klientów
    @RequestMapping(value = "/edytuj_klient", method = RequestMethod.GET)
    public String edytuj_klient(@RequestParam(name = "Id_klienta") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Klient> klient = klientRepository.findById(IntegerID);
        model.addAttribute("edytuj_klient", klient);
        return "edytuj_klient";
    }

    @RequestMapping(value = "/edytuj_klient", method = RequestMethod.POST)
    public String edytuj_klient(@Valid @ModelAttribute("edytuj_klient") Klient edytuj_klient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_klient", edytuj_klient);
            return "edytuj_klient";
        } else {
            klientRepository.save(edytuj_klient);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Klient numer: " + edytuj_klient.getId_klienta() + " został zaktualizowany pomyślnie");
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
