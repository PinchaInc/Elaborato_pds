## Use Cases

### UC.1 - Inserimento di un nuovo studente

| Nome del caso d'uso | Inserimento di un nuovo studente                                                           |
| ------------------- | ------------------------------------------------------------------------------------------ |
| **Descrizione**     | È il processo che il docente o un tutor deve compiere per poter inserire un nuovo studente |
| **Precondizione**   | Il docente o il tutor è in possesso di un account abilitato                                |
| **Postcondizione**  | La lista degli studenti registrati viene ampliata con un nuovo studente                    |

#### Scenario principale

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

#### Scenario alternativo A1 - Dati di accesso non corretti

| Docente o tutor | Sistema                                                                                                                                 |
| --------------- | --------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A1.4.1 Il sistema comunica al docente o al tutor che i dati inseriti non sono validi<br />Ritorno allo scenario principale al punto 2.1 |

#### Scenario alternativo A2 - Lo studente è stato già registrato

| Docente o tutor | Sistema                                                                                                                                                             |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A2.10.2 Il sistema avvisa il docente o il tutor che i dati inseriti corrispondono ad uno studente già registrato<br />Ritorno allo scenario principale al punto 8.1 |

### UC.2 - Creazione di un nuovo gruppo

| Nome del caso d'uso | Creazione di un nuovo gruppo                                                                 |
| ------------------- | -------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che un docente o un tutor deve eseguire per creare un nuovo gruppo di studenti |
| **Precondizione**   |                                                                                              |
| **Postcondizione**  |                                                                                              |

#### Scenario principale

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

#### Scenario alternativo A1 - Uno o più studenti selezionati fa già parte di un gruppo

| Docente o tutor | Sistema                                                                                                                                                    |
| --------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A1.10.1 Il sistema comunica che uno o più studenti selezionati fanno già parte di un gruppo e li mostra<br />Ritorno allo scenario principale al punto 8.1 |

#### Scenario alternativo A2 - Il nome del gruppo non è univoco

| Docente o tutor | Sistema                                                                                                                                                            |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|                 | A2.10.3 Il sistema comunica che il nome inserito è già stato scelto come nome di un gruppo creato in precedenza<br />Ritorno allo scenario principale al punto 8.1 |

### UC.3 - Assegnamento di un elaborato ad un gruppo

| Nome del caso d'uso | Assegnamento di un elaborato ad un gruppo                                                                              |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che il docente o un tutor deve effettuare per assegnare un elaborato ad un gruppo precedentemente creato |
| **Precondizione**   |                                                                                                                        |
| **Postcondizione**  | Al gruppo scelto viene assegnato un elaborato                                                                          |

#### Scenario principale

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

#### Scenario alternativo A1 - La lista dei gruppi è vuota

| Docente o tutor | Sistema                                                                                                      |
| --------------- | ------------------------------------------------------------------------------------------------------------ |
|                 | A1.6.1 Il sistema comunica che la lista dei gruppi è vuota, in quanto non è stato ancora creato alcun gruppo |

#### Scenario alternativo A2 - Al gruppo è già stato assegnato un elaborato

| Docente o tutor | Sistema                                                                                  |
| --------------- | ---------------------------------------------------------------------------------------- |
|                 | A1.10.2 Il sistema comunica che al gruppo selezionato è già stato assegnato un elaborato |

#### Scenario alternativo A3 - Al gruppo è già stato assegnato un elaborato

| Docente o tutor | Sistema                                                       |
| --------------- | ------------------------------------------------------------- |
|                 | A1.10.3 Il sistema comunica che la lista delle tracce è vuota |

### UC.4 - Aggiunta di un nuovo incontro con un gruppo

| Nome del caso d'uso | Aggiunta di un nuovo incontro con un gruppo                                                          |
| ------------------- | ---------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che il docente o un tutor deve eseguire per poter inserire un nuovo incontro in agenda |
| **Precondizione**   |                                                                                                      |
| **Postcondizione**  | Viene inserito un nuovo incontro in agenda                                                           |

#### Scenario principale

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

#### Scenario alternativo A1 - Il gruppo inserito ha già usufruito di tutti gli incontri disponibili

| Docente o tutor | Sistema                                                                                                                                                      |
| --------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
|                 | A1.12.3 Il sistema comunica che il gruppo selezionato ha già usufruito di tutti gli incontri disponibili<br />Ritorno allo scenario principale al punto 10.1 |

### UC5 - Registrazione dello stato di avanzamento di un gruppo

| Nome del caso d'uso | Registrazione dello stato di avanzamento di un gruppo                                                                                                      |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrizione**     | È il processo che un docente o un tutor deve eseguire per poter registrare lo stato di avanzamento di un gruppo nella realizzazione del proprio elaborato. |
| **Precondizione**   | Il gruppo deve aver usufruito di almeno un incontro con il docente o un tutor                                                                              |
| **Postcondizione**  | Viene registrato lo stato di avanzamento di un gruppo                                                                                                      |

#### Scenario principale

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

#### Scenario alternativo A1 - La lista dei gruppi è vuota

| Docente o tutor | Sistema                                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------------------- |
|                 | A1.6.1 l sistema comunica che la lista dei gruppi è vuota, in quanto non è stato ancora creato alcun gruppo |

#### Scenario alternativo A2 - Al gruppo selezionato non è stato ancora assegnato alcun elaborato

| Docente o tutor | Sistema                                                                                                                                                                                                     |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A2.8.1 Il sistema comunica al gruppo selezionato non è stato ancora assegnato alcun elaborato; non è quindi possibile registrare lo stato di avanzamento<br />Ritorno allo scenario principale al punto 6.1 |

#### Scenario alternativo A3 - Il gruppo selezionato non ha ancora usufruito di alcun incontro

| Docento o tutor | Sistema                                                                                                                                                                      |
| --------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|                 | A3.10.2 Il sistema comunica che il gruppo selezionato non ha ancora usufruito di alcun incontro con il docente o il tutor<br />Ritorno allo scenario principale al punto 6.1 |
