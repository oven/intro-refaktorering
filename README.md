# Refaktorering og kodekvalitet

Det begynner så fint, men før du aner det slutter koden din å være lett å jobbe med. Mange små endringer både i kode og forretningslogikk 
gjør at koden blir tidkrevende og kompleks å jobbe med og frustrasjonen øker. Derfor er det viktig å vedlikeholde koden og 
gjøre rent etter seg, altså refaktorere (eller refaktorisere). 

Presentasjonen til denne workshopen finner du i [presentasjon](presentasjon). 

## Hva skal vi fokusere på i denne workshopen?

Du skal jobbe sammen med minst en annen om å forbedre kode. Dere har lært de mest vanlige problemene vi ser i kode og hvordan dere kan fikse dem. 
Dagens oppgave er et sett med tester og kode som trenger forbedring. Funksjonelt er testene bra og dekker de fleste mulige refaktoreringer, selv om det
finnes tilfeller der dere må endre testene også. Hovedfokuset i denne workshopen er å forbedre produksjonskoden. 

Læringsutbytte: 
- identifisere problemer i kode
- forstå funksjonalitet utfra tester
- refaktorere med tester
- diskutere design
- samarbeide om design og implementasjon


## Hva trenger du? 
- IntelliJ
- Java 11
- Git

Klon repositoriet ned på maskinen din. Om dere skal parprogrammere ved å dele kode mellom dere kan det være en fordel å forke i stedet for å klone. 


# Dagens oppgave

Jobb sammen i grupper på 2 eller 3 personer. Gå gjennom Pub.java i no.kantega. Hvilke problemer identifiserer dere? Det 
ligger en liten testsuite (PubPricesTest.java) som dekker funksjonaliteten som finnes. Selv om det er rom for forbedringer 
feks på navngiving i testene, er det Pub.java dere skal konsentrere dere mest om i denne workshopen. Det finnes også varianter 
av refaktorering som vil kreve nye tester, i så fall skriver dere dem.  

## Hvordan starte

:pencil2: Åpne prosjektet i IntelliJ ved å velge *Open* fra File-menyen, og klikke på intro-refaktoreringsmappen

:pencil2: Kjør alle testene, gå gjennom både testene og koden

:question: Hva gjør koden? Diskuter mellom dere slik at dere har samme forståelse av hva koden gjør

:question: Hvilke problemer finner dere? Navngiving? Kommentarer? Magiske tall? Struktur-problemer? 

:pencil2: Fiks alle de magiske tallene

:pencil2: Forbedre navngiving på variabler og funksjoner som finnes slik at navnene reflekterer hva innholdet er

:pencil2: Fjern kommentarer som ikke er nødvendige

:pencil2: Lag funksjoner for uavhengige deler av koden som kan stå for seg selv

Det er mange måter å refaktorere denne koden på, og selv om vi viser en variant til slutt betyr ikke det at andre måter å løse 
dette problemet på er feil. Diskuter design og hvilke ideer dere har for å løse de problemene dere ser. Trenger dere 
flere klasser, hva gjør de ulike klassene? Hvor er det tilstrekkelig med enkle grep, og hvor trengs større inngrep for å forbedre koden? 
Hva er sannsynlige utvidelser av koden, og hvordan kan koden støtte dette på best mulig måte?

Lykke til! 


