
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WelcomeScreen extends JPanel {

    JLabel title;
    JButton go;
    JButton quit;

    MainWindow mw;

    public void setTitle(String t) {
        title.setText(t);
    }

    public void quitButtonActionListener() {
        if (JOptionPane.showConfirmDialog(this, "Are you sure?") == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    public void goButtonActionListener() {
        mw.showCard("Two");
    }

    public WelcomeScreen(MainWindow mw) {
        this.mw = mw;

        final String new_game_button_text = "New Game";
        final String quit_button_text = "Quit";
        final int box_layout_axis = BoxLayout.PAGE_AXIS;

        setLayout(new BoxLayout(this, box_layout_axis));
        title = new JLabel();
        add(title);

        // add formatting here
        go = new JButton(new_game_button_text);
        quit = new JButton(quit_button_text);

        go.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                goButtonActionListener();
            }
        });

        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                quitButtonActionListener();
            }
        });

        add(go);
        add(quit);
    }
}
