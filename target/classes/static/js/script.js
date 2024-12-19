function submitPhoneNumber() {
    const phoneInput = document.getElementById('phone');
    const phoneNumber = phoneInput.value;

    // Отправить номер телефона на сервер
    fetch('/submitPhoneNumber', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'phoneNumber=' + encodeURIComponent(phoneNumber)
    })
    .then(response => response.text())
    .then(data => {
        if (data === 'success') {
            // Показать всплывающее окно
            document.getElementById('popup').style.display = 'block';
        } else {
            alert(data); // Показать сообщение об ошибке от сервера
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Ошибка при сохранении номера телефона.');
    });
}

function closePopup() {
    document.getElementById('popup').style.display = 'none';
}
