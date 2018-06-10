package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Contact;

/**
 * @author Till Wischniewski
 * @version 1.1
 *
 * zeigt Kontakte an, incl. Vorname, Nachname, Foto, email.
 */


public class ShowContacts extends Application{

    @Override
    public void start(Stage primaryStage) {
        try {

            ScrollPane root = new ScrollPane();
            VBox box = new VBox();
            box.setSpacing(20);

            ArrayList<Contact> contacts = new ArrayList<>();

            Contact jeremy = new Contact("Jones", "Jeremy", "jeremy.jpg");
            jeremy.addeMail("jeremy@jonessnowboards.com");
            jeremy.addeMail("jones@powder.com");
            jeremy.addeMail("j@jones");
            contacts.add(jeremy);

            Contact travis = new Contact("Rice", "Travis","travis.jpg");
            travis.addeMail("TR@snowboarder.com");
            contacts.add(travis);

            Contact till = new Contact("Wischniewski","Till",null);
            till.addeMail("wischniewskitill@gmail.com");
            contacts.add(till);

            for (Contact c : contacts ) {
                GridPane contactPane = showContact(c);
                box.getChildren().add(contactPane);
            }

            root.setContent(box);
            Scene scene = new Scene(root,350,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane showContact (Contact c) {
        GridPane root = new GridPane();
        // horizontal gap and vertical gap between columns and lines
        root.setHgap(10);
        root.setVgap(10);

        // here space will be added around the grid
        root.setPadding(new Insets(25, 25, 25, 25));

        Label vorname = new Label("Vorname: "+c.getVorname());
        root.add(vorname, 1, 1);

        Label nachname = new Label("Nachname: "+c.getNachname());
        root.add(nachname, 1,2);
        //show image with a circle
        root.add(embedImage(this,c.getPhoto()), 1, 0);

        // first try to show image
        //Image image = new Image (getClass().
        //getResource("/resources/"+c.getPhoto()).toString());

        //ImageView imageview = new ImageView(image);
        //root.add(imageview, 1, 0);

        Label emails = new Label("eMails: ");
        root.add(emails,1, 3);

        root.add(showEMails(c), 1, 4, 2, 1);
        return root;
    }

    private ScrollPane showEMails(Contact c){
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setPadding(new Insets(10, 20, 10, 20));
        int row = 1;
        // the rows of root are dynamically allocated
        ArrayList<String> emails = c.geteMails();
        for (int i=0; i<c.geteMails().size(); i++) {
            String em = emails.get(i);
            root.add(new Label(em), 1, row);

            row++;
        }
        ScrollPane pane = new ScrollPane();
        pane.setContent(root);
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }

    // method embed the image in a circle
    private static StackPane embedImage(ShowContacts sc, String Photo){
        StackPane contact = new StackPane();
        Circle c = new Circle(60);
        c.setFill(Color.GRAY);
        contact.getChildren().add(c);
        Image i = new Image(sc.getClass().getResource("/resources/" + Photo).toString());
        ImageView iv = new ImageView(i);
        iv.setFitHeight(80);
        iv.setFitWidth(80);
        contact.getChildren().add(iv);
        return contact;
    }

}
