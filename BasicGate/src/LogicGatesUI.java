import javax.swing.*;
import java.awt.*;

public class LogicGatesUI extends JFrame {

    public LogicGatesUI() {
        setResizable(false);
        setTitle("Logic Gates Model");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GatePanel gatePanel = new GatePanel();
        add(gatePanel);

        JLabel title = new JLabel("LOGIC GATES", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setBounds(200, 10, 200, 30);
        gatePanel.add(title);

        JToggleButton powerButton = new JToggleButton("OFF");
        powerButton.setBounds(500, 330, 100, 30);
        powerButton.setFocusable(false);
        powerButton.setBackground(Color.WHITE);
        powerButton.addActionListener(e -> gatePanel.setPower(powerButton.isSelected()));
        gatePanel.add(powerButton);

        JToggleButton inputAButton = new JToggleButton("A = 0");
        inputAButton.setBounds(500, 90, 100, 30);
        inputAButton.setFocusable(false);
        inputAButton.setBackground(Color.BLACK);
        inputAButton.setForeground(Color.ORANGE);
        inputAButton.addActionListener(e -> {
            gatePanel.setInputA(inputAButton.isSelected());
            inputAButton.setText(inputAButton.isSelected() ? "A = 1" : "A = 0");
            inputAButton.setForeground(inputAButton.isSelected() ? Color.BLACK : Color.ORANGE);
        });
        gatePanel.add(inputAButton);

        JToggleButton inputBButton = new JToggleButton("B = 0");
        inputBButton.setBounds(500, 130, 100, 30);
        inputBButton.setFocusable(false);
        inputBButton.setBackground(Color.BLACK);
        inputBButton.setForeground(Color.ORANGE);
        inputBButton.addActionListener(e -> {
            gatePanel.setInputB(inputBButton.isSelected());
            inputBButton.setText(inputBButton.isSelected() ? "B = 1" : "B = 0");
            inputBButton.setForeground(inputBButton.isSelected() ? Color.BLACK : Color.ORANGE);
        });
        gatePanel.add(inputBButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LogicGatesUI::new);
    }
}