## Litt tips
Noen tips til hvordan IntelliJ fungerer hvis du ikke har brukt det noe særlig: 
- [IntelliJ video tutorials](https://www.jetbrains.com/idea/documentation/)
- [IntelliJ testing](https://www.jetbrains.com/help/idea/2016.3/testing.html)


## Kort liste over vanlige kodeproblemer 

* Duplisert kode:

Det går bra å kopiere kode. Som oftest. Men det gir flere steder samme feil kan opptre, og forvirrende oppførsel når en feil du 
har rettet ikke er rettet likevel fordi koden finnes flere steder. Samle kode som bør være samlet og overhold Single Responsibility Principle. 
Relevante refaktoreringsmetoder: 

    * Extract method
    * Exctract class
    * Pull up method
    * Form template method

* Lang metode: 

Metoder vokser over tid. Men når er det for lang? Du kan bruke rene linjeantall, men antall eksekveringsstier eller voksende 
antall innrykk også. Del metoden opp i mindre metoder, der hver metode har et ansvarsområde på riktig abstraksjonsnivå. Kanskje du også 
må dele opp i klasser? Relevante refaktoreringsmetoder:

	* Extract method.
	* Replace temp with query.
	* Replace method with method object.
	* Decompose conditional.

* Lange parameter-lister til funksjoner eller klasser: 


	* Replace parameter with method.
	* Introduce parameter object.
	* Preserve whole object.

* Store klasser/klumper med data/divergerende endringer: 

Dataklumper (data clumps) er en type duplisering der samme eller lignende gruppe av felter finnes i flere klasser. Lag en klasse med 
nødvendige metoder som kan brukes i de ulike klassene. Relevante refaktoreringsmetoder:

	* Extract class.
	* Extract subclass.
	* Extract interface.
	* Replace data value with object.
	* Introduce parameter object.
	* Preserve whole object.

* Dataklasser: 

Inneholder mange felter men ingen funksjonalitet. Se etter kode andre steder som naturlig skulle hørt hjemme med datafeltene. 
Relevante refaktoreringsmetoder:

	* Move method.
	* Encapsulate field.
	* Encapsulate collection.

* Shotgun surgery:

En liten endring (konseptuelt) ender opp med endringer mange steder i kodebasen. Se om en klasse kan gjøre at konseptet 
kan samles et sted. 
Relevante refaktoreringsmetoder: 

	* Move method.
	* Move field.

* Feature envy/inappropriate intimacy:

Metode som gjør operasjoner på et objekt eller felt som ikke finnes i klassen du er i. Klasser henter verdier fra hverandre 
hele tiden. Flytt funksjonaliteten til klassen som har riktige verdier, lag en ny klasse eller samle klassene. 
Relevante refaktoreringsmetoder:

	* Move method.
	* Move field.
	* Extract method.

* Primitive obsession:

Det er OK å ha små klasser dersom det gjør at resten av koden slipper å forholde seg til noen få verdier som alltid opptrer sammen. 
Relevante refaktoreringsmetoder:

	* Replace data value with object.
	* Replace type code with class.

* Switch-blokker:

Er verdiene du itererer over bare enkle verdier, eller har de en dypere mening? Vurder å bytte ut switch-blokken med polymorfisme og subklasser. 
Relevante refaktoreringsmetoder:

	* Replace conditionals with polymorphism.
	* Replace type code with subclasses.
	* Replace parameter with explicit methods.
	* Introduce null object.

* Vi skal bare gjøre det litt mer generelt: 

En løsning som er unødig kompleks og løser mer enn det dere trenger nå, gjerne i alle mulige varianter. Du trenger det mest sannsynlig 
ikke nå. Enkelt er alltid bedre enn komplekst. 
Relevante refaktoreringsmetoder:

	* Collapse hierarchy.
	* Remove parameter.
	* Rename method.
	* Inline class.

* Midlertidige variabler: 


	* Extract class.
	* Introduce null object.

* Kommentarer: 

Kommentarer lyver ofte. Bruk god navngiving. Bruk kommentarer hvis du må forklare hvorfor en spesifikk løsning er valgt. 
Relevante refaktoreringsmetoder:

	* Extract method.
	* Introduce assertion.

### Vanlige refaktoreringsmetoder: 
######(google is your friend)

* Pull up method:
	- Dra med deg metoden opp i en superklasse


* Form template method:
    - Generaliser metodene slik at inneholdet er likt, og dra opp metoden. 
    - Er det spesielle ting som kun er relevant is subklassen? Lag en abstrakt metode i superklassen som implementeres i 
    hver av subklassene. 

	
* Replace conditional with polymorphism:
    - Flytt hver del av avgjørelsestreet i en override-metode i en subklasse og gjør hovedmetoden abstrakt


* Null-objekt:
	- I stedet for å returere null, returneres et objekt (kan være en subklasse) som representerer null-tilfellet (feks 
	ingen aksjon). 
	

* Encapsulate field:
	- Gjør feltet privat, som aksesseres med get/set hvis nødvendig. Husk at stor bruk av set/get er indikasjon på at koden 
	gjerne bør skrives om


* Encapsulate collection:
	- Bruk get, add og remove-metoder for samlinger (collections) i stedet for get/set
	

* Collapse hierarchy:
	- Fjern klasser som ikke trengs

* Replace temp with query:
	- Dra et uttrykk ut i en metode 

* Decompose conditional:
    - Egne metoder for det som skjer i if, else og finally (eller tilsvarende)
	

* Replace parameter with method:
    - Fjern parameter og la mottageren kalle metoden
	

* Replace type code with subclasses:
	- Erstatt feks konstanter med subklasser 
