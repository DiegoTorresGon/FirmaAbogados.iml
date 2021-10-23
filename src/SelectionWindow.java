import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionWindow extends JFrame{
    private JButton btIndividual;
    private JButton btGlobal = new JButton("Vista global");
    private JTextArea tIndication;

    private final int WIDTH = 600, HEIGHT = 200;

    public SelectionWindow() {
        super("LawFirm Employee list");
        setVisible(true);
        setLocation(400,40);
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tIndication.append("Elige la vista para debplegar los empleados");

        btGlobal.setVisible(true);

        btIndividual.setVisible(true);

        btGlobal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btGlobal.updateUI();
            }
        });

        btIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btIndividual.updateUI();
            }
        });
    }
}
