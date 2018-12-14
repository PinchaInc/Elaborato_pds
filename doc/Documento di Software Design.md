# <center>Elaborato progettazione del software</center>

## <center>Gestione gruppi ed elaborati</center>

![logo][]

| Nome               | Matricola |
| ------------------ | --------- |
| Mignone Raffaele   | 863/747   |
| Mincolelli Noemi   | 863/701   |
| Quarantiello Luigi | 863/953   |

---

## 1 - Ambito

### 1.1 - Obiettivi del sistema

Il sistema progettato ha come obiettivo principale la gestione dei corsi universitari. 
Il sistema è orientato all'utilizzo da parte dei docenti che tengono un corso e da eventuali tutor ad esso associati, e permette loro di gestire gli studenti, i gruppi di studenti e gli elaborati assegnati.
Il sistema è formato da tre sezioni:

+ Una dedicata alla panoramica degli studenti, dalla quale è possibile ottenere le informazioni relative agli studenti iscritti al corso. Inoltre, in questa sezione è possibile inserire un nuovo studente e formare un nuovo gruppo di studenti;
+ Una dedicata ai gruppi, dalla quale è possibile visualizzare le informazioni sui gruppi precedentemente creati e sugli elaborati disponibili, e che permette l'assegnamento di un elaborato ad un gruppo. Inoltre, è possibile aggiungere la traccia di un nuovo elaborato e assegnare la data di ricevimento con un gruppo;
+ Una relativa all'agenda personale di ogni utente, dalla quale è possibile visualizzare i ricevimenti con i gruppi precedentemente assegnati. In questa sezione è possibile anche registrare lo stato di avanzamento di un gruppo.


### 1.2 - Requisiti

+ Aggiunta di un nuovo studente;
+ Creazione di un nuovo gruppo;
+ Aggiunta di un nuovo elaborato;
+ Assegnamento di un elaborato ad un gruppo;
+ Aggiunta di un nuovo incontro con un gruppo;
+ Registrazione dello stato di avanzamento di un gruppo.

---

#### 1.2.1 - Use Case

##### UC.1 - Inserimento di un nuovo studente

| Nome del caso d'uso | Inserimento di un nuovo studente                                                           |
| ------------------- | ------------------------------------------------------------------------------------------ |
| **Descrizione**     | È il processo che il docente o un tutor deve compiere per poter inserire un nuovo studente |
| **Precondizione**   | Il docente o il tutor è in possesso di un account abilitato                                |
| **Postcondizione**  | La lista degli studenti registrati viene ampliata con un nuovo studente                    |

###### Scenario principale

| Docente o tutor                                                                  | Sistema                                                                                                                         |
| -------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| 1.1 Il docente o il tutor chiede di accedere al sistema                          |                                                                                                                                 |
|                                                                                  | 2.1 Il sistema chiede le credenziali di accesso                                                                                 |
| 3.1 Il docente o il tutor comunica il suo username e la password                 |                                                                                                                                 |
|                                                                                  | 4.1 Il sistema autentica il docente o il tutor                                                                                  |
| 5.1 Il docente o il tutor chiede la lista degli studenti registrati              |                                                                                                                                 |
|                                                                                  | 6.1 Il sistema comunica la lista degli studenti registrati                                                                      |
| 7.1 Il docente o il tutor chiede di  inserire un nuovo studente                  |                                                                                                                                 |
|                                                                                  | 8.1 Il sistema chiede i dati dello studente da inserire                                                                         |
| 9.1 Il docente o il tutor comunica i dati dello studente e conferma l'operazione |                                                                                                                                 |
|                                                                                  | 10.1 Il sistema verifica che lo studente non sia già stato inserito<br />10.2 Il sistema comunica il buon esito dell'operazione |

---

###### Scenario alternativo A1 - Dati di accesso non corretti

| Docente o tutor | Sistema                                                                                                                                 |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A1.4.1 Il sistema comunica al docente o al tutor che i dati inseriti non sono validi<br />Ritorno allo scenario principale al punto 2.1 |

###### Scenario alternativo A2 - Lo studente è stato già registrato

