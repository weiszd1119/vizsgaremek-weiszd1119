# Documentation for examination papers ('vizsgaremek')

<div align="center">
<img alt="Test cases" src="https://img.shields.io/badge/Test cases-33-darkblue">
<img alt="Passed" src="https://img.shields.io/badge/Passed-27-darkgreen">
<img alt="Failed" src="https://img.shields.io/badge/Failed (Assert errors)-6-red">
<img alt="Rate" src="https://img.shields.io/badge/Rate-81.81 percent-yellow">
<img alt="Reported bug" src="https://img.shields.io/badge/Reported bug-2-orange">

### 7/3/2022 | Codecool's Test Automation course
___
### WEISZ, Dávid | weiszd1119
___
### Mentor's: LENNER, Tamás | MÉSZÁROS, Zsolt
___

<h3 align="center">Automated Blonde Site</h3>
<a href="https://github.com/othneildrew/Best-README-Template">
    <img src="projectlogo.png" alt="Project logo">
  </a>
  <p align="center">
    <br>
    <a href="https://lennertamas.github.io/blondesite/">Tested Website</a>
    |
    <a href="https://docs.google.com/spreadsheets/d/1dEiLsYp6zYJDu8JtF6I-paC7DlF53plCgytqlSHMIuQ/edit?usp=sharing">Testmanager File</a>
    |
    <a href="https://github.com/weiszd1119/vizsgaremek-weiszd1119">Code</a>
    |
    <a href="https://weiszd1119.github.io/vizsgaremek-weiszd1119/54/">Allure report</a>
  </p>
</div>
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#overview">Overview</a></li>
    <li><a href="#dependencies">Dependencies</a></li>
    <li><a href="#authors">Authors</a></li>
    <li><a href="#allure-report">Allure report</a></li>
    <li><a href="#acknowledgement">Acknowledgment</a></li>
  </ol>
</details>

<div id="overview">

## Overview

