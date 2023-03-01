package Sklep;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KontoRepository extends JpaRepository<Konto, Integer> {
    List<Konto> findByLogin(String login);
    List<Konto> findByHaslo(String haslo);
    List<Konto> findByUprawnienia(String uprawnienia);
}
