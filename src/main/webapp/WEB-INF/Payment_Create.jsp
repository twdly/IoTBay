<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Form</title>
    <link rel="stylesheet" type="text/css" href="payment-style.css">
</head>
<body>
<div class="payment-form">
    <div class="payment-methods">
        <button><img src="mastercard-logo.png" alt="MasterCard"></button>
    </div>
    <div class="form-group">
        <label for="name-card">Name on Card</label>
        <input type="text" id="name-card" placeholder="John Doe">
    </div>
    <div class="form-group">
        <label for="card-number">Card Number</label>
        <input type="number" id="card-number" placeholder="1234 5678 9012 3456">
    </div>
    <div class="form-group">
        <label for="cvv">CVV</label>
        <input type="number" id="cvv" placeholder="123">
    </div>
    <div class="form-group">
        <label for="exp-date">Expiration Date</label>
        <input type="text" id="exp-date" placeholder="MM/YY">
    </div>
    <button class="submit-btn">MAKE A PAYMENT</button>
</div>
</body>
</html>
