# HELP.md

## Progetto: Gestione Ristorante - Sistema di Ordini e Cucine

Questo progetto è un'applicazione web progettata per gestire ordini in un ristorante
fornire un'interfaccia per il personale di cucina e i clienti.

---

## **1. Requisiti**

### **1.1 Ambiente di Sviluppo**
- **JDK:** Versione 11 o successiva
- **Spring Boot:** Versione 2.7.0 o successiva
- **Database:** PostgreSQL
- **Maven:** Per la gestione delle dipendenze
- **Browser Web Moderno:** Per testare l'applicazione front-end
- **Node.js:**  per i framework front-end

### **1.2 Dipendenze Principali**
- **Spring Boot Starter Web**: Per creare API REST e gestire richieste HTTP.
- **Spring Boot Starter JDBC**: Per la connessione al database.
- **PostgreSQL Driver**: Per collegare Spring Boot al database PostgreSQL.

---

## **2. Struttura del Progetto**

### **2.1 Front-End**
- La directory dei file statici si trova in:
  Qui troverai:
- HTML: `html/`
- CSS: `css/`
- JavaScript: `javascript/`
- Immagini: `images/`

### **2.2 Back-End**
Il back-end utilizza Spring Boot. Le principali funzionalità includono:
- **Controller**: Gestione delle richieste HTTP
- **DAO**: Gestione delle operazioni di database.

---

## **3. Configurazione del Database**

### **3.1 Creazione del Database**
Assicurati di avere PostgreSQL installato. Crea un database chiamato `RistoranteZeno`:

```sql
CREATE DATABASE ristoranzeZeno;
```

Una volta creato il database eseguire il restore usando psql attraverso il file RistoranteZeno.sql
che si trova al seguente percorso : 

```
src/dumpPostgres
```

Infine il passo finale è andare ad accedere al database secondo le proprie credenziali 
Modificando le variabili username e password presenti nel file DBManager al seguente percorso 

```
src/main/java/it/unical/demacs/informatica/abstractfactory/database/DBManager.java
```

## **4. Utilizzo**

### **4.1 Accesso alla  home**
Per poter utilizzare ogni funzionalità del sito bisogna accedere unicamente attraverso il seguente link 

```
http://localhost:8080/html/home.html
```

In questa pagina troverete la sezione decidata ai clienti con il loro punto di login , il menu e la possibilità
di ordinare comodamente dal loro tavolo.

Infine più nascosto il bottone che dà la possibilità ai dipendenti di accedere alle varie cucine per gestire gli ordini 