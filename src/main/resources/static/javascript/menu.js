$(document).ready(function () {
    // Mostra il carrello quando clicchi sul pulsante "Carrello"
    $('#btnApriCarrello').on('click', function () {
        $('#sidebar').fadeIn(); // Mostra il carrello con un'animazione
        $(this).hide(); // Nasconde il pulsante "Carrello"
    });

    // Chiudi il carrello quando clicchi sulla "x"
    $('#btnChiudiCarrello').on('click', function () {
        $('#sidebar').fadeOut(400, function () { // Nasconde il carrello con animazione
            $('#btnApriCarrello').fadeIn(); // Mostra di nuovo il pulsante "Carrello" dopo la chiusura
        });
    });
});

$(document).ready(function () {
    function getQueryParameter(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    const numeroTavolo = getQueryParameter('numeroTavolo');
    if (numeroTavolo) {
        $('#numeroTavoloDisplay').text(numeroTavolo);
    } else {
        $('#numeroTavoloDisplay').text('Non specificato');
    }

    let ordine = {
        italiana: [],
        cinese: [],
        giapponese: []
    };

    // Nascondi la sidebar inizialmente
    $('#sidebar').hide();

    $('#cucinaForm').on('submit', function (e) {
        e.preventDefault();
        const cucina = $('input[name="cucina"]:checked').val();

        if (!cucina) {
            alert("Seleziona una cucina!");
            return;
        }

        $.ajax({
            url: '/choose-cuisine',
            type: 'POST',
            data: { cucina: cucina },
            success: function (response) {
                $('#primiPiatti, #secondiPiatti, #dessert').empty();
                let primi = response.slice(0, 3);
                let secondi = response.slice(3, 6);
                let dolci = response.slice(6);

                primi.forEach(piatto => {
                    $('#primiPiatti').append(`
            <div class="menu-item">
              <div class="card">
                <img src="/images/${piatto.immagine}" class="card-img-top" alt="${piatto.nome}">
                <div class="card-body">
                  <h5 class="card-title">${piatto.nome}</h5>
                  <p class="card-text">${piatto.ingredienti}</p>
                  <p class="card-text"><strong>Prezzo: €${piatto.prezzo}</strong></p>
                  <button class="btn btn-primary btn-sm aggiungi-ordine" data-cucina="${cucina}" data-nome="${piatto.nome}" data-prezzo="${piatto.prezzo}" data-immagine="${piatto.immagine}">Aggiungi</button>
                </div>
              </div>
            </div>
          `);
                });

                secondi.forEach(piatto => {
                    $('#secondiPiatti').append(`
            <div class="menu-item">
              <div class="card">
                <img src="/images/${piatto.immagine}" class="card-img-top" alt="${piatto.nome}">
                <div class="card-body">
                  <h5 class="card-title">${piatto.nome}</h5>
                  <p class="card-text">${piatto.ingredienti}</p>
                  <p class="card-text"><strong>Prezzo: €${piatto.prezzo}</strong></p>
                  <button class="btn btn-primary btn-sm aggiungi-ordine" data-cucina="${cucina}" data-nome="${piatto.nome}" data-prezzo="${piatto.prezzo}" data-immagine="${piatto.immagine}">Aggiungi</button>
                </div>
              </div>
            </div>
          `);
                });

                dolci.forEach(piatto => {
                    $('#dessert').append(`
            <div class="menu-item">
              <div class="card">
                <img src="/images/${piatto.immagine}" class="card-img-top" alt="${piatto.nome}">
                <div class="card-body">
                  <h5 class="card-title">${piatto.nome}</h5>
                  <p class="card-text">${piatto.ingredienti}</p>
                  <p class="card-text"><strong>Prezzo: €${piatto.prezzo}</strong></p>
                  <button class="btn btn-primary btn-sm aggiungi-ordine" data-cucina="${cucina}" data-nome="${piatto.nome}" data-prezzo="${piatto.prezzo}" data-immagine="${piatto.immagine}">Aggiungi</button>
                </div>
              </div>
            </div>
          `);
                });

                $('#menuCucina').show();
            },
            error: function () {
                alert("Errore nel caricamento del menu.");
            }
        });
    });

    $(document).on('click', '.aggiungi-ordine', function () {
        const cucina = $(this).data('cucina');
        const nome = $(this).data('nome');
        const prezzo = $(this).data('prezzo');
        const immagine = $(this).data('immagine');

        ordine[cucina].push({ nome, prezzo, immagine });

        $('#ordinePreview').append(`
    <div class="piatto-item">
      <img src="/images/${immagine}" alt="${nome}">
      <div class="details">
        <p>${nome} - €${prezzo}</p>
      </div>
      <button class="btn-remove" data-cucina="${cucina}" data-nome="${nome}">Rimuovi</button>
    </div>
  `);

        // Mostra la sidebar e nascondi il pulsante "Carrello"
        $('#sidebar').fadeIn(); // Mostra la sidebar con animazione
        $('#btnApriCarrello').hide(); // Nasconde il pulsante "Carrello"

        // Nasconde la sidebar automaticamente dopo 2 secondi
        setTimeout(function () {
            $('#sidebar').fadeOut(400, function () {
                $('#btnApriCarrello').fadeIn(); // Mostra il pulsante "Carrello" dopo la fine dell'animazione
            });
        }, 2000); // Aspetta 2 secondi prima di nascondere la sidebar
    });



    $(document).on('click', '.btn-remove', function () {
        const cucina = $(this).data('cucina');
        const nomePiatto = $(this).data('nome');
        ordine[cucina] = ordine[cucina].filter(piatto => piatto.nome !== nomePiatto);
        $(this).parent().remove();
    });

    $('#confermaOrdine').on('click', function () {
        const piattiTotali = Object.values(ordine).flat();
        if (piattiTotali.length === 0) {
            alert("Non hai selezionato alcun piatto!");
            return;
        }

        const payload = {
            numTavolo: numeroTavolo,
            piatti: piattiTotali
        };

        $.ajax({
            url: '/submit-order',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(payload),
            success: function () {
                ordine = { italiana: [], cinese: [], giapponese: [] };
                $('#ordinePreview').empty();
            },
            error: function () {
                alert("Errore nell'invio dell'ordine.");
            }
        });
    });
});
