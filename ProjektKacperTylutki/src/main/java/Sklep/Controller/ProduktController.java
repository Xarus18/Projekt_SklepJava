package Sklep.Controller;

import Sklep.Produkt;
import Sklep.ProduktRepository;
import Sklep.ProduktTransData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ProduktController {

    @Autowired
    ProduktRepository produktRepository;


    //Dodawanie nowego produktu
    @RequestMapping("/add_produkt")
    public String addProdukt(Model model) {
        ProduktTransData transData = new ProduktTransData();
        model.addAttribute("transData", transData);
        return "addprodukt";
    }

    @RequestMapping(value = "/add_produkt", method = RequestMethod.POST)
    public String addProdukt(Model model, ProduktTransData transData) {
        String nazwa = transData.getNazwa();
        String kategoria = transData.getKategoria();
        String opis = transData.getOpis();
        String scena = transData.getCena();
        int cena = Integer.parseInt(scena);
        String siloscdostepnych = transData.getIloscdostepnych();
        int iloscdostepnych = Integer.parseInt(siloscdostepnych);
        String wycofany = "Nie";

        produktRepository.save(new Produkt(nazwa, kategoria, opis, cena, iloscdostepnych, wycofany));

        model.addAttribute("header", "Wynik");
        model.addAttribute("message", "Wstawiono do bazy nowy produkt: " + nazwa);
        return "viewmessage";
    }

    //Wyświetlanie produktów
    @RequestMapping(value = "/lista_produktow", method = RequestMethod.GET)
    public String listaProduktow(Model model) {
        List<Produkt> ListaProduktow = produktRepository.findAll();
        model.addAttribute("header", "Lista Produktów");
        model.addAttribute("ListaProduktow", ListaProduktow);

        return "listaProduktow";
    }

    //Edytowanie produktu
    @RequestMapping(value = "/edytuj_Produkt", method = RequestMethod.GET)
    public String edytuj_produkt(@RequestParam(name = "Id_produktu") String id, Model model) {
        Integer IntegerID = Integer.parseInt(id);
        Optional<Produkt> produkt = produktRepository.findById(IntegerID);
        model.addAttribute("edytuj_produkt", produkt);
        return "edytuj_produkt";
    }

    @RequestMapping(value = "/edytuj_Produkt", method = RequestMethod.POST)
    public String edytuj_produkt(@Valid @ModelAttribute("edytuj_produkt") Produkt edytuj_produkt, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            model.addAttribute("edytuj_produkt", edytuj_produkt);
            return "edytuj_produkt";
        } else {
            produktRepository.save(edytuj_produkt);
            model.addAttribute("icon", "success");
            model.addAttribute("header", "Gratulacje!");
            model.addAttribute("message", "Produkt: " + edytuj_produkt.getNazwa() + " został zaktualizowany pomyślnie");
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
