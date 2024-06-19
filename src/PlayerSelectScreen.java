
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//needs massive aesthetic rewrites
public class PlayerSelectScreen extends JPanel {

    JButton go;
    JButton quit;
    MainWindow mw;

    JRadioButton opt1;
    JRadioButton opt2;
    JRadioButton opt3;

    public void quitButtonActionListener() {
        mw.showCard("One");
    }

    public void goButtonActionListener() {
        playerOptions();
        mw.s4.setUpPlayers();
        mw.showCard("Three");
    }

    public void playerOptions() {
        int m = 5;
        if (opt1.isSelected() == true) {
            m = 1;
        } else if (opt2.isSelected() == true) {
            m = 2;
        } else if (opt3.isSelected() == true) {
            m = 3;
        }
        mw.s4.setMaxPlayers(m);
    }

    public PlayerSelectScreen(MainWindow mw) {
        this.mw = mw;

        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);

        JLabel messageLabel = new JLabel("Select Players: ");
        JLabel defaultPlayerLabel = new JLabel("Default: 1Player");

        add(messageLabel);
        add(defaultPlayerLabel);

        opt1 = new JRadioButton("1 Player(Default)");
        final boolean isOpt1Selected = true;
        opt1.setSelected(isOpt1Selected);

        opt2 = new JRadioButton("2 Players");
        opt3 = new JRadioButton("3 Players");

        ButtonGroup grp = new ButtonGroup();
        grp.add(opt1);
        grp.add(opt2);
        grp.add(opt3);

        add(opt1);
        add(opt2);
        add(opt3);

        ActionListener playerOptionsListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                playerOptions();
            }
        };

        opt1.addActionListener(playerOptionsListener);
        opt2.addActionListener(playerOptionsListener);
        opt3.addActionListener(playerOptionsListener);

        go = new JButton("Customize Board");
        quit = new JButton("Back");

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
