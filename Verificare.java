package Junior_Part.Proiect_P1;

public class Verificare {
    public static void main(String[] args) {
        // TODO Testarea metodelor definite in Clasele GUEST si GUESTLIST

        Guest one = new Guest("Ionescu", "Edi", "edi@gmail.com", "07326866673628");
        Guest two = new Guest("Donciu", "Iancu", "donciu@gmail.com", "0377383627832");
        Guest three = new Guest("Iarmalai", "Mihai", "iarma@gmail.com", "037678283872");
        Guest four = new Guest("Dorinescu", "Ion", "dorinon@gmail.com", "03273273828372");
        Guest five = new Guest("Donciu", "Iancu", "donciu@gmail.com", "0377383627832");
        GuestsList spisok = new GuestsList(5);

        // TODO TESTAREA METODELOR DE ADAUGARE
        spisok.adaugare(one);
        spisok.adaugare(two);
        spisok.adaugare(three);
        // TODO Error case of already existing person (check by all 3 categories)
        spisok.adaugare(five);
        spisok.adaugare(four);
        System.out.println(spisok.toString("participare"));
        // TODO TESTAREA METODEI DE ACTUALIZARE
        System.out.println("Cautarea utilizarotului (one) pe calea corecta ne da: " +spisok.cautare(one.getLastName(), one.getFirstName()));
        System.out.println("Actualizarea numelui si prenumelui lui (one) in un mod" +
                " corect ne da:"+spisok.acualizare(spisok.locationFinder("ionescu", "EDI"), "ionescu", "eduard"));
        System.out.println("Verificarea actualizarii lui (one), ne da:  " + spisok.cautare("ionescu", "EdUaRd"));
        System.out.println("Similar, actualizarea numarului:  "
                + spisok.actualizare(spisok.locationFinder("037678283872"),"47678283872"));
        // TODO TESTAREA METODEI DE ELIMINARE
        System.out.println("Lista actuala este: " + spisok.toString("participare"));
        System.out.println(spisok.eliminare("47678283872"));
        System.out.println("Lista fara de persoana cu numarul de telefon (47678283872) este:  "+spisok.toString("participare"));
        System.out.println(spisok.eliminare("dorinon@gmail.com"));
        System.out.println("Lista fara de persoana cu email-ul (dorinon@gmail.com) este:  " + spisok.toString("participare") );
        spisok.adaugare(three);
        // TODO Error case of not existing person
        System.out.println("Eliminand dupa parametri inexistenti obtinem:  " + spisok.eliminare("Iancu","valentin"));
        // TODO TESTAREA METODEI NUMARULUI RAMAS DE LOCURI
        System.out.println("Numarul ramas de locuri la eveniment este: " +spisok.spotsLeft());
        // TODO TESTAREA METODELOR NUMARULUI EXISTENT IN LISTA DE PARTICIPARE SI IN CEA DE ASTEPTARE
        System.out.println("Numarul celor participanti este:  " + spisok.spotsParticipare());
        System.out.println("Numarul celor in asteptare este:  " + spisok.spotsAstepare());
        System.out.println("Numarul total a celor inregistrati este:  " + spisok.spotsTotal());
        // TODO VERIFICAREA FUNCTIONALITATII TRANZITULUI INTRE LISTE
        Guest six = new Guest("Armas", "Iurie", "armas@gmail.com", "03767887666876283872");
        Guest seven = new Guest("Dinulescu", "Ionut", "din@gmail.com", "0328773273828372");
        Guest eight = new Guest("Dacim", "Iancu", "dacim@gmail.com", "037738666783627832");
        spisok.adaugare(six);
        spisok.adaugare(seven);
        spisok.adaugare(eight);
        System.out.println("Numarul celor participanti este:  " + spisok.spotsParticipare());
        System.out.println("Numarul celor in asteptare este:  " + spisok.spotsAstepare());
        System.out.println("Numarul total a celor inregistrati este:  " + spisok.spotsTotal());
        spisok.partialSearch("666");
        // TODO VERIFICAREA FUNCTIONALITATII CAUTARII PARTIALE
        System.out.println("Lista utilizatorilor care au in numarul de telefon numarul 666 este: " + spisok.toString("partialsearch"));
        // TODO Exception case, pentru search-ul doar dupa un simbol
        spisok.partialSearch("7");





    }
}