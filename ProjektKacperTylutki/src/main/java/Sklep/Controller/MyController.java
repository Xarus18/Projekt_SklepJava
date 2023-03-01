package Sklep.Controller;

import java.util.List;

import Sklep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    @Autowired
    KlientRepository klientRepository;
    @Autowired
    KontoRepository kontoRepository;
    @Autowired
    PracownikRepository pracownikRepository;
    @Autowired
    ZamowienieRepository zamowienieRepository;
    @Autowired
    ProduktRepository produktRepository;
    @Autowired
    AdresRepository adresRepository;

    //Obsługa błędow
    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}
