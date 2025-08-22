import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class TaskApp{
    ArrayList<Task> taskList = new ArrayList<Task>();
    // String addTask;

    class Task{
        String taskName;
         boolean isCompleted = false;
    
     public Task(String taskName){
        this.taskName = taskName; 
     }
     public void completed(){
        isCompleted = true;
        System.out.println("Hey Your Task: "+ taskName + " is Completed!.");
     }
     public String toString(){
        if(isCompleted == true){
            return "Your Task: "+ taskName +" [completed]";
        }else{
            return "Your Task: "+ taskName +" [X]";
        }
    }
    } 
    public static void main(String[]args) throws IOException{
        System.out.println("(add for) ➕  Add a new task \n" +
                            "(view for) 📋  View all tasks \n" + 
                            "(mark for) ✅  Mark a task as completed \n"+
                            "(exit) ❌  Exit the app \n"+
                            "Enter Your Choice: \n");
        
        TaskApp adder = new TaskApp();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String filePath = "D:\\project-password\\TaskManager project\\task.txt";
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for(String line:lines){
           String[] t1 = line.split(",");
           String oldTask = t1[0];
          boolean isDone = Boolean.parseBoolean(t1[1]);
          Task addOldTask = adder.new Task(oldTask);
           if(isDone == true){
            addOldTask.completed();
           }
           adder.taskList.add(addOldTask);
        } 
        while(!input.equals("exit")){
            if(input.equals("add")){
                System.out.println("Enter the Task Which You Wanted To Do!");
                String input2 = scan.nextLine();
                // adder.addTask = input2;
                TaskApp.Task tasks = adder.new Task(input2);
                adder.taskList.add(tasks);
            }
            else if(input.equals("view")){
                for(int i= 0;i < adder.taskList.size();i++){
                System.out.println(i+")"+adder.taskList.get(i));
                }
            }   
            else if(input.equals("mark")){
                for(int i= 0;i < adder.taskList.size();i++){
                    System.out.println("["+ i +"]"+ adder.taskList.get(i));
                    System.out.println("Enter The Number Of The Task Which Is Complected\n");
                }
                input = scan.nextLine();
                int num = Integer.parseInt(input);
                adder.taskList.get(num).completed();
                for(int i= 0;i < adder.taskList.size();i++){
                    System.out.println(i+")"+adder.taskList.get(i));
                    }
            }
            input = scan.nextLine();
        }if(input.equals("exit")){
            ArrayList<String> taskString = new ArrayList<String>();
            for(int i = 0;i<adder.taskList.size();i++){
                adder.taskList.get(i);
                taskString.add(adder.taskList.get(i).taskName+","+adder.taskList.get(i).isCompleted);
            }
            var path = Path.of("task.txt");
                Files.write(path,taskString, StandardCharsets.UTF_8);
        }
        scan.close();
    }
}