| Docente o tutor | Sistema                                                                                                                                                             |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A2.10.2 Il sistema avvisa il docente o il tutor che i dati inseriti corrispondono ad uno studente già registrato<br />Ritorno allo scenario principale al punto 8.1 |

---

##### UC.2 - Creazione di un nuovo gruppo

| Nome del caso d'uso | Creazione di un nuovo gruppo                                                                 |
| ------------------- | -------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che un docente o un tutor deve eseguire per creare un nuovo gruppo di studenti |
| **Precondizione**   |                                                                                              |
| **Postcondizione**  |                                                                                              |

###### Scenario principale

| Docente o tutor                                                                              | Sistema                                                                                                                                                                                                                |
| -------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1.1 Il docente o il tutor chiede di accedere al sistema                                      |                                                                                                                                                                                                                        |
|                                                                                              | 2.1 Il sistema chiede le credenziali di accesso                                                                                                                                                                        |
| 3.1 Il docente o il tutor comunica il suo username e la password                             |                                                                                                                                                                                                                        |
|                                                                                              | 4.1 Il sistema autentica il docente o il tutor                                                                                                                                                                         |
| 5.1 Il docente o il tutor chiede la lista degli studenti registrati                          |                                                                                                                                                                                                                        |
|                                                                                              | 6.1 Il sistema comunica la lista degli studenti registrati                                                                                                                                                             |
| 7.1 Il docente o il tutor chiede di formare un nuovo gruppo di studenti                      |                                                                                                                                                                                                                        |
|                                                                                              | 8.1 Il sistema chiede di selezionare gli studenti da inserire nel nuovo gruppo ed il nome del gruppo                                                                                                                   |
| 9.1 Il docente o il tutor seleziona gli studenti da inserire ed inserisce il nome del gruppo |                                                                                                                                                                                                                        |
|                                                                                              | 10.1 Il sistema controlla che gli studenti selezionati non facciano già parte di un gruppo<br />10.2 Il sistema controlla che il nome inserito sia univoco<br />10.3 Il sistema comunica il buon esito dell'operazione |

---

###### Scenario alternativo A1 - Uno o più studenti selezionati fa già parte di un gruppo

| Docente o tutor | Sistema                                                                                                                                                    |
| --------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A1.10.1 Il sistema comunica che uno o più studenti selezionati fanno già parte di un gruppo e li mostra<br />Ritorno allo scenario principale al punto 8.1 |

###### Scenario alternativo A2 - Il nome del gruppo non è univoco

| Docente o tutor | Sistema                                                                                                                                                            |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|                 | A2.10.3 Il sistema comunica che il nome inserito è già stato scelto come nome di un gruppo creato in precedenza<br />Ritorno allo scenario principale al punto 8.1 |

---

##### UC.3 - Assegnamento di un elaborato ad un gruppo

| Nome del caso d'uso | Assegnamento di un elaborato ad un gruppo                                                                              |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che il docente o un tutor deve effettuare per assegnare un elaborato ad un gruppo precedentemente creato |
| **Precondizione**   |                                                                                                                        |
| **Postcondizione**  | Al gruppo scelto viene assegnato un elaborato                                                                          |

###### Scenario principale

| Docente o tutor                                                         | Sistema                                                                                                                                                                                                                                 |
| ----------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1.1 Il docente o il tutor chiede di accedere al sistema                 |                                                                                                                                                                                                                                         |
|                                                                         | 2.1 Il sistema chiede le credenziali di accesso                                                                                                                                                                                         |
| 3.1 Il docente o il tutor comunica il suo username e la password        |                                                                                                                                                                                                                                         |
|                                                                         | 4.1 Il sistema autentica il docente o il tutor                                                                                                                                                                                          |
| 5.1 Il docente o il tutor chiede la lista dei gruppi                    |                                                                                                                                                                                                                                         |
|                                                                         | 6.1 Il sistema mostra la  lista dei gruppi precedentemente creati                                                                                                                                                                       |
| 7.1 Il docente o il tutor chiede di assegnare un elaborato ad un gruppo |                                                                                                                                                                                                                                         |
|                                                                         | 8.1 Il sistema chiede di selezionare il gruppo a cui assegnare l'elaborato                                                                                                                                                              |
| 9.1 Il docente o il tutor seleziona il gruppo dalla lista               |                                                                                                                                                                                                                                         |
|                                                                         | 10.1 Il sistema verifica che al gruppo selezionato non sia già stato assegnato un elaborato<br />10.2 Il sistema verifica che la lista delle tracce non sia vuota<br/>10.3 Il sistema chiede di scegliere una tra le tracce disponibili |
| 11.1 Il docente o il tutor sceglie la traccia                           |                                                                                                                                                                                                                                         |
|                                                                         | 12.1 Il sistema comunica il buon esito dell'operazione                                                                                                                                                                                  |

