function updateDetails() {
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phoneNumber").value;

    let errorList = ""
    let isValid = true;

    if (email.indexOf('@') === -1) {
        isValid = false;
        errorList += "Email is not valid<br/>";
    }
    if (!phone.match(/^\d{10}$/)) {
        isValid = false;
        errorList += "Phone number must be a 10-digit number<br/>";
    }

    if (phone.length !== 10) {
        isValid = false;
        errorList += "Phone number must be a 10-digit number<br/>";
    }

    if (isValid) {
        document.getElementById("accountForm").submit();
    } else {
        document.getElementById("errors").innerHTML = errorList;
    }
}

function updatePassword() {
    let password = document.getElementById("password").value;
    let passwordCheck = document.getElementById("passwordCheck").value;

    let errorList = ""
    let isValid = true;

    if (password !== passwordCheck) {
        isValid = false;
        errorList += "Passwords do not match<br/>";
    }
    if (password.length < 8) {
        isValid = false;
        errorList += "Password is less than 8 characters<br/>";
    }

    if (isValid) {
        document.getElementById("deactivateForm").submit();
    } else {
        document.getElementById("errors").innerHTML = errorList;
    }
}
