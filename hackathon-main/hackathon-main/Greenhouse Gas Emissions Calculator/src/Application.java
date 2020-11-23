import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.lang.Math;

public class Application implements ActionListener{
    Calculator calc = new Calculator();
    private static JLabel label;
    private static JLabel unitLabel;
    private static JTextField userText;
    private static JButton submitButton;
    private static JOptionPane JOptionPane;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    JLabel resultLabel = new JLabel();
    private static double nationalMean = 20.2; //mean national UK househould emission in kg 
    
    public static void main(String[] args){
        
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program will terminate upon closing the frame
        frame.add(panel);
        
        panel.setLayout(null);
        
        //labels for input
        label = new JLabel("Volume of gas emitted on your gas bill:"); 
        unitLabel = new JLabel("M³");
        label.setFont(new Font("Verdana", Font.PLAIN, 18)); //changes font and size of the label
        unitLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        label.setBounds(100, 50, 400, 25);
        unitLabel.setBounds(580, 50, 200, 25);
        panel.add(label);
        panel.add(unitLabel);
        
        //text box for user input
        userText = new JTextField();
        userText.setBounds(480, 50, 100, 25);
        userText.setFont(new Font("Verdana", Font.BOLD, 15)); //changes font and size of text in box
        panel.add(userText);
        
        //button for submission
        submitButton = new JButton("Calculate");
        submitButton.setBounds(650, 50, 115, 25);
        submitButton.setFont(new Font("Verdana", Font.BOLD, 15));
        submitButton.addActionListener(new Application());
        panel.add(submitButton);
 
         
        frame.setVisible(true);
    }
    
    /**
     *
     */
   
   
    
    //executes when button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        //will reset the text on the result label each time the button is clicked
        resultLabel.setText("");
            if(!userText.getText().equals("")){
                if(userText.getText().matches("[a-z]+")){
                    JOptionPane.showMessageDialog(frame, "wrong data type");
                }
                calc.nGassBill = Double.parseDouble(userText.getText());
                double pos_or_neg = nationalMean - (calc.total()*1000);
                if(pos_or_neg < 0){
                    double temp_value = Math.abs(pos_or_neg);
                    double percent = (temp_value/nationalMean)*100;
                    percent = (int) (percent*100);
                    resultLabel.setText("<html>Carbon Dioxide: " + calc.nCarbonOxide + "g" +
                            "<br/>Methane: " + calc.nMethane + "g" +
                            "<br/>Nitrous Oxide: " + calc.nNitrogen + "g" +
                            "<br/>Total Emission: " + calc.total() + " tonnes.<br/>" 
                            + percent/100 + "% more then the national mean</html>");
                }
                else{
                    double percent = (pos_or_neg/nationalMean)*100;
                    percent = (int) (percent*100);
                    resultLabel.setText("<html>Carbon Dioxide: " + calc.nCarbonOxide + "g" +
                            "<br/>Methane: " + calc.nMethane + "g" +
                            "<br/>Nitrous Oxide: " + calc.nNitrogen + "g" +
                            "<br/>Total Emission: " + calc.total() + " tonnes.<br/>" 
                            + percent/100 + "% more then the national mean</html>");
                }
                resultLabel.setFont(new Font("Arial", Font.PLAIN, 18));
                resultLabel.setBounds(300, 100, 300, 100);
                panel.add(resultLabel);
                panel.repaint();
                
            }
        }
 
    }
        


    


