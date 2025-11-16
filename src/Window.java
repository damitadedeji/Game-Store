import javax.swing.*;
import java.awt.*;

Store createTestStore() {
    Store myStore = new Store("Woodhill Games & Electronics Store");
    for (int i = 0; i < 5; i++)
    {
        GameCopy g = new GameCopy("The Simz " + (i + 1), 2000 + (1 + i * 3), Game.Format.DISC, Game.Platform.PS4);
        myStore.addGame(g);
    }
    return myStore;
};

public class Window extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    JPanel center = new JPanel(new BorderLayout());
    JPanel center2 = new JPanel(new BorderLayout());

    // panels = different "pages"
    JPanel logIn = new JPanel();
    JPanel displayMsg = new JPanel();

    // logIn components
    Dimension fieldSize = new Dimension(330, 30);
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton logInButton = new JButton("Log in");

    // log in details -- EVENTUALLY I WILL USE A DATABASE or just another method i know this is not practical!
    private static String CORRECT_USERNAME = "admin";
    private static String CORRECT_PASSWORD = "1234";

    // displayMsg components
    JLabel resultLabel = new JLabel();
    JButton logOutButton = new JButton("Return to log in page");

    public Window(Store store) {
        // setting panel page layouts
        logIn.setLayout(new BoxLayout(logIn, BoxLayout.Y_AXIS));
        displayMsg.setLayout(new BoxLayout(displayMsg, BoxLayout.Y_AXIS));

        // building logIn panel
        logIn.setAlignmentX(SwingConstants.CENTER);
        JLabel storeName = new JLabel(store.name);
        storeName.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        usernameField.setMaximumSize(fieldSize);
        /*JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));       // commenting out sub jpanels to remove extra space
        userPanel.add(new JLabel("Username: "));
        userPanel.add(usernameField);
        logIn.add(userPanel);*/
        JLabel usernameLabel = new JLabel("Username: ");
        logIn.add(storeName);
        logIn.add(usernameLabel);
        logIn.add(usernameField);

        passwordField.setMaximumSize(fieldSize);
        /*JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password: "));
        passwordPanel.add(passwordField);
        logIn.add(passwordPanel);*/
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        logIn.add(passwordLabel);
        logIn.add(passwordField);

        /*JPanel logInButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logInButtonPanel.add(logInButton);
        logIn.add(logInButtonPanel);*/
        logInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logIn.add(logInButton);
        center.add(logIn, BorderLayout.CENTER);
        logIn.setBackground(Color.GREEN);
        center.setBackground(Color.YELLOW);

        // building display msg panel
        resultLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        /*JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        resultPanel.add(resultLabel);*/
        displayMsg.add(resultLabel);

        /*JPanel logOutButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logOutButtonPanel.add(logOutButton);
        displayMsg.add(logOutButtonPanel);*/
        logOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayMsg.add(logOutButton);
        center2.add(displayMsg, BorderLayout.CENTER);
        center2.setBackground(Color.PINK);
        displayMsg.setBackground(Color.ORANGE);

        // add panels to mainPanel
        mainPanel.add(center, "logIn");
        mainPanel.add(center2, "displayMsg");

        // event listeners to switch between
        logInButton.addActionListener(event -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            if (enteredUsername.equals(CORRECT_USERNAME) && enteredPassword.equals(CORRECT_PASSWORD)) {
                resultLabel.setText("Login successful!");
                setTitle("Success!");
            }
            else {
                resultLabel.setText("Login failed. Please check your credentials.");
                setTitle("Try again.");
            }
            cardLayout.show(mainPanel, "displayMsg");
        });

        logOutButton.addActionListener(event -> {
            cardLayout.show(mainPanel, "logIn");
            setTitle("Game Store Management System");
        });

        cardLayout.show(mainPanel, "Game Store Management System");
        setTitle(store.name);
        add(mainPanel);
        setSize(700, 500);
        setLocationRelativeTo(null); // set AFTER size
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}

void main() {
    Store myStore = createTestStore();
    Window w = new Window(myStore);

}
