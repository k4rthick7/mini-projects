import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;
import java.io.File;

class GamePanel extends JPanel implements KeyListener{
    Random random = new Random();
        int size;
        int screenWidth = 600;
        int screenHeight = 600;
        int unitSize = 25;
        int speed = 100;
        int snakeX = 100;
        int snakeY = 100;
        String direction = "right";
        int appleX = random.nextInt(screenWidth / unitSize)*unitSize;
        int appleY = random.nextInt(screenWidth / unitSize)*unitSize;
        Timer timer;
        int score = 0;
        boolean gameOver = false;
        ArrayList<Point> snakeBody = new ArrayList<Point>();
        Image image;
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
        // Snake
            g.setColor(Color.GREEN);
            g.fillRect(snakeX, snakeY, unitSize, unitSize);
        // Apple
            g.setColor(Color.RED);
            g.fillRect(appleX, appleY, unitSize, unitSize);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Score: "+score,10,20);
            for(int i = 0;i<snakeBody.size();i++){
            Point p = snakeBody.get(i);
                g.setColor(Color.YELLOW);
                g.fillRect(p.x, p.y, unitSize, unitSize);
            }
            if(gameOver == true){
                g.drawImage(image,0,0,screenWidth,screenHeight,this);
                g.setColor(Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("Game Over", 180, 350 );
                g.setFont(new Font("Arial", Font.BOLD, 50));
                g.drawString("U Fucked Up!", 150, 400);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.PLAIN, 30));
                g.drawString("Score: " + score, screenWidth / 2 - 40, 450);
            }
        }
        @Override
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == 39 ) {
                if(!direction.equals("left")){
                    direction = "right";
                    }
            }
            else if (e.getKeyCode() == 37) {
                if(!direction.equals("right")){
                direction = "left";
                }
            }
            else if (e.getKeyCode() == 38) {
                if(!direction.equals("down")){
                direction = "up";
                }
            }
            else if (e.getKeyCode() == 40) {
                if(!direction.equals("up")){
                direction = "down";
                }
            }
            
        }
        public void keyTyped(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){

        }
        public GamePanel(int setSize){
            this.size = setSize;
            setPreferredSize(new Dimension(size, size));
            setBackground(Color.BLACK);  
            try{
                image = ImageIO.read(new File("D:\\project-password\\Snake Game (multiplayer)\\img2.jpg"));
            }catch(Exception e){
                System.out.println(e);
            }
            timer = new Timer(speed, new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    snakeBody.add(new Point(snakeX,snakeY));
                    if(appleX == snakeX&& appleY == snakeY){
                    appleX = random.nextInt(screenWidth / unitSize)*unitSize;
                    appleY = random.nextInt(screenWidth / unitSize)*unitSize;
                    score+=1;
                    }else{
                        snakeBody.remove(0);
                    }
                    if(direction.equals("right")){
                        snakeX += unitSize;
                        
                    }
                    else if(direction.equals("left")){
                        snakeX -= unitSize;
                    }
                    else if(direction.equals("up")){
                        snakeY -= unitSize;
                    }
                    else if(direction.equals("down")){
                        snakeY += unitSize;
                    }
                    repaint();
                    for(int i = 1;i<snakeBody.size();i++){
                      if(snakeBody.get(0).equals(snakeBody.get(i))){
                        close();
                         }
                    }
                    if(snakeX >= screenWidth){
                        snakeX =0;
                    }else if(snakeX < 0){
                        snakeX = screenWidth - unitSize;
                    }else if(snakeY >= screenHeight){
                        snakeY =0;
                    }else if(snakeY < 0){
                        snakeY = screenHeight - unitSize;
                    }
                }

            });
            timer.start();
             
        }
        public void close(){
            timer.stop();
            gameOver = true;
           int ans = JOptionPane.showConfirmDialog(null,"\"Game Over! Your score is:" +score +". Do you want to restart?\"","Game Over",JOptionPane.ERROR_MESSAGE,JOptionPane.YES_NO_OPTION);
           // YES
           if(ans==0){
                score = 0;
                snakeBody.clear();
                appleX = random.nextInt(screenWidth / unitSize)*unitSize;
                appleY = random.nextInt(screenWidth / unitSize)*unitSize;
                timer.start();
            }
            // NO
            else if(ans== 1){
                System.exit(0);
            }
        }
}
public class Main{
    public static void main(String[] args) {
        JFrame snakeGame = new JFrame();
        GamePanel gamePanel = new GamePanel(600);
        snakeGame.setTitle("SnakeGame");
        snakeGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakeGame.setResizable(true);
        snakeGame.add(gamePanel);
        snakeGame.pack();
        snakeGame.setVisible(true);
        snakeGame.addKeyListener(gamePanel);

        // checking testtttinggg
        
    }
}