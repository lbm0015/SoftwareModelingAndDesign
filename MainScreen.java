import javax.swing.*;
import java.awt.*;
public class MainScreen extends JFrame {
    public JButton update_add_item = new JButton("Update/Add Item");
    public JButton checkout = new JButton("Checkout");

    public MainScreen() {
        this.setTitle("Main Screen");
        this.setSize(new Dimension(800, 500));
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(update_add_item);
        buttonPanel.add(checkout);
        this.getContentPane().add(buttonPanel);
    }
}