###### Scenario alternativo A1 - La lista dei gruppi è vuota

| Docente o tutor | Sistema                                                                                                      |
| --------------- | ------------------------------------------------------------------------------------------------------------ |
|                 | A1.6.1 Il sistema comunica che la lista dei gruppi è vuota, in quanto non è stato ancora creato alcun gruppo |

###### Scenario alternativo A2 - Al gruppo è già stato assegnato un elaborato

| Docente o tutor | Sistema                                                                                  |
| --------------- | ---------------------------------------------------------------------------------------- |
|                 | A1.10.2 Il sistema comunica che al gruppo selezionato è già stato assegnato un elaborato |

###### Scenario alternativo A3 - Al gruppo è già stato assegnato un elaborato

| Docente o tutor | Sistema                                                       |
| --------------- | ------------------------------------------------------------- |
|                 | A1.10.3 Il sistema comunica che la lista delle tracce è vuota |

---

##### UC.4 - Aggiunta di un nuovo incontro con un gruppo

| Nome del caso d'uso | Aggiunta di un nuovo incontro con un gruppo                                                          |
| ------------------- | ---------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che il docente o un tutor deve eseguire per poter inserire un nuovo incontro in agenda |
| **Precondizione**   |                                                                                                      |
| **Postcondizione**  | Viene inserito un nuovo incontro in agenda                                                           |

###### Scenario principale

| Docente o tutor                                                                       | Sistema                                                                                                                                                       |
| ------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1.1 Il docente o il tutor chiede di accedere al sistema                               |                                                                                                                                                               |
|                                                                                       | 2.1 Il sistema chiede le credenziali di accesso                                                                                                               |
| 3.1 Il docente o il tutor comunica il suo username e la password                      |                                                                                                                                                               |
|                                                                                       | 4.1 Il sistema autentica il docente o il tutor                                                                                                                |
| 5.1 Il docente o il tutor chiede di visualizzare l'agenda degli incontri con i gruppi |                                                                                                                                                               |
|                                                                                       | 6.1 Il sistema mostra l'agenda                                                                                                                                |
| 7.1 Il docente o il tutor chiede di inserire un nuovo incontro                        |                                                                                                                                                               |
|                                                                                       | 8.1 Il sistema chiede di selezionare la data e l'ora dell'incontro                                                                                            |
| 9.1 Il docente o il tutor inserisce la data e l'ora dell'incontro                     |                                                                                                                                                               |
|                                                                                       | 10.1 Il sistema chiede di selezionare il gruppo interessato all'incontro                                                                                      |
| 11.1 Il docente o il tutor seleziona il gruppo                                        |                                                                                                                                                               |
|                                                                                       | 12.1 Il sistema controlla che il gruppo inserito non abbia superato il limite massimo di incontri<br />12.2 Il sistema comunica il buon esito dell'operazione |

---

###### Scenario alternativo A1 - Il gruppo inserito ha già usufruito di tutti gli incontri disponibili

| Docente o tutor | Sistema                                                                                                                                                      |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|                 | A1.12.3 Il sistema comunica che il gruppo selezionato ha già usufruito di tutti gli incontri disponibili<br />Ritorno allo scenario principale al punto 10.1 |

---

##### UC5 - Registrazione dello stato di avanzamento di un gruppo

