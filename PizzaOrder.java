import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Ae Xiong 6/11/2016
 * CSci1130 51
 * PizzaOrder - Unit 7
 */
public class PizzaOrder extends JApplet implements ActionListener, ItemListener{
    JLabel titleLable;
    JPanel titlePanel, toppingsPanel, sizePanel, outputPanel;
    JTextArea receipt;
    JButton submit;
    JCheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7, ch8, ch9, ch10;
    JRadioButton r1, r2, r3;
    ButtonGroup sizeGroup;
    int toppingCount;
    Double priceSize, priceTopping, priceTotal;
    Image c;
    String pizzaSize;

    public void init(){
        priceSize=0.0;toppingCount=0;priceTotal=0.00;priceTopping=0.00;pizzaSize="";
        setLayout(new BorderLayout());
        setUpTitle();
        setUpSize();
        setUpToppings();
        setUpOutput();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(c, 45, 120,this);
        g2d.drawString("Pizza Size: "+pizzaSize, 15, 348);
        g2d.drawString("$"+priceSize, 155, 348);
        g2d.drawString(toppingCount+" Toppings(@ $1.99)           $"+priceTopping, 10, 368);
    }
    public void setUpTitle(){
        titlePanel=new JPanel(new FlowLayout());
        titlePanel.setBackground(Color.BLUE);
        titleLable = new JLabel("<html><font size=+5 color=red><i>Ae's Pizza!!!</i></font></html>");
        titlePanel.add(titleLable);
        add(titlePanel, BorderLayout.NORTH);
    }
    public void setUpSize(){
        sizePanel=new JPanel(new FlowLayout());
        sizePanel.setBackground(Color.WHITE);
        sizeGroup= new ButtonGroup();
        r1=new JRadioButton("Medium");r1.setBackground(Color.WHITE);
        r2=new JRadioButton("Large");r2.setBackground(Color.WHITE);
        r3=new JRadioButton("X-Large");r3.setBackground(Color.WHITE);
        sizeGroup.add(r1);sizeGroup.add(r2);sizeGroup.add(r3);
        sizePanel.add(r1);sizePanel.add(r2);sizePanel.add(r3);
        add(sizePanel, BorderLayout.WEST);
        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
    }
    public void setUpToppings(){
        toppingsPanel=new JPanel(new GridLayout(5,2));
        toppingsPanel.setBackground(Color.WHITE);
        ch1= new JCheckBox("Pepperoni");ch1.setFocusPainted(false);ch1.setBackground(Color.WHITE);
        ch2= new JCheckBox("Italian Sausage");ch2.setFocusPainted(false);ch2.setBackground(Color.WHITE);
        ch3= new JCheckBox("Beef");ch3.setFocusPainted(false);ch3.setBackground(Color.WHITE);
        ch4= new JCheckBox("Ham");ch4.setFocusPainted(false);ch4.setBackground(Color.WHITE);
        ch5= new JCheckBox("Bacon");ch5.setFocusPainted(false);ch5.setBackground(Color.WHITE);
        ch6= new JCheckBox("Chicken");ch6.setFocusPainted(false);ch6.setBackground(Color.WHITE);
        ch7= new JCheckBox("Pineapple");ch7.setFocusPainted(false);ch7.setBackground(Color.WHITE);
        ch8= new JCheckBox("Green Peppers");ch8.setFocusPainted(false);ch8.setBackground(Color.WHITE);
        ch9= new JCheckBox("Jalapeno Peppers");ch9.setFocusPainted(false);ch9.setBackground(Color.WHITE);
        ch10= new JCheckBox("Mushrooms");ch10.setFocusPainted(false);ch10.setBackground(Color.WHITE);
        toppingsPanel.add(ch1);toppingsPanel.add(ch2);
        toppingsPanel.add(ch3);toppingsPanel.add(ch4);
        toppingsPanel.add(ch5);toppingsPanel.add(ch6);
        toppingsPanel.add(ch7);toppingsPanel.add(ch8);
        toppingsPanel.add(ch9);toppingsPanel.add(ch10);
        add(toppingsPanel, BorderLayout.CENTER);
        ch1.addItemListener(this);ch2.addItemListener(this);
        ch3.addItemListener(this);ch4.addItemListener(this);
        ch5.addItemListener(this);ch6.addItemListener(this);
        ch7.addItemListener(this);ch8.addItemListener(this);
        ch9.addItemListener(this);ch10.addItemListener(this);
    }
    public void setUpOutput(){
        outputPanel=new JPanel(new FlowLayout());
        outputPanel.setBackground(Color.BLUE);
        receipt=new JTextArea(15,20);
        receipt.setEditable(false);
        receipt.setBackground(Color.WHITE);
        submit=new JButton("Submit Order");
        outputPanel.add(receipt);
        outputPanel.add(submit);
        add(outputPanel, BorderLayout.SOUTH);
        submit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == r1){
            c = getImage(getCodeBase(), "med.jpeg");
            priceSize= 4.99;pizzaSize="Medium";
        }
        if (e.getSource() == r2){
            c = getImage(getCodeBase(), "large.jpeg");
            priceSize=6.99;pizzaSize="Large";
        }
        if (e.getSource() == r3){
            c = getImage(getCodeBase(), "xl.jpeg");
            priceSize=8.99;pizzaSize="Extra-Large";
        }
        if (e.getSource() == submit){
            priceTotal=priceTopping+priceSize;
            receipt.setText("Pizza size: " + pizzaSize +
                    "\nNumber of Toppings: " + toppingCount +
                    "\nTotal Price: $" + priceTotal );
        }
        repaint();
    }
    @Override
    public void itemStateChanged(ItemEvent e){
        Object item=e.getSource();
        if (item==ch1) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch2) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch3) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch4) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;}
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch5) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch6) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch7) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch8) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch9) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        if (item==ch10) {
            if(e.getStateChange()==ItemEvent.SELECTED){
                toppingCount++;
            }
            else if(e.getStateChange()==ItemEvent.DESELECTED){
                toppingCount--;
            }
        }
        priceTopping=(toppingCount*1.99);
        repaint();
    }
}