* To complete the [Codecool's Test Automation course](https://codecool.com/wp-content/uploads/2022/04/Junior-automata-tesztelo.pdf), this exam paper will test the interface of the web application on [Blondesite](https://lennertamas.github.io/blondesite/) according to the following criteria.
* The table lists the functions and the classes that implement them. The class names are also references to the subpage to be tested.

| Function                                          | Class                                                                                                                                                                                     | Test class                                                     |
|---------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| Registration                                      | [Register](https://lennertamas.github.io/blondesite/)                                                                                                                                     | MainUserManagementTest                                         |
| Login                                             | [LoginLogout](https://lennertamas.github.io/blondesite/)                                                                                                                                  | MainUserManagementTest                                         |
| Use of the privacy statement                      | [AcceptContract](https://lennertamas.github.io/blondesite/)                                                                                                                               | MainControlSiteTest                                            |
| List data                                         | [OrderedList](https://lennertamas.github.io/blondesite/post/markdown-syntax/), [Tables]()                                                                                                 | MainWorkWithDataTest                                           |
| Scanning a multi-page list                        | [Pages](https://lennertamas.github.io/blondesite/post/emoji-support/)                                                                                                                     | MainControlSiteTest                                            |
| Entering new data                                 | [Contact](https://lennertamas.github.io/blondesite/contact/), [LoginLogout](https://lennertamas.github.io/blondesite/), [Register](https://lennertamas.github.io/blondesite/), [Search]() | MainControlSiteTest, MainUserManagementTest, MainWorkWithDataTest |
| Repeated and serial data entry from data sources  | [Contact](https://lennertamas.github.io/blondesite/contact/), [LoginLogout](https://lennertamas.github.io/blondesite/), [Register](https://lennertamas.github.io/blondesite/), [Search]() | MainControlSiteTest, MainUserManagementTest, MainWorkWithDataTest |
| Modify existing data                              | [ModifyData](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWorkWithDataTest                                           |
| Data(s) deleting                                  | [ModifyData](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWorkWithDataTest                                           |
| Save data from the site                           | [SaveImage](https://lennertamas.github.io/blondesite/post/image-test/), [SaveText](https://lennertamas.github.io/blondesite/post/math-typesetting/)                                       | MainWorkWithDataTest                                           |
| Logout                                            | [LoginLogout](https://lennertamas.github.io/blondesite/)                                                                                                                                  | MainUserManagementTest                                         |
| ------------------------------------------------- | -----------------------------------------------                                                                                                                                           | --------------------------------------------------------       |
| Web connection (REST)                             | [WebService](https://lennertamas.github.io/blondesite/)                                                                                                                                   | MainWebServiceTest                                             |
| Page style options (light/dark)                   | [CssStyle](https://lennertamas.github.io/blondesite/about/)                                                                                                                               | MainControlSiteTest                                            |
| Check links to external sites                     | [Links](https://lennertamas.github.io/blondesite/about/)                                                                                                                                  | MainControlSiteTest                                            |
| Checking the operation of tags                    | [Tags](https://lennertamas.github.io/blondesite/about/)                                                                                                                                   | MainControlSiteTest                                            |
| ------------------------------------------------- | ----------------------------------------                                                                                                                                                  | --------------------------------------------------------       |
| Start the browser's driver                        | StartDriver                                                                                                                                                                               | N/A                                                            |
| SiteFactory class (Page Object Modell)            | SiteFactory                                                                                                                                                                               | N/A                                                            |

</div>
<div id="dependencies">

## Dependencies

* I used IntelliJIdea 2022.1 (Community Edition) to run the tests, the code has written in Java 16.
</div>

<div id="authors">

## Authors

* The test items were created by [WEISZ, Dávid AKA weiszd1119](https://github.com/weiszd1119), participant of the Codecool Test Automation course between 11/04/2022 - 24/06/2022.
* The examination papers and thi documentation is available on [GitHub](https://github.com/weiszd1119/vizsgaremek-weiszd1119).
</div>

<div id="allure-report">

## Allure report

* Allure report is available at [GitHub Pages](https://weiszd1119.github.io/vizsgaremek-weiszd1119)
</div>

<div id="acknowledgement">

## Acknowledgement

Professional and/or emotional support was provided during the preparation of the examination papers:

Mentors of the Codecool's Test Automation course
* <span style="font-variant:small-caps">Lenner</span>, Tamás
* <span style="font-variant:small-caps">Mészáros</span>, Zsolt

and its participants:
* <span style="font-variant:small-caps">Balog</span>, Crisan Roland Florian
* <span style="font-variant:small-caps">Barta</span>, Erik
* <span style="font-variant:small-caps">Blastik</span>, Andor
* <span style="font-variant:small-caps">Börcsök</span>, Bálint István
* <span style="font-variant:small-caps">Diriczi</span>, Dávid
* <span style="font-variant:small-caps">Farkas</span>, Zoltán Gyula
* <span style="font-variant:small-caps">Funák</span>, Attila
* <span style="font-variant:small-caps">Horváth</span>, János
* <span style="font-variant:small-caps">Horváth</span>, Klaudia
* <span style="font-variant:small-caps">Horváth</span>, Zsófia
* <span style="font-variant:small-caps">Magyar</span>, Gergő
* <span style="font-variant:small-caps">Morvai</span>, Csaba
* <span style="font-variant:small-caps">Nagy</span>, Gábor
* <span style="font-variant:small-caps">Simon</span>, Ágnes
* <span style="font-variant:small-caps">Simonfi</span>, Péter
* <span style="font-variant:small-caps">Szarka</span>, Vivien Dorottya
* <span style="font-variant:small-caps">Tóth</span>, András
* <span style="font-variant:small-caps">Vas</span>, Petra
 
and participants in the Codecool's Manual Testing course, in particular:
* <span style="font-variant:small-caps">Katona</span>, Angelika
* <span style="font-variant:small-caps">László</span>, Katalin

As well as my family and friends who have accompanied me from the beginning:
* <span style="font-variant:small-caps">Árva</span>, Stefánia Ágnes
* <span style="font-variant:small-caps">Beitzer</span>, Éva
* <span style="font-variant:small-caps">Berczi</span>, Berczi
* <span style="font-variant:small-caps">Busi</span>, László Lajos
* <span style="font-variant:small-caps">Drüszler</span>, Angela
* <span style="font-variant:small-caps">Godó</span>, Irén
* <span style="font-variant:small-caps">Godó</span>, Katalin
* <span style="font-variant:small-caps">Hajós</span>, Károly
* <span style="font-variant:small-caps">Hajósné</span>, Weisz Viktória
* <span style="font-variant:small-caps">Weisz</span>, Anita
* <span style="font-variant:small-caps">Weisz</span>, Nikoletta
* <span style="font-variant:small-caps">Weisz</span>, Zoltán
* <span style="font-variant:small-caps">Weisz-Veréb</span>, Andrea
* <span style="font-variant:small-caps">Weisz</span>, Anita
* ...<span style="font-variant:small-caps">And many</span>, others...

</div>
___

<span style="font-variant:small-caps">Weisz</span>, Dávid

Kóka, 3/7/2022

Note: saveTextFromBlondeSite() has already created the file in a previous run, which is why the exported text is listed twice and why we get AssertionError.
