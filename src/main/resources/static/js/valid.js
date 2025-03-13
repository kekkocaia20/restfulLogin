document.getElementById("recoveryForm").addEventListener("submit", function(event) {
    let valid = true;

    // Controllo email
    let emailField = document.getElementById("email");
    let emailError = document.getElementById("emailError");
    if (emailField.value.trim() === "") {
        emailField.classList.add("is-invalid");
        emailError.classList.remove("d-none");
        valid = false;
    } else {
        emailField.classList.remove("is-invalid");
        emailError.classList.add("d-none");
    }

    // Controllo password
    let passwordField = document.getElementById("newPassword");
    let passwordError = document.getElementById("passwordError");
    if (passwordField.value.trim() === "") {
        passwordField.classList.add("is-invalid");
        passwordError.classList.remove("d-none");
        valid = false;
    } else {
        passwordField.classList.remove("is-invalid");
        passwordError.classList.add("d-none");
    }

    // Controllo checkbox
    let trattamentoField = document.getElementById("accettoTrattamento");
    let trattamentoError = document.getElementById("trattamentoError");
    if (!trattamentoField.checked) {
        trattamentoError.classList.remove("d-none");
        valid = false;
    } else {
        trattamentoError.classList.add("d-none");
    }

    // Se ci sono errori, blocca il submit
    if (!valid) {
        event.preventDefault();
    }
});