| Nome del caso d'uso | Registrazione dello stato di avanzamento di un gruppo                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che un docente o un tutor deve eseguire per poter registrare lo stato di avanzamento di un gruppo nella realizzazione del proprio elaborato. |
| **Precondizione**   | Il gruppo deve aver usufruito di almeno un incontro con il docente o un tutor                                                                              |
| **Postcondizione**  | Viene registrato lo stato di avanzamento di un gruppo                                                                                                      |

---

###### Scenario principale

| Docente o tutor                                                                                                                                                                   | Sistema                                                                                                                                                        |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1.1 Il docente o il tutor chiede di accedere al sistema                                                                                                                           |                                                                                                                                                                |
|                                                                                                                                                                                   | 2.1 Il sistema chiede le credenziali di accesso                                                                                                                |
| 3.1 Il docente o il tutor comunica il suo username e la password                                                                                                                  |                                                                                                                                                                |
|                                                                                                                                                                                   | 4.1 Il sistema autentica il docente o il tutor                                                                                                                 |
| 5.1 Il docente o il tutor chiede la lista dei gruppi di studenti                                                                                                                  |                                                                                                                                                                |
|                                                                                                                                                                                   | 6.1 Il sistema mostra la lista dei gruppi di studenti                                                                                                          |
| 7.1 Il docente o il tutor seleziona un gruppo                                                                                                                                     |                                                                                                                                                                |
|                                                                                                                                                                                   | 8.1 Il sistema controlla che al gruppo selezionato sia già stato assegnato un elaborato                                                                        |
| 9.1 Il docente o il tutor chiede di registrare lo stato di avanzamento del gruppo nella realizzazione dell'elaborato                                                              |                                                                                                                                                                |
|                                                                                                                                                                                   | 10.1 Il sistema controlla che il gruppo abbia usufruito di almeno un incontro con il docente o il tutor<br />10.2 Il sistema chiede a quale incontro riferirsi |
| 11.1 Il docente o il tutor seleziona l'incontro a cui riferirsi per la registrazione dello stato di avanzamento<br />11.2 Il docente o il tutor inserisce lo stato di avanzamento |                                                                                                                                                                |
|                                                                                                                                                                                   | 12.1 Il sistema comunica il buon esito dell'operazione                                                                                                         |

###### Scenario alternativo A1 - La lista dei gruppi è vuota

| Docente o tutor | Sistema                                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------------------- |
|                 | A1.6.1 l sistema comunica che la lista dei gruppi è vuota, in quanto non è stato ancora creato alcun gruppo |

###### Scenario alternativo A2 - Al gruppo selezionato non è stato ancora assegnato alcun elaborato

| Docente o tutor | Sistema                                                                                                                                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A2.8.1 Il sistema comunica al gruppo selezionato non è stato ancora assegnato alcun elaborato; non è quindi possibile registrare lo stato di avanzamento<br />Ritorno allo scenario principale al punto 6.1 |

###### Scenario alternativo A3 - Il gruppo selezionato non ha ancora usufruito di alcun incontro

| Docento o tutor | Sistema                                                                                                                                                                      |
| --------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A3.10.2 Il sistema comunica che il gruppo selezionato non ha ancora usufruito di alcun incontro con il docente o il tutor<br />Ritorno allo scenario principale al punto 6.1 |

---

![usecase][usecase]

---

## 2 Design dell' Architettura sw

Per la realizzazione del progetto si è scelto di usare un'architettura MVC, in quanto questo tipo di architettura è indicata per applicazioni con interazione con gli utenti. Il sistema è suddiviso in tre componenti principali, ognuna delle quali gestisce in modo indipendente input, elaborazioni e output. In questo modo vengono disaccoppiaei le varie parti del sistema, in modo da rendere più semplice la realizzazione e la manutenzione dell'intero sistema. 

---

## 3 Progetto delle interfacce

Per la realizzazione delle interfacce è stata usata la librearia grafica `swing`. 

### Login view

![login][login]

### Students view

![students][students]

### Groups view

![groups][groups]

---

### Agenda view

![agenda][agenda]

