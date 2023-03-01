package Sklep.Controller;

import Sklep.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AdresRepository adresRepository;
    @Autowired
    KlientRepository klientRepository;
    @Autowired
    KontoRepository kontoRepository;
    @Autowired
    PracownikRepository pracownikRepository;
    @Autowired
    ProduktRepository produktRepository;
    @Autowired
    ZamowienieRepository zamowienieRepository;

    @Override
    public void run(ApplicationArguments args) {

        Produkt p1 = new Produkt("Abibas ULTRA", "Sportowe", "Buty do biegania.", 299, 200, "Nie");
        produktRepository.save(p1);

        Adres a1 = new Adres("Warszawa", "Nowa", "12a", "4", "12345");
        Adres a2 = new Adres("Kraków", "Stara", "132c", "2", "67890");
        adresRepository.saveAll(List.of(a1, a2));

        Konto ko1 = new Konto("admin", "admin", "admin");
        Konto ko2 = new Konto("admin1", "admin1", "admin");
        kontoRepository.saveAll(List.of(ko1, ko2));

        Pracownik pr1 = new Pracownik("Jan", "Kowalski", "123456789", "kowalski@email.com", ko2, a2);
        pracownikRepository.save(pr1);

        Klient k1 = new Klient("Łukasz", "Nowak", "987654321", "nowak@mail.com", ko1, a1);
        klientRepository.save(k1);

        //Zamowienie z1 = new Zamowienie("2020-10-10", "2020-10-11", k1, p1);
        //zamowienieRepository.save(z1);

    }
}
