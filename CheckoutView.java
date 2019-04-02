import javax.swing.*;
import java.awt.*;

public class CheckoutView extends JFrame {
    public JTextField barcode = new JTextField(30);
    public JTextField subtotal = new JTextField(30);
    public JTextField tax = new JTextField(30);
    public JTextField total = new JTextField(30);
    //public JTextField paymentMethod = new JTextField(50);
    public JTextField addedToCart = new JTextField(30);
    public JButton complete = new JButton("Complete Sale");
    public JButton cart = new JButton("Add To Cart");
    public JButton credit_debit = new JButton("Credit/Debit");
    public JButton cash = new JButton("Cash");
    public JButton check = new JButton("Check");

    public CheckoutView() {

        this.setTitle("Checkout");
        this.setSize(new Dimension(800, 500));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel line1 = new JPanel();
        line1.add(new JLabel("Product ID"));
        line1.add(barcode);
        line1.add(cart);
        this.getContentPane().add(line1);

        JPanel cartView = new JPanel();
        cartView.add(new JLabel("Cart"));
        cartView.add(addedToCart);
        this.getContentPane().add(cartView);

        JPanel line2 = new JPanel();
        line2.add(new JLabel("Subtotal"));
        line2.add(subtotal);
        this.getContentPane().add(line2);

        JPanel line3 = new JPanel();
        line3.add(new JLabel("Tax"));
        line3.add(tax);
        this.getContentPane().add(line3);

        JPanel line4 = new JPanel();
        line4.add(new JLabel("Total" ));
        line4.add(total);
        this.getContentPane().add(line4);

        JPanel line5 = new JPanel();
        line5.add(new JLabel("Payment Method"));
        line5.add(credit_debit);
        line5.add(cash);
        line5.add(check);
        this.getContentPane().add(line5);

        JPanel buttonComplete = new JPanel();

        buttonComplete.add(complete);



        this.getContentPane().add(buttonComplete);
    }

}
