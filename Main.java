package Junior_Part.Proiect_P1;

import Junior_Part.TemaDevMindCurs11.Screen;

import java.util.Scanner;

public class Main {

    //TODO: Remarcare: Cunosc faptul ca orice variabila se recomanda a fi denumita in engleza, insa am intentionat
    //TODO: sa le denumesc mai deosebit pentru a asigura individualitatea temei pe acasa.

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        String nume="";
        String prenume="";
        String numarTel="";
        String email="";
        String nume1="";
        String prenume1="";
        String numarTel1="";
        String email1="";
        String choice="";
        int selec=0;
        int meniu=0;
        System.out.println("Bine v-am regasit in registrul \"Party-2022\"");
        System.out.println("Introduceti va rog capacitatea maxima a evenimentului dat:");
        int volum = sc.nextInt();
        sc.nextLine();
        GuestsList party2022 = new GuestsList(volum);
        System.out.println("Alegeti optiunea dorita, din lista propuse mai jos:");
        System.out.println("help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia");
        while (true){
            System.out.println("Introduceti optiunea aleasa: ");
            String selection = sc.nextLine().toLowerCase().trim();
            switch (selection){
                case "add":
                    while(true){
                        System.out.println("Introduceti va rog numele persoanei:");
                        nume = sc.nextLine().toLowerCase();
                        System.out.println("Introduceti va rog prenumele persoanei");
                        prenume = sc.nextLine().toLowerCase();
                        System.out.println("Introduceti va rog numarul de telefon al persoanei, incepand cu 0");
                        numarTel = sc.nextLine();
                        System.out.println("Introduceti va rog emailul persoanei");
                        email = sc.nextLine();
                        if (nume.length()<=1 || prenume.length() <=1 || numarTel.length() <9 || email.length()<5 ){
                            System.out.println("Cel putin o sectiune introdusa este necorespunzatoare formatului chestionarului\n" +
                                    "Numele tre sa aiba cel putin 2 simboluri\n" +
                                    "Prenumele tre sa aiba cel putin 2 simboluri\n" +
                                    "Numarul de telefon tre sa aiba cel putin 9 simboluri\n" +
                                    "Email-ul tre sa aiba cel putin 5 simboluri  (Ex: x..@...com)");
                            System.out.println("Tastati 1, Pentru a reincerca adaugarea persoanei\n" +
                                    "Tastati 2, Pentru a reveni in meniul principal");

                            while (meniu!=1 && meniu!=2){
                                meniu = sc.nextInt();
                                sc.nextLine();
                                if (meniu != 1 && meniu!=2){
                                    System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                }
                            }
                            if (meniu==1){
                                meniu=0;
                                continue;
                            }
                            else if(meniu==2){
                                meniu=0;
                                break;
                            }
                        }
                        else {
                            Guest guest = new Guest(nume, prenume, email, numarTel);
                            party2022.adaugare(guest);
                            break;
                        }
                    }
                    break;
                case "check":
                    while(true){
                        System.out.println("Pentru cautare, exista urmatoarele 3 optiuni: ");
                        System.out.println("1. Cautare dupa NUME si PRENUME\n" +
                                "2. Cautare dupa NUMAR TELEFON\n" +
                                "3. Cautare dupa EMAIL");
                        System.out.println("Selectati numarul optiunii dorite: ");
                        choice = sc.nextLine().trim();
                        if (choice.equals("1")){
                            System.out.println("Intoduceti va rog numele:");
                            nume = sc.nextLine().toLowerCase().trim();
                            System.out.println("Introduceti va rog prenumele:");
                            prenume = sc.nextLine().toLowerCase().trim();
                            if (nume.length()<=1 || prenume.length() <=1){
                                System.out.println("Cel putin o sectiune introdusa este necorespunzatoare formatului chestionarului\n" +
                                        "Numele tre sa aiba cel putin 2 simboluri\n" +
                                        "Prenumele tre sa aiba cel putin 2 simboluri\n");
                                System.out.println("Tastati 1, Pentru a reincerca cautarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }
                            }
                            else {
                                if (party2022.cautare(nume, prenume)){
                                    System.out.println("Persoana cautata este inscrisa la eveniment");
                                }
                                else{
                                    System.out.println("Persoana cautata nu este inscrisa la eveniment");
                                }
                            }
                        }
                        else if(choice.equals("2")){
                            System.out.println("Introduceti va rog numarul de telefon:");
                            numarTel = sc.nextLine().trim();
                            if (numarTel.length()<10){
                                System.out.println("Sectiunea introdusa este necorespunzatoare formatului chestionarului\n" +
                                        "Numarul de telefon tre sa aiba cel putin 9 simboluri\n");
                                System.out.println("Tastati 1, Pentru a reincerca cautarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }
                            }
                            else {
                                if (party2022.cautare(numarTel)){
                                    System.out.println("Persoana cautata este inscrisa la eveniment");
                                }
                                else{
                                    System.out.println("Persoana cautata nu este inscrisa la eveniment");
                                }
                            }
                        }
                        else if(choice.equals("3")){
                            System.out.println("Introduceti va rog emailul:");
                            email = sc.nextLine().trim();
                            if (email.length()<5){
                                System.out.println("Sectiunea introdusa este necorespunzatoare formatului chestionarului");
                                System.out.println("Email-ul tre sa aiba cel putin 5 simboluri  (Ex: x..@...com)");
                                System.out.println("Tastati 1, Pentru a reincerca cautarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }
                            }
                            else {
                                if (party2022.cautare(email)){
                                    System.out.println("Persoana cautata este inscrisa la eveniment");
                                }
                                else{
                                    System.out.println("Persoana cautata nu este inscrisa la eveniment");
                                }
                            }
                        }
                        else {
                            System.out.println("Alegerea selectata nu este corespunzatoare intervalului propus");
                        }
                    }
                    break;
                case "remove":
                    System.out.println("Pentru stergere, exista urmatoarele 3 optiuni: ");
                    System.out.println("1. Identificare+Stergere dupa NUME si PRENUME\n" +
                            "2. Identificare+Stergere dupa NUMAR TELEFON\n" +
                            "3. Identificare+Stergere dupa EMAIL");
                    System.out.println("Selectati numarul optiunii dorite: ");
                    choice = sc.nextLine().trim();
                    if (choice.equals("1")){
                        System.out.println("Intoduceti va rog numele:");
                        nume = sc.nextLine().toLowerCase().trim();
                        System.out.println("Introduceti va rog prenumele:");
                        prenume = sc.nextLine().toLowerCase().trim();
                        if (nume.length()<=1 || prenume.length() <=1){
                            System.out.println("Cel putin o sectiune introdusa este necorespunzatoare formatului chestionarului\n" +
                                    "Numele tre sa aiba cel putin 2 simboluri\n" +
                                    "Prenumele tre sa aiba cel putin 2 simboluri\n");
                            System.out.println("Tastati 1, Pentru a reincerca eliminarea persoanei\n" +
                                    "Tastati 2, Pentru a reveni in meniul principal");

                            while (meniu!=1 && meniu!=2){
                                meniu = sc.nextInt();
                                sc.nextLine();
                                if (meniu != 1 && meniu!=2){
                                    System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                }
                            }
                            if (meniu==1){
                                meniu=0;
                                continue;
                            }
                            else if(meniu==2){
                                meniu=0;
                                break;
                            }
                        }
                        else {
                            if (party2022.eliminare(nume, prenume)){
                                System.out.println("Persoana cautata a fost stearsa din listele evenimentului");
                            }
                            else{
                                System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                        "si respectiv nu a putut fi stearsa");
                            }
                        }
                    }
                    else if(choice.equals("2")){
                        System.out.println("Introduceti va rog numarul de telefon:");
                        numarTel = sc.nextLine().trim();
                        if (numarTel.length()<10){
                            System.out.println("Sectiunea introdusa este necorespunzatoare formatului chestionarului");
                            System.out.println("Numarul de telefon tre sa aiba cel putin 9 simboluri\n");
                            System.out.println("Tastati 1, Pentru a reincerca eliminarea persoanei\n" +
                                    "Tastati 2, Pentru a reveni in meniul principal");

                            while (meniu!=1 && meniu!=2){
                                meniu = sc.nextInt();
                                sc.nextLine();
                                if (meniu != 1 && meniu!=2){
                                    System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                }
                            }
                            if (meniu==1){
                                meniu=0;
                                continue;
                            }
                            else if(meniu==2){
                                meniu=0;
                                break;
                            }
                        }
                        else {
                            if (party2022.eliminare(numarTel)){
                                System.out.println("Persoana cautata a fost stearsa din listele evenimentului");
                            }
                            else{
                                System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                        "si respectiv nu a putut fi stearsa");
                            }
                        }
                    }
                    else if(choice.equals("3")){
                        System.out.println("Introduceti va rog emailul:");
                        email = sc.nextLine().trim();
                        if (email.length()<5){
                            System.out.println("Sectiunea introdusa este necorespunzatoare formatului chestionarului");
                            System.out.println("Email-ul tre sa aiba cel putin 5 simboluri  (Ex: x..@...com)");
                            System.out.println("Tastati 1, Pentru a reincerca eliminarea persoanei\n" +
                                    "Tastati 2, Pentru a reveni in meniul principal");

                            while (meniu!=1 && meniu!=2){
                                meniu = sc.nextInt();
                                sc.nextLine();
                                if (meniu != 1 && meniu!=2){
                                    System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                }
                            }
                            if (meniu==1){
                                meniu=0;
                                continue;
                            }
                            else if(meniu==2){
                                meniu=0;
                                break;
                            }
                        }
                        else {
                            if (party2022.eliminare(email)){
                                System.out.println("Persoana cautata a fost stearsa din listele evenimentului");
                            }
                            else{
                                System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                        "si respectiv nu a putut fi stearsa");
                            }
                        }
                    }
                    else {
                        System.out.println("Alegerea selectata nu este corespunzatoare intervalului propus");
                    }
                    break;
                case "update":
                    while (true){
                        System.out.println("Pentru updatare, exista urmatoarele 3 optiuni: ");
                        System.out.println("1. Identificare+Updatare dupa NUME si PRENUME\n" +
                                "2. Identificare+Updatare dupa NUMAR TELEFON\n" +
                                "3. Identificare+Updatare dupa EMAIL");
                        System.out.println("Selectati numarul optiunii dorite: ");
                        choice = sc.nextLine().trim();
                        if (choice.equals("1")){
                            System.out.println("Intoduceti va rog numele:");
                            nume = sc.nextLine().toLowerCase().trim();
                            System.out.println("Introduceti va rog prenumele:");
                            prenume = sc.nextLine().toLowerCase().trim();

                            if (nume.length()<=1 || prenume.length() <=1){
                                System.out.println("Cel putin o sectiune introdusa este necorespunzatoare formatului chestionarului\n" +
                                        "Numele tre sa aiba cel putin 2 simboluri\n" +
                                        "Prenumele tre sa aiba cel putin 2 simboluri\n");
                                System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }

                            }
                            else if (!party2022.cautare(nume,prenume)){
                                System.out.println("Nu a fost gasita o astfel de persoana");
                            }
                            else {
                                System.out.println("Introduceti cifra caracteristicii dorite spre actualizare, din lista propusa");
                                System.out.println("1.NUME \n2.PRENUME \n3.NUMAR TELEFON\n4.EMAIL");
                                selec = sc.nextInt();
                                sc.nextLine();
                                if (selec==1){
                                    System.out.println("Introduceti noul nume:");
                                    nume1 = sc.nextLine().toLowerCase().trim();
                                    if (nume1.length()<2){
                                        System.out.println("Numele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(nume,prenume), nume1,prenume)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if(selec==2){
                                    System.out.println("Introduceti noul prenume:");
                                    prenume1 = sc.nextLine().toLowerCase().trim();
                                    if (prenume1.length()<2){
                                        System.out.println("Prenumele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(nume,prenume),nume,prenume1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if (selec==3){
                                    System.out.println("Introduceti noul numar de telefon:");
                                    numarTel1 = sc.nextLine();
                                    if (numarTel1.length()<9){
                                        System.out.println("Numarul trebuie sa aiba cel putin 9 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(nume,prenume),numarTel1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if(selec==4){
                                    System.out.println("Introduceti noul email:");
                                    email1 = sc.nextLine();
                                    if (email1.length()<5){
                                        System.out.println("Emailul trebuie sa aiba cel putin 5 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(nume,prenume),email1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Selectia facuta este in afara intervalului propus");
                                }
                            }
                        }
                        else if(choice.equals("2")){
                            System.out.println("Intoduceti va rog numarul de telefon:");
                            numarTel = sc.nextLine();
                            if (numarTel.length()<10){
                                System.out.println("Sectiunea introdusa este necorespunzatoare formatului chestionarului");
                                System.out.println("Numarul de telefon trebuie sa aiba cel putin 9 simboluri");
                                System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }
                            }
                            else if (!party2022.cautare(numarTel)) {
                                System.out.println("Nu a fost gasita o astfel de persoana");
                            }
                            else {
                                System.out.println("Introduceti cifra caracteristicii dorite spre actualizare, din lista propusa");
                                System.out.println("1.NUME \n2.PRENUME \n3.NUMAR TELEFON\n4.EMAIL");
                                selec = sc.nextInt();
                                sc.nextLine();
                                if (selec==1){
                                    System.out.println("Introduceti noul nume:");
                                    nume1 = sc.nextLine().toLowerCase().trim();
                                    if (nume1.length()<2){
                                        System.out.println("Numele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(numarTel), nume1,prenume)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if(selec==2){
                                    System.out.println("Introduceti noul prenume:");
                                    prenume1 = sc.nextLine().toLowerCase().trim();
                                    if (prenume1.length()<2){
                                        System.out.println("Prenumele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(numarTel),nume,prenume1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if (selec==3){
                                    System.out.println("Introduceti noul numar de telefon:");
                                    numarTel1 = sc.nextLine();
                                    if (numarTel1.length()<9){
                                        System.out.println("Numarul trebuie sa aiba cel putin 9 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(numarTel),numarTel1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else if(selec==4){
                                    System.out.println("Introduceti noul email:");
                                    email1 = sc.nextLine();
                                    if (email1.length()<5){
                                        System.out.println("Emailul trebuie sa aiba cel putin 5 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(numarTel),email1)){
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        }
                                        else{
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Selectia facuta este in afara intervalului propus");
                                }
                            }
                        }
                        else if(choice.equals("3")) {
                            System.out.println("Intoduceti va rog emailul:");
                            email = sc.nextLine();
                            if (numarTel.length() < 5) {
                                System.out.println("Setiunea introdusa este necorespunzatoare formatului chestionarului");
                                System.out.println("Numarul de telefon trebuie sa aiba cel putin 5 simboluri");
                                System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                        "Tastati 2, Pentru a reveni in meniul principal");

                                while (meniu!=1 && meniu!=2){
                                    meniu = sc.nextInt();
                                    sc.nextLine();
                                    if (meniu != 1 && meniu!=2){
                                        System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                    }
                                }
                                if (meniu==1){
                                    meniu=0;
                                    continue;
                                }
                                else if(meniu==2){
                                    meniu=0;
                                    break;
                                }
                            }
                            else if (!party2022.cautare(email)) {
                                System.out.println("Nu a fost gasita o astfel de persoana");
                            }
                            else {
                                System.out.println("Introduceti cifra caracteristicii dorite spre actualizare, din lista propusa");
                                System.out.println("1.NUME \n2.PRENUME \n3.NUMAR TELEFON\n4.EMAIL");
                                selec = sc.nextInt();
                                sc.nextLine();
                                if (selec == 1) {
                                    System.out.println("Introduceti noul nume:");
                                    nume1 = sc.nextLine().toLowerCase().trim();
                                    if (nume1.length()<2){
                                        System.out.println("Numele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(email), nume1, prenume)) {
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        } else {
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                } else if (selec == 2) {
                                    System.out.println("Introduceti noul prenume:");
                                    prenume1 = sc.nextLine().toLowerCase().trim();
                                    if (prenume1.length()<2){
                                        System.out.println("Prenumele trebuie sa aiba cel putin 2 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.acualizare(party2022.locationFinder(email), nume, prenume1)) {
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        } else {
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                } else if (selec == 3) {
                                    System.out.println("Introduceti noul numar de telefon:");
                                    numarTel1 = sc.nextLine();
                                    if (numarTel1.length()<9){
                                        System.out.println("Numarul trebuie sa aiba cel putin 9 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(email), numarTel1)) {
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        } else {
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                } else if (selec == 4) {
                                    System.out.println("Introduceti noul email:");
                                    email1 = sc.nextLine();
                                    if (email1.length()<5){
                                        System.out.println("Emailul trebuie sa aiba cel putin 5 simboluri");
                                        System.out.println("Tastati 1, Pentru a reincerca updatarea persoanei\n" +
                                                "Tastati 2, Pentru a reveni in meniul principal");

                                        while (meniu!=1 && meniu!=2){
                                            meniu = sc.nextInt();
                                            sc.nextLine();
                                            if (meniu != 1 && meniu!=2){
                                                System.out.println("Introduceti va rog una din cele 2 optiuni (1 sau 2)");
                                            }
                                        }
                                        if (meniu==1){
                                            meniu=0;
                                            continue;
                                        }
                                        else if(meniu==2){
                                            meniu=0;
                                            break;
                                        }
                                    }
                                    else {
                                        if (party2022.actualizare(party2022.locationFinder(email), email1)) {
                                            System.out.println("Datele persoanei cautate au fost actualizate");
                                        } else {
                                            System.out.println("Persoana cautata nu a fost identificata in liste, " +
                                                    "si respectiv datele acesteia nu au putut fi actualizate");
                                        }
                                    }
                                } else {
                                    System.out.println("Selectia facuta este in afara intervalului propus");
                                }
                            }
                        }
                        else {
                            System.out.println("Alegerea selectata nu este corespunzatoare intervalului propus");
                        }
                    }
                    break;
                case "guests":
                    System.out.println("Lista de persoane participante la eveniment sunt:");
                    System.out.println(party2022.toString("participare"));
                    break;
                case "waitlist":
                    System.out.println("Lista de persoane din lista de asteptare sunt:");
                    System.out.println(party2022.toString("asteptare"));
                    break;
                case "available":
                    System.out.print("Numarul ramas de locuri este: ");
                    System.out.println(party2022.spotsLeft());
                    break;
                case "guests_no":
                    System.out.print("Numarul de persoane participante este: ");
                    System.out.println(party2022.spotsParticipare());
                    break;
                case "waitlist_no":
                    System.out.println("Numarul de persoane in astepare este: ");
                    System.out.println(party2022.spotsAstepare());
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane inscrise la eveniment este: ");
                    System.out.println(party2022.spotsTotal());
                    break;
                case "search":
                    System.out.println("Introduceti va rog consecutivitatea de caractere dupa care sa cautam in liste:");
                    String cautam = sc.nextLine().toLowerCase().trim();
                    party2022.partialSearch(cautam);
                    System.out.println(party2022.toString("partialsearch"));
                    break;
                case "help":
                    System.out.println("help         - Afiseaza aceasta lista de comenzi\n" +
                            "add          - Adauga o noua persoana (inscriere)\n" +
                            "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                            "remove       - Sterge o persoana existenta din lista\n" +
                            "update       - Actualizeaza detaliile unei persoane\n" +
                            "guests       - Lista de persoane care participa la eveniment\n" +
                            "waitlist     - Persoanele din lista de asteptare\n" +
                            "available    - Numarul de locuri libere\n" +
                            "guests_no    - Numarul de persoane care participa la eveniment\n" +
                            "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                            "subscribe_no - Numarul total de persoane inscrise\n" +
                            "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                            "quit         - Inchide aplicatia");
                    break;
                case "quit":
                    System.out.println("O zi frumoasa. Ne vedem la party!");
                    return;
            }
        }
    }
}
