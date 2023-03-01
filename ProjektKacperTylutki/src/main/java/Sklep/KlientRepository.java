package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KlientRepository extends JpaRepository<Klient, Integer> {
    List<Klient> findByImie(String imie);
    List<Klient> findByNazwisko(String nazwisko);
    List<Klient> findByTelefon(int telefon);
    List<Klient> findByEmail(String email);
}
