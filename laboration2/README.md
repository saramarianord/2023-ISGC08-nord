# Exempel dokumentation Skier exemplet


# Gruppmedlemmar

| Namn | Roll        
| ------------- |-------------
| Sara Nord   | Utvecklare 
| Sara Remmelg    |  Utvecklare, Repo admin     
    



## Kravspecifikation och beskrivning av projektet
Laborationen går ut på att bygga en komplett texteditor med ett grafiskt användargränssnitt i Java användande Swing.
följande features ska implementeras:

1. Kompletta textredigeringsmöjligheter: skriva in text, klippa ut, klistra in och kopiera.
2. Lagring kan ske i valfritt format men ska lagras till fil.
3. File (Arkivmenyn) 
    - Open
    - New
    - Save
    - Save As samt
    - Exit


# Design krav

- koden ska följa MVC-strukturen med definierade gränssnitt.
- Lagring ska ske i vanliga textfiler (unicode)
- UML modellen ska innehålla diagram för både analys och diagram för design, markera varje diagram med ett förklarande namn samt om det hör till analys eller design. UML diagramtyper som ska användas:
    - Use-case diagram
    - klassdiagram (alla attribut med datatyp, metoder med signaturer samt alla relationsattribut) 
    - sekvensdiagram som illusterar gränssnittet mellan ingående objekt och MVC-skikt.

# Resultat från Analys
## Use case diagram
![use_case.png.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/use_case.png)
## Sekvensdiagram för Analys


### Start Sekvens (Analys)
![start_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/start_sekvens_analys.png)

### Open Sekvens (Analys)
![open_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/open_sekvens_analys.png)

### Exit Sekvens (Analys
![exit_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/exit_sekvens_analys.png)

### New Sekvens (Analys)
![newFile_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/newFile_sekvens_analys.png)

### Save Sekvens (Analys)
![save_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/save_sekvens_analys.png)

### SaveAs Sekvens (Analys)
![saveAs_sekvens_analys.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/saveAs_sekvens_analys.png)

# Resultat från Design

## Klassdiagram (Design)
![klassdiagram.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/klassdiagram.png)

## Sekvensdiagram för Design


### Start Sekvens (Design)
![start_sekvens_design.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/start_sekvens_design.png)

### Open Sekvens (Design)
![open_sekvens_design.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/open_sekvens_design.png)

### Exit Sekvens (Design)
![exit_sekvens_design.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/exit_sekvens_design.png)

### New Sekvens (Design)
![newFile_sekvens_design.png
](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/newFile_sekvens_design.png)

### Save Sekvens (Design)
![save_sekvens_design.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/save_sekvens_design.png)

### SaveAs Sekvens (Design)
![saveAs_sekvens_design.png](https://github.com/sararemmelg/2023-isgc08-remmelg/blob/42ea71d49904bcfd328505ba6bdce86a314bd78b/images/saveAs_sekvens_design.png)
