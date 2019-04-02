import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenController implements ActionListener {
    MainScreen mainScreen;
    SQLiteDataAccess myDB;
    ProductView pview = new ProductView();
    CheckoutView cView = new CheckoutView();

    public MainScreenController(MainScreen main, SQLiteDataAccess dao) {
        mainScreen = main;
        myDB = dao;
        mainScreen.update_add_item.addActionListener(this);
        mainScreen.checkout.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mainScreen.update_add_item) {      // button update/add is clicked
            updateAddScreen();
        }

        if (e.getSource() == mainScreen.checkout) {      // button checkout is clicked
            checkoutScreen();
        }

    }
    private void checkoutScreen() {
        cView.show();
    }

    private void updateAddScreen() {

      pview.show();
    }

}
