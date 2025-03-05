$(document).ready(function() {
    $('#loginForm').on('submit', function(e) {
        e.preventDefault();
        const cucina = $('#cucina').val();
        const password = $('#password').val();

        // Effettua una richiesta al back-end per verificare le credenziali
        $.ajax({
            url: '/loginCucina', // Endpoint per la verifica delle credenziali dello staff
            type: 'POST',
            data: { cucina: cucina, password: password },
            success: function(response) {
                if (response.success) {
                    // Passa la cucina come parametro nell'URL (puoi personalizzare l'URL in base alle necessità)
                    window.location.href = `/html/cucina.html?cucina=${cucina}`;
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