import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Stopwatch extends JFrame implements ActionListener{
    
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JButton lapButton = new JButton("LAP");
    JLabel timeLabel = new JLabel();
    
    int elapsedTime = 0;
    int hours = 0, minutes = 0, seconds = 0;
    boolean started = false;

    String seconds_String = String.format("%02d", seconds);
    String minutes_String = String.format("%02d", minutes);
    String hours_String = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e){
            elapsedTime += 1000;

            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;

            seconds_String = String.format("%02d", seconds);
            minutes_String = String.format("%02d", minutes);
            hours_String = String.format("%02d", hours);

            timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
        }
    });
    Stopwatch(){
        timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        add(timeLabel);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        add(startButton);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        add(resetButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 420);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            
            if(started == false){
                started = true;
                startButton.setText("STOP");
                start();
            }
            else{
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource() == resetButton){
            started = false;
            startButton.setText("START");

            reset();
        }
    }
    void stop(){
        timer.stop();
    }

    void start(){
        timer.start();
    }

    void reset(){
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        seconds_String = String.format("%02d", seconds);
        minutes_String = String.format("%02d", minutes);
        hours_String = String.format("%02d", hours);

        timeLabel.setText(hours_String + ":" + minutes_String + ":" + seconds_String);
    }
}
