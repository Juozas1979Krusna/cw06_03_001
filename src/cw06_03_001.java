import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class cw06_03_001
{
    static JTextField g;
    // Field members
    static JPanel panel = new JPanel();
    static Integer indexer = 1;
    static List<JTextField> listOfTextFields = new ArrayList<JTextField>();
    public static void main(String[] args)
    {
        // Construct frame
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setPreferredSize(new Dimension(990, 990));
        frame.setTitle("My Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame constraints
        GridBagConstraints frameConstraints = new GridBagConstraints();

        // Construct button
        JButton addButton = new JButton("test");
        addButton.addActionListener(new ButtonListener());

        // Add button to frame
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 0;
        frame.add(addButton, frameConstraints);

        // Construct panel
        panel.setPreferredSize(new Dimension(900, 600));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(LineBorder.createBlackLineBorder());

        // Add panel to frame
        frameConstraints.gridx = 0;
        frameConstraints.gridy = 1;
        frameConstraints.weighty = 1;
        frame.add(panel, frameConstraints);

        // Pack frame
        frame.pack();

        // Make frame visible
        frame.setVisible(true);
    }

    static class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent arg0)
        {
            panel.removeAll();
            GridBagConstraints textFieldConstraints = new GridBagConstraints();
            int rowCnt=4,i,j;
            int timeCount =0 ;
            boolean fixed = false;
            Random rand = new Random();
            boolean Atack = rand.nextBoolean();
            int scoreA = 0;
            int scoreB = 0;
            for(int z=0;z<20;z++) {
                for (i = 0; i < 6; i++) {
                    if (fixed == false) {
                        Atack = rand.nextBoolean();
                    }else{
                        if (Atack == true) {
                            Atack = false;
                        } else {
                            Atack = true;
                        }
                    }
                    timeCount =timeCount +1 ;
                    g = new JTextField();
                    String i_outStrPrint = "";
                    i_outStrPrint = String.valueOf(timeCount);
                    String atack_outStrPrint = "";
                    int reAtack = Math.round(9*rand.nextFloat());
                    if(reAtack == 0) {
                        fixed = true;
                        if (Atack == true) {
                            atack_outStrPrint =" ><<";
                        } else {
                            atack_outStrPrint =" >><";
                        }
                        String A_outStrPrint = "";
                        A_outStrPrint = String.valueOf(scoreA);
                        String B_outStrPrint = "";
                        B_outStrPrint = String.valueOf(scoreB);
                        i_outStrPrint = i_outStrPrint + atack_outStrPrint + " "+A_outStrPrint+":"+B_outStrPrint;
                        g.setText(i_outStrPrint);
                    } else {
                        fixed = false;
                        if (Atack == true) {
                            String goal_outStrPrint = "";
                            int rndScore = Math.round(2*rand.nextFloat());
                            if(rndScore == 0) {
                                fixed = true;
                                scoreB = scoreB + 1;
                                goal_outStrPrint = " goal!";
                            }
                            atack_outStrPrint =" <<" + goal_outStrPrint;
                        } else {
                            String goal_outStrPrint = "";
                            int rndScore = Math.round(3*rand.nextFloat());
                            if(rndScore == 0) {
                                fixed = true;
                                scoreA = scoreA + 1;
                                goal_outStrPrint = " goal!";
                            }
                            atack_outStrPrint =" >>" + goal_outStrPrint;
                        }
                        String A_outStrPrint = "";
                        A_outStrPrint = String.valueOf(scoreA);
                        String B_outStrPrint = "";
                        B_outStrPrint = String.valueOf(scoreB);
                        i_outStrPrint = i_outStrPrint + atack_outStrPrint + " "+A_outStrPrint+":"+B_outStrPrint;
                        g.setText(i_outStrPrint);
                    }
                    textFieldConstraints.gridx = i;
                    textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
                    textFieldConstraints.weightx = 0.5;
                    textFieldConstraints.insets = new Insets(5, 5, 5, 5);
                    textFieldConstraints.gridy = z;
                    panel.add(g, textFieldConstraints);
                    panel.updateUI();
                }
            }
        }
    }
}
