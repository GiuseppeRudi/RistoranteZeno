
function getQueryParameter(name) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(name);
}

$(document).ready(function () {

// Recupera il tipo cucina
const tipoCucina = getQueryParameter('cucina');

// Mostra il tipo cucina nel riquadro
if (tipoCucina) {
    $('#tipoCucinaDisplay').text(tipoCucina);
} else {
    $('#tipoCucinaDisplay').text('Non specificato');
}

// Funzione per caricare gli ordini
function loadOrders() {
    $.ajax({
        url: '/api/ordini',  // Endpoint per recuperare gli ordini
        type: 'GET',
        data: { cucina: tipoCucina }, // Passa il tipo di cucina come parametro
        success: function (response) {
            const ordersContainer = $('#orders');
            ordersContainer.empty(); // Pulisce la lista attuale

            // Recupera gli ID degli ordini eliminati dalla sessione per la cucina corrente
            const deletedOrders = JSON.parse(sessionStorage.getItem(tipoCucina + '_deletedOrders')) || [];

            // Aggiunge ogni ordine alla lista
            response.forEach(order => {
                // Se l'ordine è stato eliminato per la cucina corrente (ID è in deletedOrders), non lo mostriamo
                if (!deletedOrders.includes(order.id)) {
                    ordersContainer.append(`
                        <div class="order-item" data-order-id="${order.id}">
                            <div class="order-header">
                                <h5>Ordine #${order.id}</h5>
                            </div>
                            <p><strong>Numero Tavolo:</strong> ${order.numTavolo}</p>
                            <p><strong>Data:</strong> ${new Date(order.data).toLocaleString()}</p>
                            <p><strong>Totale:</strong> €${order.totale.toFixed(2)}</p>
                            <div class="d-flex">
                                <button class="btn btn-info btn-sm">Vedi dettagli</button>
                                <button class="btn btn-danger btn-sm" onclick="eliminaOrdine(${order.id})">Elimina</button>
                            </div>
                        </div>
                    `);
                }
            });

            // Collegare la funzione 'vediDettagli' ai nuovi bottoni creati dinamicamente
            $('.order-item .btn-info').on('click', function () {
                const orderId = $(this).closest('.order-item').data('order-id');
                vediDettagli(orderId);
            });

            $('.order-item .btn-danger').on('click', function () {
                const orderId = $(this).closest('.order-item').data('order-id');
                eliminaOrdine(orderId);
            });
        },
        error: function () {
            alert("Errore nel recupero degli ordini.");
        }
    });
}

// Funzione per eliminare l'ordine solo per la cucina corrente
function eliminaOrdine(orderId) {
    if (confirm("Sei sicuro di voler eliminare l'ordine #" + orderId + "?")) {
        // Aggiungi l'ID dell'ordine eliminato alla sessione per la cucina corrente
        let deletedOrders = JSON.parse(sessionStorage.getItem(tipoCucina + '_deletedOrders')) || [];
        deletedOrders.push(orderId);
        sessionStorage.setItem(tipoCucina + '_deletedOrders', JSON.stringify(deletedOrders));

        // Ricarica gli ordini per riflettere la modifica
        loadOrders();
    }
}

function vediDettagli(orderId) {
    $.ajax({
        url: `/api/ordini/${orderId}/dettagli`,
        type: 'GET',
        data: { cucina: tipoCucina }, // Passa il tipo di cucina come parametro
        success: function (response) {
            let dettagli = '<ul>';
            response.forEach(piatto => {
                dettagli += `<li><strong>Nome:</strong> ${piatto.nome} | <strong>Prezzo:</strong> €${piatto.prezzo.toFixed(2)}</li>`;
            });
            dettagli += '</ul>';
            $('#orderDetailsContent').html(dettagli);
            $('#orderDetailsModal').modal('show');
        },
        error: function () {
            alert("Errore nel caricamento dei dettagli dell'ordine.");
        }
    });
}

// Carica gli ordini inizialmente e ogni 2 secondi
setInterval(loadOrders, 2000);
loadOrders();
});
