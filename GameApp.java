package projekat3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GameApp extends JFrame {
    private final JTextField nameField = new JTextField("Harry Potter");
    private final JTextField healthField = new JTextField("90");
    private final JTextField xField = new JTextField("12");
    private final JTextField yField = new JTextField("9");
    private final JComboBox<String> colliderBox = new JComboBox<>(new String[]{
        "Pravougaonik 40x24",
        "Kvadrat 32x32"
    });

    private final JTextArea outputArea = new JTextArea(18, 45);
    private Game currentGame;

    public GameApp() {
        super("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 6, 6));
        formPanel.add(new JLabel("Ime:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Health (0-100):"));
        formPanel.add(healthField);
        formPanel.add(new JLabel("X pozicija:"));
        formPanel.add(xField);
        formPanel.add(new JLabel("Y pozicija:"));
        formPanel.add(yField);
        formPanel.add(new JLabel("Kolajder:"));
        formPanel.add(colliderBox);

        JButton startButton = new JButton("Pokreni igru");
        JButton saveButton = new JButton("Sačuvaj");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 6, 6));
        buttonPanel.add(startButton);
        buttonPanel.add(saveButton);

        leftPanel.add(formPanel, BorderLayout.NORTH);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        outputArea.setEditable(false);
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.add(new JLabel("Rezultat:"), BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> startGame());
        saveButton.addActionListener(e -> saveGame());

        pack();
        setLocationRelativeTo(null);
    }

    private void startGame() {
        try {
            String name = nameField.getText();
            int health = Integer.parseInt(healthField.getText().trim());
            int x = Integer.parseInt(xField.getText().trim());
            int y = Integer.parseInt(yField.getText().trim());

            Collidable collider = colliderBox.getSelectedIndex() == 0
                    ? new RectangleCollider(40, 24)
                    : new SquareCollider(32);

            Player player = new Player(x, y, collider, name, health);
            Game game = new Game(player);

            ArrayList<Enemy> loadedEnemies = Game.loadEnemiesFromFile("enemies.txt");
            for (Enemy enemy : loadedEnemies) {
                game.addEnemy(enemy);
            }

            ArrayList<Enemy> collidingBefore = game.collidingWithPlayer();
            game.resolveCollisions();
            currentGame = game;

            StringBuilder sb = new StringBuilder();
            sb.append("STATUS: ").append(player.toString()).append("\n\n");
            sb.append("NEPRIJATELJI (").append(game.getEnemies().size()).append("):\n");
            for (Enemy enemy : game.getEnemies()) {
                sb.append("  ").append(enemy.toString()).append("\n");
            }

            sb.append("\nU KOLIZIJI SA IGRACEM (").append(collidingBefore.size()).append("):\n");
            for (Enemy enemy : collidingBefore) {
                sb.append("  ").append(enemy.getType()).append("\n");
            }

            sb.append("\nLOG:\n");
            for (String log : game.getEventLog()) {
                sb.append("  ").append(log).append("\n");
            }

            outputArea.setText(sb.toString());

            if (player.getHealth() > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Igrač " + player.getName() + " je preživio sa " + player.getHealth() + " HP!",
                        "Kraj igre",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Igrač " + player.getName() + " je poražen!",
                        "Kraj igre",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Greška: " + ex.getMessage(),
                    "Greška",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void saveGame() {
        if (currentGame == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Prvo pokrenite igru.",
                    "Obavještenje",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        try {
            currentGame.saveToFile("rezultat.txt");
            JOptionPane.showMessageDialog(
                    this,
                    "Rezultat je sačuvan u rezultat.txt.",
                    "Sačuvano",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Greška pri čuvanju: " + ex.getMessage(),
                    "Greška",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameApp().setVisible(true));
    }
}
