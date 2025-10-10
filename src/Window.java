import javax.swing.*;

public class Window extends JFrame {
    public Window(String header) {
        super(header);
        setSize(700, 500);
        setLocationRelativeTo(null); // set AFTER size
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void refresh() {
        repaint();
        revalidate();
    }
}
