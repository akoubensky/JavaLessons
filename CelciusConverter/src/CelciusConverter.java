import javax.swing.*;

public class CelciusConverter extends JFrame {
    private JPanel myPanel;
    private JTextField celciusField;
    private JButton convertButton;
    private JLabel cLabel;
    private JLabel farLabel;

    public CelciusConverter() {
        super("CelciusConverter");
        createGUIComponents();
    }

    public void createGUIComponents() {
        convertButton.addActionListener(e -> {
            // Пробуем преобразовать заданное вещественное число в градусы по Фаренгейту.
            String labelText = "По Фаренгейту: ";
            try {
                int tempFahr = (int)((Double.parseDouble(celciusField.getText()))
                        * 1.8 + 32);
                farLabel.setText(labelText + tempFahr);
            } catch (NumberFormatException x) {
                farLabel.setText(labelText + "??");
            }
            ((JFrame)myPanel.getRootPane().getParent()).pack();
        });

        setContentPane(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        CelciusConverter frame = new CelciusConverter();

    }
}
