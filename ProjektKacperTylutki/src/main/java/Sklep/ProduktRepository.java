package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduktRepository extends JpaRepository<Produkt, Integer> {
    List<Produkt> findByNazwa(String nazwa);
    List<Produkt> findByKategoria(String kategoria);
    List<Produkt> findByOpis(String opis);
    List<Produkt> findByCena(int cena);
    List<Produkt> findByIloscdostepnych(int iloscdostepnych);
    List<Produkt> findByWycofany(int wycofany);
}
