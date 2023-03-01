package Sklep.Controller;

import Sklep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ZamowienieController {

    @Autowired
    ZamowienieRepository zamowienieRepository;

    @Autowired
    KlientRepository klientRepository;

    @Autowired
    ProduktRepository produktRepository;

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date(System.currentTimeMillis());

    //Dodawanie nowego zamowienia
    @RequestMapping("/dodaj_zamowienie")
    public String dodajZamowienie(Model model) {
        ZamowienieTransData transData = new ZamowienieTransData();
        model.addAttribute("transData", transData);
        return "dodaj_zamowienie";
    }

    @RequestMapping(value = "/dodaj_zamowienie", method = RequestMethod.POST)
    public String dodajZamowienie(Model model, ZamowienieTransData transData) {

        Produkt produkt = new Produkt();
        produkt.setId_produktu(Integer.parseInt(transData.getId_produktu()));
//        produkt.setNazwa(transData.getNazwa());
//        produkt.setKategoria(transData.getKategoria());
//        produkt.setOpis(transData.getOpis());
//        produkt.setCena(Integer.parseInt(transData.getCena()));
        produktRepository.save(produkt);

        Klient klient = new Klient();
        klient.setId_klienta(Integer.parseInt(transData.getId_klienta()));
//        klient.setImie(transData.getImie());
//        klient.setNazwisko(transData.getNazwisko());
//        klient.setTelefon(transData.getTelefon());
//        klient.setEmail(transData.getEmail());
        klientRepository.save(klient);

        Zamowienie zamowienie = new Zamowienie();
//        zamowienie.setDataukonczenia("2022-06-02");
        zamowienie.setDatazlozenia(transData.getDatazlozenia());
        zamowienieRepository.save(zamowienie);

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Wstawiono do bazy nowe Zamówienie");
        return "viewmessage";
    }

    //Wyświetlanie zamowień
    @RequestMapping(value = "/lista_zamowien", method = RequestMethod.GET)
    public String listaZamowien(Model model) {
        List<Zamowienie> ListaZamowien = zamowienieRepository.findAll();
        model.addAttribute("header", "Lista Zamówień");
        model.addAttribute("ListaZamowien", ListaZamowien);

        return "listaZamowien";
    }

    //Edytowanie zamówień
    @RequestMapping(value = "/edytuj_zamowienie", method = RequestMethod.GET)
    public String edytuj_zamowienie(@RequestParam(name = "Id_zamowienia") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Zamowienie> zamowienie = zamowienieRepository.findById(IntegerID);
        model.addAttribute("edytuj_zamowienie", zamowienie);
        return "edytuj_zamowienie";
    }

    @RequestMapping(value = "/edytuj_zamowienie", method = RequestMethod.POST)
    public String edytuj_zamowienie(@Valid @ModelAttribute("edytuj_zamowienie") Zamowienie edytuj_zamowienie, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_zamownie", edytuj_zamowienie);
            return "edytuj_zamowienie";
        } else {
            zamowienieRepository.save(edytuj_zamowienie);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Zamowienie numer: " + edytuj_zamowienie.getId_zamowienia() + " zostało zaktualizowane pomyślnie");
            return "wynik_operacji_wiadomosc";
        }
    }

    //Dodawanie nowego zamowienia
    @RequestMapping("/szczegoly_produktu")
    public String szczegoly_produktu(@RequestParam(name = "Id_produktu") String id, Model model) {
        ZamowienieTransData transData = new ZamowienieTransData();
        Integer IntegerID = Integer.parseInt(id);
        Optional<Zamowienie> zamowienie = zamowienieRepository.findById(IntegerID);
        Optional<Produkt> produkt = produktRepository.findById(IntegerID);
        model.addAttribute("edytuj_produkt", produkt);
        model.addAttribute("transData", transData);
        return "szczegoly_produktu";
    }

    @RequestMapping(value = "/szczegoly_produktu", method = RequestMethod.POST)
    public String szczegoly_produktu(Model model, ZamowienieTransData transData, Produkt produkt) {

 //       Produkt produkt = new Produkt();
       // produkt.setId_produktu();
//        produkt.setNazwa(transData.getNazwa());
//        produkt.setKategoria(transData.getKategoria());
//        produkt.setOpis(transData.getOpis());
//        produkt.setCena(Integer.parseInt(transData.getCena()));
//        int ilosc = produkt.getIloscdostepnych();
//        produkt.setIloscdostepnych(ilosc - 1);
        produktRepository.save(produkt);

        Klient klient = new Klient();
        klient.setId_klienta(1);
//        klient.setId_klienta(Integer.parseInt(transData.getId_klienta()));
//        klient.setImie(transData.getImie());
//        klient.setNazwisko(transData.getNazwisko());
//        klient.setTelefon(transData.getTelefon());
//        klient.setEmail(transData.getEmail());
        klientRepository.save(klient);

        Zamowienie zamowienie = new Zamowienie();
//        zamowienie.setDataukonczenia("2022-06-02");
        zamowienie.setDatazlozenia(formatter.format(date));
        zamowienieRepository.save(zamowienie);

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Produkt Zamówiony!");
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
