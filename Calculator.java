import java.awt.*;
import java.awt.event.*;
class Calculator implements ActionListener {
    Frame f;
    double num1 = 0, num2 =0 ,result =0;
    String operator = "";
    TextField tf;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    Calculator() {
        Frame f = new Frame("Calculator");
        MenuBar mb = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem lightMode = new MenuItem("LightMode");
        MenuItem darkMode = new MenuItem("DarkMode");
        menu.add(lightMode);
        menu.add(darkMode);
        mb.add(menu);
        tf = new TextField();
        tf.setBounds(30,50,250,30);
        tf.setEditable(false);
        Panel panel = new Panel();
        panel.setBounds(30,80,250,300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
         b1 = new Button("C");
        b2 = new Button("%");
         b3 = new Button("Sqrt");
         b4 = new Button("/");
         b5 = new Button("7");
         b6 = new Button("8");
         b7 = new Button("9");
         b8 = new Button("+");
         b9 = new Button("4");
         b10 = new Button("5");
         b11 = new Button("6");
         b12 = new Button("*");
         b13 = new Button("1");
         b14 = new Button("2");
         b15 = new Button("3");
         b16 = new Button("-");
         b17 = new Button("+/-");
         b18 = new Button("0");
         b19 = new Button(".");
         b20 = new Button("=");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);
        panel.add(b16);
        panel.add(b17);
        panel.add(b18);
        panel.add(b19);
        panel.add(b20);
        f.add(panel);
        f.add(tf);
        f.setMenuBar(mb);
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
        lightMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.white);
                f.setBackground(Color.white);
                tf.setBackground(Color.white);
            }
        });
        darkMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.black);
                f.setBackground(Color.black);
                tf.setBackground(Color.gray);
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
        String pressed = e.getActionCommand();

        if (pressed.equals("C")) {
            tf.setText("");
            num1 = num2 = result = 0;
            operator = "";
        }
        else if ((pressed.charAt(0) >= '0' && pressed.charAt(0) <= '9') || pressed.equals(".")) {
            tf.setText(tf.getText() + pressed);
        }

        else if (pressed.equals("+") || pressed.equals("-")|| pressed.equals("*") || pressed.equals("/")) {
            num1 = Double.parseDouble(tf.getText());
            operator = pressed;
            tf.setText("");
        }

        else if (pressed.equals("Sqrt")) {
            num1 = Math.sqrt(Double.parseDouble(tf.getText()));
            tf.setText("" + num1);
        }
        else if (pressed.equals("%")) {
            num1 = Double.parseDouble(tf.getText()) / 100;
            tf.setText("" + num1);
        }
        else if (pressed.equals("+/-")) {
            num1 = Double.parseDouble(tf.getText()) * -1;
            tf.setText("" + num1);
        }

        else if (pressed.equals("=")) {
            num2 = Double.parseDouble(tf.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            tf.setText("" + result);
            operator = "";
        }
    }



    public static void main(String[] args) {
        new Calculator();
    }
}
