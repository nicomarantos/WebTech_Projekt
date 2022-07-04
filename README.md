[![CI](https://github.com/nicomarantos/WebTech_Projekt/actions/workflows/tests.yml/badge.svg)](https://github.com/nicomarantos/WebTech_Projekt/actions/workflows/tests.yml)

# Plantastic!

## Project setup
```
Die Web-Anwendung Plantastic bietet den Nutzer*innen eine Platform,
in welcher sie ihre Pflanzen einspeichern und andere Pflanzen ansehen können.
Die Anwendung ist in 3 Kategorien aufgeteilt, namentlich die Home-Page,
Der Plant Calendar und das Plant Lexicon.
Bis auf die Home-Page bieten sie verschiedene Funktionalitäten, um den 
Nutzer*innen, den Umgang mit ihren Pflanzen zu erleichtern.
Die Funktionalitäten werden separat erklärt.
```

### Plant Calendar
```
Der Plant Calendar bietet die Möglichkeit seine in einer Wateringchecklist
gespeicherten Pflanzen zu sehen. Diese wird genutzt um de Nutzer der App daran zu erinnern
wann er seine Pflanze giesen muss.
"Days until plant needs to be watered again" zeigt an, wann die Pflanze,
anhand der vorher eingestellten, oder selbst gewählten (bei selbst custom erstellten Pflanzen), Zeit in Tagen wieder
gegossen werden sollte.
Der Countdown reduziert sich pro Tag um eins. Und wird resetet wenn man "watered" Button drückt.
Die Pflanzen können auch aus der Wateringchecklist wieder entfernt werden, durch den
roten Button an der Seite.
Des Weiteren können die gespeicherten Pflanzen nach alphabetischer Reihenfolge oder
nach der Zeit, wann sie gegossen werden sollen, sortiert werden.
Der Timer wird durch reload der Home View aktualisiert.
```

### Plant lexicon
```
Das Plant Lexicon zeigt den Nutzer*innen, die in der Datenbank verfügbaren Pflanzen an.
Angezeigt wird der umgangssprachliche Name, der lateinische Name, eine kurze Beschreibung,
ein Bild und ob die Pflanze schon in der Wateringchecklist gespeichert wurde.
Es befindet sich ein Button am Ende der Card, namens "add to Wateringchecklist", wodurch die
Pflanze im Plant Calendar abgespeichert wird.
Jede Pflanze besitzt eine voreingestellte "Watering period"n nach der der Timer im Kalender
gestellt wird.
Zudem existieren oben rechts zwei weiter Buttons, mit denen eine Custom Pflanze erstellt oder
gelöscht werden kann.
Beim erstellen der Custom Pflanze müssen umgangssprachlicher Name, lateinischer Name,
eine kurze Beschreibung (bis zu 3 Sätze) und die Watering period angegeben werden.
Wenn man eine der Pflanzen aus dem System löschen möchte, so muss man auf den Button drücken und nur den
umgangssprachlichen Namen eingeben.
```