---

## 4 Design dei sottosistemi

Il sistema è stato diviso in quattro sottosistemi principali:
- `controllers`
- `model`
- `repository`
- `views`

### 4.1 - controllers

![controllers][controllers]

La creazione dei controllers del sistema viene gestita tramite un'*Abstract Factory*. In particolare sono presenti quattro *"prodotti"*; `AgendaController`, `GroupsController`, `LoginController` e `StudentsController`. Allo stato attuale è presente un'unica famiglia di prodotti contenuta nel *sub-package* `concrete`.
Inoltre è presenta la classe astratta `Application` che coordina il lavoro dei vari controller. La classe fornisce tre factory method:
- `makeModel()` permette di scegliere quale model usare. È un metodo concreto.
- `makeControllerFactory()` permette di scegliere quale `ControllersFactory` usare. È un metodo concreto.
- `makeViewFactory()` permettere di scegliere quale `ViewsFactory` usare. È un metodo astratto per cui deve essere implementato prima di poter utilizzare la classe.

---

### 4.2 - Model

![model][model]

Nel paackage `model` sono racchiuse tutte le classi specifiche del dominio applicativo.
Per facilitare l'accesso a questo sotto sistema si è utilizzato il pattern *Facade*. L'interfaccia `Model` permette di disaccoppiare quest'ultima dalla sua implementazione. L'implementazione è contenuta nella classe astratta `ConcreteModel` che espone il metodo astratto `makeRepository()` che permette di disaccoppiare il modello dal gestore per la persistenza dei dati.
Allo stato attuale non ci sarebbe bisogno di avere classi separate per i tutor e i professori in quanto hanno eguali responsabilità, ma si è optato per delle classi separate per consentire una maggiore flessibilità ad eventuali modifiche future. Per fare ciò si è definita una `sealed class User` che viene estesa in due sottoclassi `Tutor` e `Professor`. Si è scelto di usare una `sealed class` invece di una classe astratta per aver maggiore controllo sulle sottoclassi.

---

### 4.3 - Repository

![repository][repository]

Nel modulo `repository` sono contenute tutte le classi che consentono di gestire la persistenza dei dati.
La classe astratta `Repository` si occupa di gestire tutte le richieste di accesso e modifica dei dati. Inoltre fornisce due metodi astratti:
- `makeDaoFactory()` che si comporta da *factory method* per la creazione dell'*abstract factory* dei *dao*.
- `prepareCourseStatament()` che permette di generare la query in grado di ricavare il corso dato il docente.
Per la gestione dei dato si è optato per un *abstract factory*. Tutti i prodotti implementano la classe generica `Dao<T, ID>`. In particolare è possibile distinguere otto prodotti concreti.
All'interno del sub-package `sqlite` è contenuta la famiglia dei dao per un database *sqlite* e la concrete factory ad essi associata. Inoltre è presente il *singleton* `Connection` che fornisce un punto di accesso globale alla connessione con il database, in questo modo si evita che ogni singolo dao debba gestire autonomamente la connessione.
Sempre nel package `repository` è contenuta la classe `MeetingHelpper` usata per semplificare le operazioni di lettura e scrittura di un oggetto di tipo `Meeting`.

---

### 4.4 - Views

![views][views]

Le package `views` sono contenute le view.
Per la creazione dei form per la comunicazione con gli utenti si è scelto di usare ancora una volta un'*abstract factory*. In questo caso i prodotti sono quattro, uno per ogni schermata.
Nel sub-package `swing` è contenuta l'implementazione delle *views* con la libreria grafica *swing*. Oltre ai prodotti concreti nel package `swing` è contenuto il *singleton* `Frame` che fornisce alle varie *views* il frame. Inoltre mette a disposizione anche un gestore dei messaggi centralizzato.

Di seguito è riportato un DCD completo del sistema e alcuni sequence e activity diagram.

![dcd][dcd]

![sd1][sd1]

![sd2][sd2]

![sd3][sd3]

---

## 5. Progetto del Database

Il database è stato progettato in `sqlite`.

### Account

