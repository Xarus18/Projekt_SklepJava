package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresRepository extends JpaRepository<Adres, Integer> {
    List<Adres> findByMiejscowosc(String miejscowosc);
    List<Adres> findByUlica(String ulica);
    List<Adres> findByNrdomu(String nrdomu);
    List<Adres> findByNrmieszkania(String nrmieszkania);
    List<Adres> findByKodpocztowy(int kodpocztowy);
}
