document.getElementById("loginForm").addEventListener("submit", function(event) {
    let valid = true;

    // Controllo email
    let email = document.getElementById("email");
    let emailError = document.getElementById("emailError");
    if (email.value.trim() === "") {
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


