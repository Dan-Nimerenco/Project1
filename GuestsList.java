package Junior_Part.Proiect_P1;

import java.util.ArrayList;

public class GuestsList {
    private int nrLocEveniment;
    private ArrayList<Guest> lista;
    private ArrayList<Guest> asteptare;
    private ArrayList<Guest> partialSearchList;

    public GuestsList(int nrlocuri){
        this.nrLocEveniment = nrlocuri;
        this.lista = new ArrayList<Guest>(this.nrLocEveniment);
        this.asteptare = new ArrayList<Guest>(0);
        this.partialSearchList = new ArrayList<Guest>(0);
    }


    public int adaugare(Guest g){
        boolean exista = false;
        if (cautare(g.getLastName(),g.getFirstName()) || cautare(g.getPhoneNumber()) || cautare(g.getEmail())){
            System.out.println("Un utilizator cu astfel de date deja exista in liste");
            return -1;
        }
        else {
            if (this.lista.size()< this.nrLocEveniment){
                this.lista.add(g);
                System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                return 0;
            }
            else {
                this.asteptare.add(g);
                System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine" +
                        " " + (this.asteptare.indexOf(g)+1) + ". Te vom notifica daca un loc devine disponibil.");
                return this.asteptare.indexOf(g);
            }
        }
    }

    public String toString(String str){
        str = str.toLowerCase().trim();
        String particip="";
        if (str.equals("participare")){
            for (Guest s : this.lista){
                particip+= s.getFirstName() + "  " + s.getLastName() + ",  ";
            }
        }
        else if(str.equals("asteptare")){
            for (Guest s : this.asteptare){
                particip+= s.getFirstName() + "  " + s.getLastName() + ",  ";
            }
        }
        else if (str.equals("partialsearch")){
            for (Guest s : this.partialSearchList){
                particip+= s.getFirstName() + "  " + s.getLastName() + ",  ";
            }
        }
        return particip;
    }

    public boolean cautare(String nume, String prenume){
        // Array {-1,-1,-1} serves as computationally light information keeper
        // Index 0 keeps information about the searched person inside of the list
        // Index 1 keeps information about the list, where the person was found
        // Index 2 keeps information is the searching data were identified by email or by phone
        int[] num = {-1,-1,-1};
        int[] rez = locationFinder(nume, prenume);
        if (rez[0] == num[0] && rez[1] == num[1]){
            return false;
        }
        return true;
    }

    public boolean cautare(String emailORPhoneNumber){
        int[] num = {-1,-1,-1};
        int[] rez = locationFinder(emailORPhoneNumber);
        if (rez[0] == num[0] && rez[1] == num[1]){
            return false;
        }
        return true;
    }


    public int[] locationFinder(String nume, String prenume){
        nume = nume.toLowerCase();
        prenume=prenume.toLowerCase();
        int[] index={-1,-1,-1};
        for (Guest s : this.lista){
            if (s.getFirstName().equals(prenume) && s.getLastName().equals(nume)){
                index[0] = this.lista.indexOf(s);
                index[1] = 1;
            }
        }
        if (index[0]!=-1){
            return index;
        }
        for (Guest s : this.asteptare){
            if (s.getFirstName().equals(prenume) && s.getLastName().equals(nume)){
                index[0] = this.asteptare.indexOf(s);
                index[1] = 2;
            }
        }
        return index;
    }

    public int[] locationFinder(String emailORPhoneNumber){
        int[] index = {-1,-1,-1};
        if (emailORPhoneNumber.contains("@")){
            emailORPhoneNumber = emailORPhoneNumber.toLowerCase();
            for (Guest s : this.lista){
                if (s.getEmail().equals(emailORPhoneNumber)){
                    index[0] = this.lista.indexOf(s);
                    index[1] = 1;
                    index[2] = 1;
                }
            }
            if (index[0]!=-1){
                return index;
            }
            for (Guest s : this.asteptare){
                if (s.getEmail().equals(emailORPhoneNumber)){
                    index[0] = this.asteptare.indexOf(s);
                    index[1] = 2;
                    index[2] = 1;
                }
            }
            return index;
        }
        else{
            if (!(emailORPhoneNumber.charAt(0) + "").equals("0") && !emailORPhoneNumber.contains("@")){
                emailORPhoneNumber = "0" + emailORPhoneNumber;
            }
            for (Guest s : this.lista){
                if (s.getPhoneNumber().equals(emailORPhoneNumber)){
                    index[0] = this.lista.indexOf(s);
                    index[1] = 1;
                    index[2] = 2;
                }
            }
            if (index[0]!=-1){
                return index;
            }
            for (Guest s : this.asteptare){
                if (s.getPhoneNumber().equals(emailORPhoneNumber)){
                    index[0] = this.asteptare.indexOf(s);
                    index[1] = 2;
                    index[2] = 2;
                }
            }
            return index;

        }
    }

    public boolean eliminare(String nume, String prenume){
        int [] num = {-1,-1,-1};
        int [] rez = locationFinder(nume,prenume);
        if (rez[0] == num[0] && rez[1] == num[1]){
            System.out.println("There is no such a person to be removed");
            return false;
        }
        else{
            if (rez[1]==1){     //Is a Participation list
                this.lista.remove(rez[0]);
                this.lista.add(this.asteptare.get(0));
                this.asteptare.remove(0);
                return true;
            }
            else{       //Is a Waiting list
                this.asteptare.remove(rez[1]);
                return true;
            }
        }
    }

    public boolean eliminare(String emailORPhoneNumber){
        int [] num = {-1,-1,-1};
        int [] rez = locationFinder(emailORPhoneNumber);
        if (rez[0] == num[0] && rez[1] == num[1]){
            System.out.println("There is no such a person to be removed");
            return false;
        }
        else{
            if (rez[1]==1){     //Is a Participation list
                this.lista.remove(rez[0]);
                if (this.asteptare.size()!=0){
                    this.lista.add(this.asteptare.get(0));
                    this.asteptare.remove(0);
                }

                return true;
            }
            else{       //Is a Waiting list
                this.asteptare.remove(rez[1]);
                return true;
            }
        }

    }

    public boolean acualizare(int[] locul, String nume1, String prenume1){
        nume1 = nume1.toLowerCase().trim();
        prenume1 = prenume1.toLowerCase().trim();
        int[] rez = locul;
        int[] num = {-1,-1,-1};
        if(rez[0] == num[0] && rez[1] == num[1]){
            System.out.println("There is no such a person");
            return false;
        }
        else {
            if (rez[1] ==1){    //Is a Participation list
                this.lista.get(rez[0]).setLastName(nume1);
                this.lista.get(rez[0]).setFirstName(prenume1);
                System.out.println("Datele au fost actualizate");
                return true;
            }
            else {  //Is a Waiting list
                this.asteptare.get(rez[0]).setLastName(nume1);
                this.asteptare.get(rez[0]).setFirstName(prenume1);
                System.out.println("Datele au fost actualizate");
                return true;
            }
        }
    }

    public boolean actualizare(int[] locul, String emailORPhoneNumber1){
        if (!emailORPhoneNumber1.contains("@") && !(emailORPhoneNumber1.charAt(0) + "").equals("0")){
            emailORPhoneNumber1 = "0" + emailORPhoneNumber1;
        }
        int[] rez = locul;
        int[] num = {-1,-1,-1};
        if(rez[0] == num[0] && rez[1] == num[1]){
            System.out.println("There is no such a person");
            return false;
        }
        else {
            if (rez[1] == 1 && rez[2] == 1){    //Participation list && is an email
                this.lista.get(rez[0]).setEmail(emailORPhoneNumber1);
                return true;
            }
            else if(rez[1] == 2 && rez[2] == 1){    //Waiting list && is an email
                this.asteptare.get(rez[0]).setEmail(emailORPhoneNumber1);
                return true;
            }
            else if(rez[1] == 1 && rez[2] == 2){    //Participation list && is a phone number
                this.lista.get(rez[0]).setPhoneNumber(emailORPhoneNumber1);
                return true;
            }
            else if (rez[1] == 2 && rez[2] == 2){   //Waiting list && is a phone number
                this.asteptare.get(rez[0]).setPhoneNumber(emailORPhoneNumber1);
                return true;
            }
        }
        System.out.println("Something went wrong");
        return false;
    }

    public ArrayList<Guest> getLista() {
        return this.lista;
    }

    public ArrayList<Guest> getAsteptare() {
        return asteptare;
    }

    public int spotsLeft(){
        return Math.abs(this.lista.size()-this.nrLocEveniment);
    }

    public int spotsParticipare(){
        return this.lista.size();
    }

    public int spotsAstepare(){
        return this.asteptare.size();
    }

    public int spotsTotal(){
        return (spotsAstepare()+spotsParticipare());
    }

    public ArrayList<Guest> partialSearch(String searCh){
        this.partialSearchList.clear();
        searCh = searCh.toLowerCase();
        if (searCh.length()<2){
            System.out.println("Fail! Numarul de simboluri pentru cautare trebuie sa fie mai mare de 2");
            return this.partialSearchList;
        }

        for (Guest s : this.lista){
            if (s.getPhoneNumber().contains(searCh) || s.getEmail().contains(searCh) ||
                    s.getLastName().contains(searCh) || s.getFirstName().contains(searCh)){
                this.partialSearchList.add(s);
            }
        }
        for (Guest s : this.asteptare){
            if (s.getPhoneNumber().contains(searCh) || s.getEmail().contains(searCh) ||
                    s.getLastName().contains(searCh) || s.getFirstName().contains(searCh)){
                this.partialSearchList.add(s);
            }
        }
        return this.partialSearchList;
    }
}


