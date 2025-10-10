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

// creating placeholder admin "account" details
private static String CORRECT_USERNAME = "admin";
private static String CORRECT_PASSWORD = "1234";
void main () {

    // creating test store
    Store myStore = createTestStore();

    // creating window (extension of JFrame) and JPanel
    Window window = new Window("Game Store Management System");
    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
    //mainPanel.setBackground(Color.GREEN);

    // components
    JLabel storeName = new JLabel(myStore.name);
    storeName.setFont(new Font("Segoe UI", Font.BOLD, 32));
    storeName.setHorizontalAlignment(SwingConstants.CENTER);
    storeName.setForeground(Color.BLACK);
    mainPanel.add(storeName, BorderLayout.NORTH);

    Dimension fieldSize = new Dimension(300, 30);
    JTextField usernameField = new JTextField();
    usernameField.setPreferredSize(fieldSize);
    JPasswordField passwordField = new JPasswordField();
    passwordField.setPreferredSize(fieldSize);

    JButton signInButton = new JButton("Sign in");
    signInButton.setSize(60,30);

    JLabel resultLabel = new JLabel();
    resultLabel.setFont(new Font("Segoe UI", Font.ITALIC, 20));
    resultLabel.setVerticalAlignment(SwingConstants.TOP);
    // check if correct login, event listener
    signInButton.addActionListener(event -> {
        String enteredUsername = usernameField.getText();
        String enteredPassword = new String(passwordField.getPassword());

        if (enteredUsername.equals(CORRECT_USERNAME) && enteredPassword.equals(CORRECT_PASSWORD))
            resultLabel.setText("Login successful!");
        else {
            resultLabel.setText("Login failed. Please check your credentials.");
        }
    });

    // building panels
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); // stack components on y axis
    //formPanel.setBackground(Color.PINK);

    JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    userPanel.add(new JLabel("Username: "));
    userPanel.add(usernameField);

    JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    passwordPanel.add(new JLabel("Password: "));
    passwordPanel.add(passwordField);

    JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    resultPanel.add(resultLabel);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    buttonPanel.add(signInButton);

    mainPanel.add(formPanel, SwingConstants.CENTER); // add form panel to center of main
    formPanel.add(userPanel);
    formPanel.add(passwordPanel);
    formPanel.add(buttonPanel);
    mainPanel.add(resultPanel, BorderLayout.SOUTH);

    window.add(mainPanel, BorderLayout.CENTER);
    window.setVisible(true);

    }