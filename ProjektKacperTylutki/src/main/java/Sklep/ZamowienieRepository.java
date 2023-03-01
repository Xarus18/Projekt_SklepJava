package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {
    List<Zamowienie> findByDatazlozenia(String datazlozenia);
    List<Zamowienie> findByDataukonczenia(String dataukonczenia);
}
