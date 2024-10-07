document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Verhindert das Standardverhalten des Formulars

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // API-Aufruf an das Backend zur Anmeldung
    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username: username, password: password })
    })
 .then(response => response.json())
            .then(data => {
                if (data.accessToken) {
                    localStorage.setItem('jwtToken', data.accessToken);
                    console.log('Token gespeichert:', localStorage.getItem('jwtToken'));
                    window.location.href = 'index.html';
                } else {
                    document.getElementById('message').innerText = 'Anmeldung fehlgeschlagen';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('message').innerText = 'Anmeldung fehlgeschlagen';
            });
        
});