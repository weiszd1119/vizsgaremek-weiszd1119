# Vizsgaremek dokumentáció
### 2022. 07. 03. | Automata tesztelői kurzus vizsgaremek
### Codecool | Weisz Dávid | weiszd1119

## Áttekintés

* Az automata tesztelői kurzus lezárásaként készítendő jelen vizsgaremek a [Blondesite](https://lennertamas.github.io/blondesite/) oldalon található webalkalmazás felületét teszteli az alábbi szempontok szerint.
* A táblázatban a funkciók és az azt megvalósító osztályok felsorolása látható. Az osztályok nevei egyben hivatkozások is, a tesztelendő aloldalra mutatnak.

| Funkció                                           | Osztály                                                                                                                                                                                   | Tesztosztály                                             |
|---------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| Regisztráció                                      | [Register](https://lennertamas.github.io/blondesite/)                                                                                                                                     | MainUserManagement                                       |
| Bejelentkezés                                     | [LoginLogout](https://lennertamas.github.io/blondesite/)                                                                                                                                  | MainUserManagement                                       |
| Adatkezelési nyilatkozat használata               | [AcceptContract](https://lennertamas.github.io/blondesite/)                                                                                                                               | MainControlSite                                          |
| Adatok listázása                                  | [OrderedList](https://lennertamas.github.io/blondesite/post/markdown-syntax/), [Tables]()                                                                                                 | MainWorkWithData                                         |
| Több oldalas lista bejárása                       | [Pages](https://lennertamas.github.io/blondesite/post/emoji-support/)                                                                                                                     | MainControlSite                                          |
| Új adat bevitel                                   | [Contact](https://lennertamas.github.io/blondesite/contact/), [LoginLogout](https://lennertamas.github.io/blondesite/), [Register](https://lennertamas.github.io/blondesite/), [Search]() | MainControlSite, MainUserManagement, MainWorkWithData    |
| Ismételt és sorozatos adatbevitel adatforrásból   | [Contact](https://lennertamas.github.io/blondesite/contact/), [LoginLogout](https://lennertamas.github.io/blondesite/), [Register](https://lennertamas.github.io/blondesite/), [Search]() | MainControlSite, MainUserManagement, MainWorkWithData    |
| Meglévő adat módosítás                            | [ModifyData](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWorkWithData                                         |
| Adat vagy adatok törlése                          | [ModifyData](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWorkWithData                                         |
| Adatok lementése felületről                       | [SaveImage](https://lennertamas.github.io/blondesite/post/image-test/), [SaveText](https://lennertamas.github.io/blondesite/post/math-typesetting/)                                       | MainWorkWithData                                         |
| Kijelentkezés                                     | [LoginLogout](https://lennertamas.github.io/blondesite/)                                                                                                                                  | MainUserManagement                                       |
| ------------------------------------------------- | -----------------------------------------------                                                                                                                                           | -------------------------------------------------------- |
| Webes kapcsolat ellenőrzése                       | [WebService](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWebService                                           |
| Oldal stílusának beállítási lehetősége            | [CssStyle](https://lennertamas.github.io/blondesite/about/)                                                                                                                               | MainControlSite                                          |
| Külső oldalra mutató hivatkozások ellenőrzése     | [Links](https://lennertamas.github.io/blondesite/about/)                                                                                                                                  | MainControlSite                                          |
| Tag-ek működésének ellenőrzése                    | [Tags](https://lennertamas.github.io/blondesite/about/)                                                                                                                                   | MainControlSite                                          |
| ------------------------------------------------- | ----------------------------------------                                                                                                                                                  | -------------------------------------------------------- |
| A böngésző driverének indítása                    | StartDriver                                                                                                                                                                               | N/A                                                      |
| Page Object Modell szerinti SiteFactory osztály   | SiteFactory                                                                                                                                                                               | N/A                                                      |

## Kezdeti lépések

### Függőségek

* A tesztek futtatásához az IntelliJIdea 2022.1 (Community Edition) szoftvert használtam, a kód 16-os Java-ban fut.  
* A GitHub-n történő futtatás jelenleg nem működik, mert a JSON file beolvasásához szükséges importot a GitHub nem tudta végrehajtani.
* A korábbi futtatások során az Allure Report létrejött, de adatokat nem szolgáltatott (NaN %)

## Authors

* A vizsgaremek készítője Weisz Dávid, a Codecool automata tesztelői kurzus résztvevője 2022. 04. 11 - 2022. 06. 24. között.
* A vizsgaremek elérhető a [GitHubon](https://github.com/weiszd1119/vizsgaremek-weiszd1119).

## Köszönetnyilvánítás

A vizsgaremek elkészítése során szakmai és/vagy lelki támogatást nyújtottak:

A Codecool automata tesztelői kurzus mentorai:
* Lenner Tamás
* Mészáros Zsolt

valamint résztvevői:
* Balog Crisan Roland Florian
* Barta Erik
* Blastik Andor
* Börcsök Bálint István
* Diriczi Dávid
* Farkas Zoltán Gyula
* Funák Attila
* Horváth János
* Horváth Klaudia
* Horváth Zsófia
* Magyar Gergő
* Morvai Csaba
* Nagy Gábor
* Simon Ágnes
* Simonfi Péter
* Szarka Vivien Dorottya
* Tóth András
* Vas Petra

illetve a manuális tesztelői kurzus résztvevői, különösen:
* Katona Angelika
* László Katalin

Valamint közvetlen családi és baráti környezetemnek, akik végigkísértek a kezdetektől:
* Árva Stefánia Ágnes
* Beitzer Éva
* Busi László Lajos
* Drüszler Angela
* Hajós Károly
* Hajósné Weisz Viktória
* Weisz Anita
* Weisz Nikoletta
* Weisz Zoltán
* Weisz-Veréb Andrea

--
Weisz Dávid
Kóka, 2022. 07. 03.