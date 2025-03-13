import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class Game_Adventure
{
    public static void main(String[] args)
    {
        new Game_Adventure();
    }
    JPanel GameTitlePanel,StartButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JFrame window;
    Container con;
    JLabel GameTitle, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
    JButton StartButton, choice1, choice2, choice3, choice4;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN,28);
    JTextArea mainTextArea;
    TitleScreenHandler tshandler = new TitleScreenHandler();
    int playerHP, goblinHP, specialRing;
    String weapon, position;
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public Game_Adventure()
    {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLUE);
        window.setLayout(null);
        window.setVisible(true);

        con = window.getContentPane();

        GameTitlePanel = new JPanel();
        GameTitlePanel.setBounds(100,100,600,150);
        GameTitlePanel.setBackground(Color.BLUE);
        con.add(GameTitlePanel);

        GameTitle = new JLabel("ADVENTURE");
        GameTitle.setForeground(Color.WHITE);
        GameTitlePanel.add(GameTitle);
        GameTitle.setFont(titleFont);

        StartButtonPanel = new JPanel();
        StartButtonPanel.setBounds(300,400,200,100);
        StartButtonPanel.setBackground(Color.BLUE);
        con.add(StartButtonPanel);

        StartButton = new JButton("START");
        StartButton.setBackground(Color.black);
        StartButton.setForeground(Color.darkGray);
        StartButtonPanel.add(StartButton);
        StartButton.setFont(normalFont);
        StartButton.addActionListener(tshandler);
    }

    public void createGameScreen()
    {
        GameTitlePanel.setVisible(false);
        StartButtonPanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBackground(Color.blue);
        mainTextPanel.setBounds(100,100,600,250);
        con.add(mainTextPanel);
         
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.blue);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBackground(Color.blue);
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("CHOICE 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.darkGray);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("CHOICE 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.darkGray);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("CHOICE 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.darkGray);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("CHOICE 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.darkGray);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP : ");
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabel.setFont(normalFont);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);
        hpNumberLabel.setFont(normalFont);

        weaponLabel = new JLabel("Weapon : ");
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabel.setFont(normalFont);

        weaponNameLabel = new JLabel();
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);
        weaponNameLabel.setFont(normalFont);
        
        playerSetup();
    }

    public void playerSetup()
    {
        playerHP = 15;
        goblinHP = 21;
        weapon = "Dagger";
        weaponNameLabel.setText(weapon);
        hpNumberLabel.setText("" + playerHP);

        townGate();
    }

    public void townGate()
    {
        position = "townGate";
        mainTextArea.setText("You reached the front gate of a town. \nA Guard is standing infront of you. \n\nWhat will you do?");
        choice1.setText("Talk to the Guard");
        choice2.setText("Attack the Guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard()
    {
        position = "talkGuard";
        mainTextArea.setText("Guard : Hello Stranger! I have never seen you before. \nSorry but I can not let a stranger enter our town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard()
    {
        position = "attackGuard";
        mainTextArea.setText("Guard : Hey! Don't be stupid. \n\nThe Guard fought back and hit you hard. \n(You recieve 3 damage)");
        playerHP = playerHP - 3;
        hpNumberLabel.setText(""+playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad()
    {
        position = "crossRoad";
        mainTextArea.setText("You are at the crossroad. \nThe Town is in the south direction.");
        choice1.setText("Go North");
        choice2.setText("Go South");
        choice3.setText("Go East");
        choice4.setText("Go West");
    }

    public void north()
    {
        position = "north";
        mainTextArea.setText("You are at a river. \nYou drink some water from the river and recover \nsome HP. \n\n(Your HP has been recovered by 2)");
        playerHP +=2;
        hpNumberLabel.setText("" + playerHP);
        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east_1()
    {
        position = "east";
        mainTextArea.setText("You came across a chest and found a Katana in it. \n\n(You obtained a Katana)");
        weapon = "Katana";
        weaponNameLabel.setText(weapon);
        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east_2()
    {
        position = "east";
        mainTextArea.setText("You find the open chest from which you \ngot your Katana.");
        choice1.setText("Go West");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void west()
    {
        position = "west";

        if (goblinHP <= 0)
        {
            mainTextArea.setText("You came across the dead body of the goblin which \nyou killed earlier.");
            choice1.setText("Go East");
            choice2.setText("");
            choice3.setText("");
            choice4.setText("");
        }
        else 
        {
            mainTextArea.setText("You encounter a Goblin!");
            choice1.setText("Fight");
            choice2.setText("Run");
            choice3.setText("");
            choice4.setText("");
        }
    }

    public void fight()
    {
        position = "fight";
        mainTextArea.setText("Goblin HP : " + goblinHP + "\n\nWhat will you do?");
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack()
    {
        position = "playerAttack";

        int playerDamage = 0;
        if (weapon.equals("Dagger"))
        {
            playerDamage = new Random().nextInt(3);
        }
        else if (weapon.equals("Katana"))
        {
            playerDamage = new Random().nextInt(8);
        }

        mainTextArea.setText("You attacked the goblin and did " + playerDamage + " damage. ");
        goblinHP -= playerDamage;
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void goblinAttack()
    {
        position = "goblinAttack";
        int goblinDamage = 0;
        goblinDamage = new Random().nextInt(5);
        mainTextArea.setText("The Goblin attacked and did " + goblinDamage + " damage to you.");
        playerHP -= goblinDamage;
        hpNumberLabel.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win()
    {
        position = "win";
        mainTextArea.setText("You killed the goblin! \nThe Goblin dropped a ring. \n\n(You obtained a special ring)");
        specialRing+=1;
        choice1.setText("Go East");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose()
    {
        position = "lose";
        mainTextArea.setText("You Died! \n\n <GAME OVER>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    
    public void gameEnd()
    {
        position = "gameEnd";
        mainTextArea.setText("Guard: Oh! You killed that goblin!? Great! \nIt seems you are a trustworthy guy. \nWelcome to the Town. \n\n<THE END>");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);

    }
    
    public class TitleScreenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String yourChoice = event.getActionCommand();

            switch(position)
            {
                case "townGate":
                switch(yourChoice)
                {
                    case "c1":
                    if(specialRing==1)
                    {
                      gameEnd();
                    }
                    else 
                    {
                        talkGuard();
                    }
                    break;

                    case "c2":
                    attackGuard();
                    break;

                    case "c3":
                    crossRoad();
                    break;
                }
                break;

                case "talkGuard":
                switch (yourChoice) 
                {
                    case "c1":
                    townGate();   
                    break;
                }
                break;

                case "attackGuard":
                switch (yourChoice)
                {
                    case "c1":
                    townGate();
                    break;
                }
                break;

                case "crossRoad":
                switch (yourChoice) 
                {
                    case "c1":
                    north();
                    break;

                    case "c2":
                    townGate();
                    break;

                    case "c3":
                    if (weapon.equals("Dagger"))
                    {
                        east_1();
                    }
                    else if(weapon.equals("Katana"))
                    {
                        east_2();
                    }
                    break;

                    case "c4":
                    west();
                    break;
                }
                break;

                case "north":
                switch(yourChoice)
                {
                    case "c1":
                    crossRoad();
                    break;
                }
                break;

                case "east":
                switch(yourChoice)
                {
                    case "c1":
                    crossRoad();
                    break;
                }
                break;

                case "west":
                switch(yourChoice)
                {
                    case "c1":
                        if (goblinHP > 0) 
                        {
                            fight();
                        }
                        else  
                        {
                            crossRoad();
                        }
                        break;
            
                    case "c2":
                        crossRoad();
                        break;
                }
                break;

                case "fight":
                switch(yourChoice)
                {
                    case "c1":
                    playerAttack();
                    break;

                    case "c2":
                    crossRoad();
                    break;
                }
                break;

                case "playerAttack":
                switch(yourChoice)
                {
                    case "c1":
                    if(goblinHP<1)
                    {
                        win();
                    }
                    else 
                    {
                        goblinAttack();
                    }
                    break;
                }
                break;

                case "goblinAttack":
                switch(yourChoice)
                {
                    case "c1":
                    if(playerHP<1)
                    {
                        lose();
                    }
                    else
                    {
                        fight();
                    }            
                    break;
                }
                break;

                case "win":
                switch(yourChoice)
                {
                    case "c1":
                    crossRoad();
                    break;
                }
                break;

                
            }
        }
    }

}


   
