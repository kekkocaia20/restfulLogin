package springPJrestfuls.restfulLogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import springPJrestfuls.restfulLogin.model.Utente;
import springPJrestfuls.restfulLogin.repository.IRepoUtente;

@Controller
public class GestoreRichieste {

    @Autowired
    IRepoUtente iru;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";  // Mostra la pagina di registrazione
    }

    @PostMapping("/register")
    public String register(@RequestParam String nome, @RequestParam String cognome, 
                           @RequestParam String email, @RequestParam String password,  
                           RedirectAttributes redirectAttributes) {
        if (iru.existsByEmail(email)) {
        	redirectAttributes.addFlashAttribute("error", "Email già in uso!");  // Aggiungi l'errore con addFlashAttribute
            return "redirect:/register";  // Reindirizza alla pagina di registrazione con il messaggio
        }

        Utente utente = new Utente();
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setPassword(password);
        iru.save(utente);

        redirectAttributes.addFlashAttribute("message", "La registrazione è andata a buon fine!");
        return "redirect:/login";  // Reindirizza al login
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Mostra la pagina di login
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttributes) {
        Utente user = iru.findByEmail(email).orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
        	redirectAttributes.addFlashAttribute("error", "Email o password errati!");  // Aggiungi l'errore
            return "redirect:/login";  // Reindirizza alla pagina di login con il messaggio di errore
        }

        // Salva l'utente nella sessione
        session.setAttribute("user", user);

        return "redirect:/success";  // Reindirizza alla pagina di successo
    }

    @GetMapping("/success")
    public String showSuccessPage(HttpSession session) {
        // Verifica se l'utente è loggato
        if (session.getAttribute("user") == null) {
            return "redirect:/login";  // Se non è loggato, reindirizza al login
        }
        
        return "success";  // Mostra la pagina di successo
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Rimuovi l'utente dalla sessione per fare il logout
        session.invalidate();
        return "redirect:/index";  // Ritorna alla pagina di login
    }
    
    @GetMapping("/readAll")
    public String readAll(Model model) {
        List<Utente> utenti = iru.findAll();
        model.addAttribute("utenti", utenti);
        return "tabella";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iru.deleteById(id);
        return "redirect:/index";
    }

    // Endpoint per mostrare il form di recupero
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "forgot-password"; // Mostra il modulo di recupero
    }

    // Endpoint per gestire la modifica della password
    @PostMapping("/recover-password")
    public String recoverPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword, RedirectAttributes redirectAttributes) {
        // Verifica se l'email esiste nel sistema
        Optional<Utente> userOptional = iru.findByEmail(email);
        if (userOptional.isPresent()) {
            Utente user = userOptional.get();
            
            // Imposta la nuova password senza criptazione
            user.setPassword(newPassword);

            // Salva la nuova password nel database
            iru.save(user);

            redirectAttributes.addFlashAttribute("message", "La tua password è stata cambiata con successo.");
            return "redirect:/login"; // Reindirizza al login con un messaggio di successo
        } else {
            redirectAttributes.addFlashAttribute("error", "L'email non è associata a nessun account.");
            return "redirect:/forgot-password"; // Se l'email non esiste, torna al form
        }
    }
}





