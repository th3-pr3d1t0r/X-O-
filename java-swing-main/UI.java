import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("Physics");
    JTextField tfMass = new JTextField("Enter mass");
    JTextField tfAcceleration = new JTextField("Enter acceleration");
    JButton btnCAlculate =  new JButton("Calculate");

    void drawUI(){
        window.add(tfMass);
        window.add(tfAcceleration);
        window.add(btnCAlculate);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        btnCAlculate.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                Physics calc = new Physics();
                try {
                    float mass = Float.valueOf(tfMass.getText());
                    float acceleration = Float.valueOf(tfAcceleration.getText());
                    JOptionPane.showMessageDialog(null, calc.calculateForce(mass, acceleration));
                } catch (NumberFormatException nfe) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(null, "Enter only Numeric Values");
                    nfe.printStackTrace();
                } catch( Exception ex ){
                    JOptionPane.showMessageDialog(null, "Something Strange just happened");
                }
                
            }
        });

        window.setLayout(new GridLayout(3, 1));;
        window.setSize(200, 250);
        window.setVisible(true);
    }
}