```sqlite
create table account
(
	id int not null
		primary key
		references user,
	password int not null
);
```

### Course

```sqlite
create table course
(
	name varchar(50) not null,
	year int not null,
	primary key (name, year)
);
```

### Group

```sqlite
create table "group"
(
	name varchar(50) not null,
	course_name varchar(50),
	course_year int,
	work_track int,
	primary key name,
	foreign key (course_name, course_year) references course
);
```

### Meeting

```sqlite
create table meeting
(
	owner int not null
		references user,
	"group" varchar(50) not null
		references "group" (name),
	id int not null,
	start date not null,
	end date not null,
	primary key ("group", id)
);
```

### Review

```sqlite
create table review
(
	"group" varchar(50)
		references "group",
	id int,
	title varchar(50) not null,
	body varchar(1000) not null,
	type varchar(10) not null,
	rating int,
	primary key ("group", id),
	foreign key ("group", id) references meeting,
	check (type in ("standard", "final"))
);
```

### Student

```sqlite
create table student
(
	id int not null
		primary key,
	name varchar(50) not null,
	surname varchar(50) not null,
	"group" varchar(50),
	course_name varchar(50),
	course_year int,
	foreign key ("group", course_name, course_year) references "group",
	foreign key (course_name, course_year) references course
);
```

### User

```sqlite
create table user
(
	id int not null
		primary key,
	name varchar(50) not null,
	surname varchar(50) not null,
	email varchar(100) not null,
	type varchar(10) not null,
	course_name varchar(50),
	course_year int,
	foreign key (course_name, course_year) references course
);
```

---

### WorkTrack

```sqlite
create table workTrack
(
	id int not null,
	title varchar(50) not null,
	body varchar(1000) not null,
	course_name varchar(50) not null,
	course_year int not null,
	primary key (id, course_name, course_year),
	foreign key (course_name, course_year) references course
);
```

Di seguito è riportato lo schema completo del database.

![database][database]

---

## 6 - Testing

### Login

#### Classi di equivalenza

| Condizione | Valide                     | Non valide                                          |
| ---------- | -------------------------- | --------------------------------------------------- |
| Username   | - $CE_1$ username presente | - $CE_2$ campo vuoto<br />- $CE_3$ username assente |
| Password   | - $CE_4$ password corretta | - $CE_5$ campo vuoto<br />- $CE_6$ password errata  |

#### Test case

| Test case | Username | Password | Classi coperte          |
| --------- | -------- | -------- | ----------------------- |
| $TC_1$    | 200      | 1234     | - $CE_1$ <br />- $CE_4$ |
| $TC_2$    | 200      | `vuoto`  | - $CE_1$<br />- $CE_5$  |
| $TC_3$    | 200      | error    | - $CE_1$<br />- $CE_6$  |
| $TC_4$    | `vuoto`  | 1234     | - $CE_2$<br />- $CE_4$  |
| $TC_5$    | 300      | 1234     | - $CE_3$<br />- $CE_4$  |

---

### Aggiunta studente

#### Classi di equivalenza

| Condizione | Valide                          | Non valide                                            |
| ---------- | ------------------------------- | ----------------------------------------------------- |
| Matricola  | - $CE_1$ matricola non presente | - $CE_2$ campo vuoto<br />- $CE_3$ matricola presente |
| Nome       | - $CE_4$ nome inserito          | - $CE_5$ campo vuoto                                  |
| Cognome    | - $CE_6$ cognome inserito       | - $CE_7$ campo vuoto                                  |

#### Test case

| Test case | Matricola | Nome    | Cognome  | Classi coperte                       |
| --------- | --------- | ------- | -------- | ------------------------------------ |
| $TC_1$    | 620111    | Nome1   | Cognome1 | - $CE_1$<br />- $CE_4$<br />- $CE_6$ |
| $TC_2$    | `vuoto`   | Nome1   | Cognome1 | - $CE_2$<br />- $CE_4$<br />- $CE_6$ |
| $TC_3$    | 620001    | Nome1   | Cognome1 | - $CE_3$<br />- $CE_4$<br />- $CE_6$ |
| $TC_4$    | 620111    | `vuoto` | Cognome1 | - $CE_1$<br />- $CE_5$<br />- $CE_6$ |
| $TC_5$    | 620111    | Nome1   | `vuoto`  | - $CE_1$<br />- $CE_4$<br />- $CE_7$ |

