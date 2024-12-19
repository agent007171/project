function submitPhoneNumber() {
    const phoneInput = document.getElementById('phone');
    const phoneNumber = phoneInput.value;
    const phoneRegex = /^\+?[1-9]\d{1,14}$/; // Регулярное выражение для проверки номера телефона

    if (phoneRegex.test(phoneNumber)) {
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
                alert('Ошибка при сохранении номера телефона.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Ошибка при сохранении номера телефона.');
        });
    } else {
        alert('Пожалуйста, введите корректный номер телефона.');
    }
}

function closePopup() {
    document.getElementById('popup').style.display = 'none';
}