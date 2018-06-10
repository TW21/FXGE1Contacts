package model;

import java.util.ArrayList;

/**
 * @author Till Wischniewski
 * @version 1.1
 *
 */

public class Contact
{

    private String vorname;
    private String nachname;
    private String photo; //name of the file that contains the photo
    private ArrayList<String> eMails;



    public Contact(String nachname, String vorname, String photo) {
        this.nachname = nachname;
        this.vorname = vorname;
        if (photo != null) {
            this.photo = photo;
        }else {
            this.photo = "nophoto.jpg";
        }

        eMails = new ArrayList<>();
    }


    public String getVorname() {
        return vorname;
    }


    public String getNachname(){
        return nachname;
    }


    /**
     * getter for the name of the file that contains the photo
     * @return the name of the file that contains the photo
     */

    public String getPhoto(){
        return photo;
    }


    public ArrayList<String> geteMails(){
        return eMails;
    }

    @Override
    public String toString(){
        return vorname +" "+ nachname +" "+ photo +" "+"\n "+eMails.toString();
    }


    public void addeMail(String eMail) {
        if (eMail.length() >= 3 && eMail.contains("@")
                && eMail.charAt(0)!='@' && eMail.charAt(eMail.length()-1) != '@') {
            eMails.add(eMail);
        }else {
            System.out.println("Ungültige eMail! ");
        }
    }

    // main method for testing
    public static void main(String[] args) {
        Contact jeremy = new Contact("Jones", "Jeremy", "/resources/jeremy.jpg");
        jeremy.addeMail("jeremy@jonessnowboards.com");
        System.out.println(jeremy);
    }

}