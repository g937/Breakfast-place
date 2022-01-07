# Breakfast-place
Used programming language: Java
Date: 12.12.2021.
Description: A programban egy felkapott reggelizőhelyen vizsgálom a legnépszerűbb Termékeket. A Termék absztrakt
osztály, tulajdonságai: név, eladási ár, hozzávalók (listaszerkezet). Az ár rendeléskor Áfával egészül ki (27%), ez
konstans értékként interfészben tárolódik, és belekalkulálódik az árba! A Termék leszármazottai a Melegszendvics
(új tulajdonsága: elkészítési idő percben), a Limonádé (buborékos-e) és a Lekváros_piskóta (kalóriaszám).
Egy-egy adag Termék elkészítéséhez a következő Hozzávalókra van szükség:
Melegszendvics: 30 dkg bagett, 10 dkg bacon, 1 közepes lilahagyma (db), 1 dl tejföl
Limonádé: 1 db citrom, 0,5L ásványvíz (buborékos VAGY mentes!), 1 evőkanál (5gr.) cukor
(A limonádét lehet kérni szénsavas vagy mentes kivitelben is!)
Lekváros piskóta: 1 adag kész piskótatészta, 100 gramm cukor, 1 kanál (5dkg) lekvár.
A Hozzávalók árai:
Kenyér: 500 Ft/kg; bacon: 3000 Ft/kb, hagyma: 50 Ft/db, tejföl: 200 Ft/dl,
citrom: 80 Ft/db , ásványvíz: 200 Ft/l, ha mentes, 150 Ft/l, ha buborékos, cukor: 500 Ft/kg, piskótatészta: 300 Ft,
lekvár: 1000 Ft/üveg (1 üveg 1 kg).
A Melegszendvics ára 600 Ft, a Limonádéé 300 Ft, a Lekváros_piskóta 1 adagja 400 Ft-ba kerül.
A legdrágább Terméket megadja a void legdragabbAdag() metódus (ehhez megállapítva az egyes termékek
előállítási költségét)! Készült egy metódus annak megállapítására is, hogy a reggelizőhelynek melyik terméken van a
legnagyobb haszna!
Elkészült egy egyszerűsített számla a Kiss család részére: apa, anya és 1 gyermek. Minden családtag
mindenből egy adagot fogyasztott, kivéve Kiss apukát, aki két Melegszendviccsel is elbánt. Az anyuka
mentes, a többiek szénsavas limonádét fogyasztottak. A számlán szerepel a fogyasztott ételek tételes
felsorolása és a teljes fogyasztás ára (áfával)!
A program képes listázni azokat a termékeket, amiben szerepel a paraméterként megadott hozzávaló.
A program receptet tud készíteni a megadott hozzávalókból, és azokat formázottan, StringBuffer
használatával kiírja egy Receptek.txt fájlba.
