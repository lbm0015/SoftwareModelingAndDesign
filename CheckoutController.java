import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CheckoutController implements ActionListener {

    ProductView pView;
    SQLiteDataAccess myDB;
    MainScreen mainScreen = new MainScreen();
    CheckoutView cView;
    ProductModel prodMod = new ProductModel();
    double subtotals = 0.0;
    double taxes = 0.0;
    double totals = 0.0;
    double dollars = 0;
    double change = 0;
    double temp = 0;
    private static DecimalFormat df = new DecimalFormat("#.00");

    public CheckoutController(CheckoutView view, SQLiteDataAccess dao) {
        cView = view;
        myDB = dao;
        cView.complete.addActionListener(this);
        cView.cart.addActionListener(this);
        cView.check.addActionListener(this);
        cView.credit_debit.addActionListener(this);
        cView.cash.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cView.complete) {      // button Load is clicked
            checkoutComplete();
        }
        if (e.getSource() == cView.cart) {
            addToCart();
        }
        if (e.getSource() == cView.cash) {
            cashPayment();
        }
        if(e.getSource() == cView.credit_debit) {
            creditDebitPayment();
        }
        if(e.getSource() == cView.check) {
            checkPayment();
        }

    }

    private void addToCart() {

        int prodID = Integer.parseInt(cView.barcode.getText());
        prodMod = myDB.loadProduct(prodID);
        subtotals += prodMod.price;
        cView.subtotal.setText(String.valueOf(df.format(subtotals)));
        taxes += (prodMod.price * .10);
        cView.tax.setText(String.valueOf(df.format(taxes)));
        totals += (subtotals + taxes);
        cView.total.setText(String.valueOf(df.format(totals)));
        cView.addedToCart.setText("Product Name: " + prodMod.name + "  ||  Price: $" + prodMod.price + "  ||  Added to Cart");
    }

    private void checkoutComplete() {

        JOptionPane.showMessageDialog(null, "Checkout Completed Successfully!");
        mainScreen.show();

    }

    private void cashPayment() {
        dollars = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Amount of Cash Received", temp));
        change = dollars - totals;
        JOptionPane.showMessageDialog(null, "Cash Drawer Open: Please Place Cash in Drawer, Retrieve $" + df.format(change) + ", and Press Complete Sale");


    }

    private void creditDebitPayment() {
        double amount = 0;
        amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please Swipe Credit/Debit Card", temp));
        JOptionPane.showMessageDialog(null, "Swipe Successful: Please Press Complete Sale");

    }

    private void checkPayment() {
        int checkNum = 0;
        checkNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter the Check Number", temp));
        JOptionPane.showMessageDialog(null, "Cash Drawer Open: Please Place Check in Drawer and Press Complete Sale");
    }
}
