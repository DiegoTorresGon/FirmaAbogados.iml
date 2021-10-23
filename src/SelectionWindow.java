import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionWindow extends JFrame{
    private JButton btIndividual;
    private JButton btGlobal;
    private JPanel pMain;
    private JTextArea tIndication;

    private final int WIDTH = 600, HEIGHT = 200;

    public SelectionWindow() {

        super("LawFirm Employee list");

        setVisible(true);
        setLocation(400,40);
        setSize(WIDTH,HEIGHT);
        setContentPane(pMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tIndication.append("Elige la vista para desplegar los empleados");

        btGlobal.setVisible(true);

        btIndividual.setVisible(true);

        btGlobal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btGlobal.updateUI();
                setVisible(false);
                GeneralWindow mainWindow = new GeneralWindow();
                dispose();
            }
        });

        btIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btIndividual.updateUI();
                setVisible(false);
                IndividualWindow mainWindow = new IndividualWindow();
                dispose();
            }
        });
    }

}
