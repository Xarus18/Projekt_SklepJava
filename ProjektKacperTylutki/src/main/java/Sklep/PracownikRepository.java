package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {
    List<Pracownik> findByImie(String imie);
    List<Pracownik> findByNazwisko(String nazwisko);
    List<Pracownik> findByTelefon(int telefon);
    List<Pracownik> findByEmail(String email);
}
