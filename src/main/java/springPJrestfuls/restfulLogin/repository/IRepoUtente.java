package springPJrestfuls.restfulLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springPJrestfuls.restfulLogin.model.Utente;

@Repository
public interface IRepoUtente extends JpaRepository<Utente, Integer>{
	 Optional<Utente> findByEmail(String email);  // Metodo personalizzato
	 boolean existsByEmail(String email);         // Controlla se l'email esiste
}
