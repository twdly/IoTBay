function register() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let passwordCheck = document.getElementById("passwordCheck").value;

    let errorList = ""
    let isValid = true;

    if (password !== passwordCheck) {
        isValid = false;
        errorList += "Passwords do not match<br/>"
    }
    if (password.length < 8) {
        isValid = false;
        errorList += "Password is less than 8 characters<br/>"
    }
    if (email.indexOf('@') === -1) {
        isValid = false;
        errorList += "Email is not valid<br/>"
    }

    if (isValid) {
        document.getElementById("registerForm").submit()
    } else {
        document.getElementById("errors").innerHTML = errorList
    }
}