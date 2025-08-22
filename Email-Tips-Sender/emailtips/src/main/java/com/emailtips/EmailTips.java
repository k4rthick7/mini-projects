package com.emailtips;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class EmailTips{
    ArrayList<String>tips = new ArrayList<String>();
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {

         public void EmailTips(){
            try{ 
                tips.addAll(Files.readAllLines(Path.of("D:/project password/Email-Tips-Sender/tip.txt")));
        }catch(Exception e){
            System.out.println("No file Exixt" + e);
        }
        }

        @Override
        public void run() {
            
            
        }
        
    };
    


    public static void main(String[] args) {
        EmailTips t1 = new EmailTips();
        t1.timer.schedule(t1.task,5000,1000*60*60*24);

        System.out.println(t1.tips);

    }
}