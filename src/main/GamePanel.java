package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 200;
    private float xDir = 1f, yDir = 1f;
    private Color color = new Color(150, 20,90);
    private Random random;

    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int value){
     this.xDelta += value;
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta , (int)yDelta , 200, 50);
        //g.fillRect(random.nextInt(100), random.nextInt(50), 200, 50);

    }

    private void updateRectangle(){
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0){
            xDir *= -1;
            color = getRandomColor();
        }
        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0){
            yDir *= -1;
            color = getRandomColor();
        }
    }
    private Color getRandomColor(){
        int r =random.nextInt(255);
        int g =random.nextInt(255);
        int b =random.nextInt(255);
        return new Color(r,g, b);
    }

}