---

### Agiunta gruppo

#### Classi di equivalenza

| Condizione         | Valide                     | Non valide                                                   |
| ------------------ | -------------------------- | ------------------------------------------------------------ |
| Nome gruppo        | - $CE_1$ nome non presente | - $CE_2$ campo vuoto<br />- $CE_3$ nome presente             |
| Selezione studenti | - $CE_4$ tutti liberi      | - $CE_5$ nessuna selezione<br />- $CE_6$ almeno uno impegnato |
|                    |                            |                                                              |

#### Test case

| Test case | Nome gruppo | Selezione Studenti   | Classi coperte         |
| --------- | ----------- | -------------------- | ---------------------- |
| $TC_1$    | Gruppo_1000 | tutti liberi         | - $CE_1$<br />- $CE_4$ |
| $TC_2$    | Gruppo_1000 | nessuna selezione    | - $CE_1$<br />- $CE_5$ |
| $TC_3$    | Gruppo_1000 | almeno uno impegnato | - $CE_1$<br />- $CE_6$ |
| $TC_4$    | `vuoto`     | tutti liberi         | - $CE_4$<br />- $CE_2$ |
| $TC_5$    | Gruppo1     | tutti liberi         | - $CE_4$<br />- $CE_3$ |

---

### Aggiunta work track

#### Classi di equivalenza

| Condizione | Valide                   | Non valide           |
| ---------- | ------------------------ | -------------------- |
| Titolo     | - $CE_1$ titolo inserito | - $CE_2$ campo vuoto |
| Body       | - $CE_3$ body inserito   | - $CE_4$ campo vuoto |
|            |                          |                      |

#### Test case

| Test case | Titolo  | Body    | Classi coperte         |
| --------- | ------- | ------- | ---------------------- |
| $TC_1$    | Title   | Body    | - $CE_1$<br />- $CE_3$ |
| $TC_2$    | `vuoto` | Body    | - $CE_2$<br />- $CE_3$ |
| $TC_3$    | Title   | `vuoto` | - $CE_1$<br />- $CE_4$ |

---

### Assegnazione work track

| Condizione           | Valide                         | Non valide                                                   |
| -------------------- | ------------------------------ | ------------------------------------------------------------ |
| Selezione gruppo     | - $CE_1$ solo un gruppo libero | - $CE_2$ selezione vuota<br />- $CE_3$ selezione multipla<br />- $CE_4$ gruppo impegnato |
| Selezione work track | - $CE_5$ solo una work track   | - $CE_6$ selezione vuota<br />- $CE_7$ selezione multipla    |
|                      |                                |                                                              |

#### Test case

| Test case | Selezione gruppo      | Selezione work track | Classi coperte         |
| --------- | --------------------- | -------------------- | ---------------------- |
| $TC_1$    | un solo gruppo libero | una sola work track  | - $CE_1$<br />- $CE_5$ |
| $TC_2$    | un solo gruppo libero | selezione vuota      | - $CE_1$<br />- $CE_6$ |
| $TC_3$    | un solo gruppo libero | selezione multipla   | - $CE_1$<br />- $CE_7$ |
| $TC_4$    | selezione vuota       | una sola work track  | - $CE_5$<br />- $CE_2$ |
| $TC_5$    | selezione multipla    | una sola work track  | - $CE_5$<br />- $CE_3$ |
| $TC_6$    | gruppo impegnato      | una sola work track  | - $CE_5$<br />- $CE_4$ |

---

### Aggiunta meeting

#### Classi di equivalenza

| Condizione | Valide                                               | Non valide                                                   |
| ---------- | ---------------------------------------------------- | ------------------------------------------------------------ |
| Gruppo     | - $CE_1$ gruppo con work track con meno di 5 meeting | - $CE_2$ gruppo senza work track<br />- $CE_3$ gruppo con gia 5 meeting |
| Data       | - $CE_4$ formato valido                              | - $CE_5$ formato non valido                                  |
|            |                                                      |                                                              |

