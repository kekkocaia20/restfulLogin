document.getElementById("registerForm").addEventListener("submit", function(event) {
    let valid = true;

    // Controllo nome
    let nome = document.getElementById("nome");
    let nomeError = document.getElementById("nomeError");
    if (nome.value.trim() === "") {
        nome.classList.add("is-invalid");
        nomeError.style.display = "block";
        valid = false;
    } else {
        nome.classList.remove("is-invalid");
        nomeError.style.display = "none";
    }

    // Controllo cognome
    let cognome = document.getElementById("cognome");
    let cognomeError = document.getElementById("cognomeError");
    if (cognome.value.trim() === "") {
        cognome.classList.add("is-invalid");
        cognomeError.style.display = "block";
        valid = false;
    } else {
        cognome.classList.remove("is-invalid");
        cognomeError.style.display = "none";
    }

    // Controllo email
    let email = document.getElementById("email");
    let emailError = document.getElementById("emailError");
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // Regex per email
    if (email.value.trim() === "" || !emailRegex.test(email.value.trim())) {
        email.classList.add("is-invalid");
        emailError.style.display = "block";
        valid = false;
    } else {
        email.classList.remove("is-invalid");
        emailError.style.display = "none";
    }

    // Controllo password
    let password = document.getElementById("password");
    let passwordError = document.getElementById("passwordError");
    if (password.value.trim() === "") {
        password.classList.add("is-invalid");
        passwordError.style.display = "block";
        valid = false;
    } else {
        password.classList.remove("is-invalid");
        passwordError.style.display = "none";
    }

    // Controllo checkbox
    let accettoTrattamento = document.getElementById("accettoTrattamento");
    let trattamentoError = document.getElementById("trattamentoError");
    if (!accettoTrattamento.checked) {
        trattamentoError.style.display = "block";
        valid = false;
    } else {
        trattamentoError.style.display = "none";
    }

    // Se almeno un campo non è valido, blocca l'invio del form
    if (!valid) {
        event.preventDefault();
    }
});


