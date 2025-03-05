$(document).ready(function() {
    $('#loginForm').on('submit', function(e) {
        e.preventDefault();
        const numeroTavolo = $('#numeroTavolo').val();
        const password = $('#password').val();

        // Effettua una richiesta al back-end per verificare le credenziali
        $.ajax({
            url: '/login', // Questo è l'endpoint per la verifica delle credenziali
            type: 'POST',
            data: { numeroTavolo: numeroTavolo, password: password },
            success: function(response) {
                if (response.success) {
                    // Passa numeroTavolo come parametro nell'URL
                    window.location.href = `/html/menu.html?numeroTavolo=${numeroTavolo}`;
                } else {
                    // Se le credenziali non sono valide, mostra il messaggio di errore
                    $('#errorMessage').show();
                }
            },
            error: function() {
                alert("Errore nella comunicazione con il server.");
            }
        });
    });
});