#### Test case

| Test case | Gruppo                                    | Data               | Classi coperte         |
| --------- | ----------------------------------------- | ------------------ | ---------------------- |
| $TC_1$    | gruppo con work track e meno di 5 meeting | formato valido     | - $CE_1$<br />- $CE_4$ |
| $TC_2$    | gruppo con work track e meno di 5 meeting | formato non valido | - $CE_1$<br />- $CE_5$ |
| $TC_3$    | gruppo senza work track                   | formato valido     | - $CE_4$<br />- $CE_2$ |
| $TC_4$    | gruppo con già 5 meeting                  | formato valido     | - $CE_4$<br />- $CE_3$ |

---

### Aggiunta Review

#### Classi di equivalenza

| Condizione | Valide                                                       | Non valide                                                   |
| ---------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Meeting    | - $CE_1$ meeting senza review                                | - $CE_2$ selezione vuota<br />- $CE_3$ selezione multipla<br />- $CE_4$ meeting con review |
| Title      | - $CE_5$ campo non vuoto                                     | - $CE_6$ campo vuoto                                         |
| Body       | - $CE_7$ campo non vuoto                                     | - $CE_8$ campo vuoto                                         |
| Rating     | - $CE_9$ numero compreso tra 1 e 30<br />- $CE_{13}$ campo vuoto | - $CE_{10}$ nan<br />- $CE_{11}$ < 1<br />- $CE_{12}$ > 30   |

#### Test case

| Test case | Meeting              | Title   | Body    | Rating  | Classi coperte                                        |
| --------- | -------------------- | ------- | ------- | ------- | ----------------------------------------------------- |
| $TC_1$    | meeting senza review | Title   | Body    | `vuoto` | - $CE_1$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{13}$ |
| $TC_1$    | meeting senza review | Title   | Body    | 18      | - $CE_1$<br />- $CE_5$<br />- $CE_7$<br />- $CE_9$    |
| $TC_3$    | meeting senza review | `vuoto` | Body    | 30      | - $CE_1$<br />- $CE_6$<br />- $CE_7$<br />- $CE_9$    |
| $TC_4$    | meeting senza review | Title   | `vuoto` | 1       | - $CE_1$<br />- $CE_ 5$<br />- $CE_8$<br />- $CE_9$   |
| $TC_5$    | meeting senza review | Title   | Body    | nan     | - $CE_1$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{10}$ |
| $TC_6$    | meeting senza review | Title   | Body    | 0       | - $CE_1$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{11}$ |
| $TC_7$    | meeting senza review | Title   | Body    | 31      | - $CE_1$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{12}$ |
| $TC_8$    | `vuota`              | Title   | Body    | `vuoto` | - $CE_2$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{13}$ |
| $TC_9$    | multipla             | Title   | Body    | `vuoto` | - $CE_3$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{13}$ |
| $TC_{10}$ | meeting con review   | Title   | Body    | `vuoto` | - $CE_4$<br />- $CE_5$<br />- $CE_7$<br />- $CE_{13}$ |
| $TC_{11}$ | meeting senza review | `vuoto` | Body    | `vuoto` | - $CE_1$<br />- $CE_6$<br />- $CE_7$<br />- $CE_{13}$ |
| $TC_{12}$ | meeting senza review | Title   | `vuoto` | `vuoto` | - $CE_1$<br />- $CE_5$<br />- $CE_8$<br />- $CE_{13}$ |



[model]: img/model.png
[repository]: img/repository.png
[views]: img/views.png
[controllers]: img/controllers.png
[database]: img/database.png
[dcd]: img/dcd.png
[usecase]: img/usecase.png
[sd1]: img/sd1.png
[sd2]: img/sd2.png
[sd3]: img/sd3.png
[login]: img/login.png
[students]: img/students.png
[groups]: img/groups.png
[agenda]: img/agenda.png
[logo]: img/logo.png
