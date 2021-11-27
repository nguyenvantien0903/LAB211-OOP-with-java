package taskmaster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NVT
 */
public class TaskManager {
    Scanner sc = new Scanner(System.in);
    int ID=0;
    
    public boolean isInteger(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            Integer res = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
    
    public Integer inputInteger(String mess,int min,int max){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            if(input.equalsIgnoreCase("nope"))
                return -1;
            if(isInteger(input)==true){
                Integer res=Integer.parseInt(input);
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public boolean isDouble(String string) {
        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }
        try {
            Double res = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer or Double.");
        }
        return false;
    }
    
    public Double inputDouble(String mess,double min,double max){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            if(input.equalsIgnoreCase("nope"))
                return -1.0;
            if(isDouble(input)==true){
                Double res=Double.parseDouble(input);
                if(res%0.5!=0){
                    System.out.println("Number must be x.0 or x.5! ");
                    continue;
                }
                if(res<min||res>max){
                    System.out.println("Out of intervel! ");
                    continue;
                }
                return res;
            }
        }
    }
    
    public String inputString(String mess){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            String PATTERN = "[a-zA-Z0-9 ]+";
            if(!input.matches(PATTERN))continue;
            return input;
        }
    }
    
    public boolean validateDate(String strDate){
	if (strDate.trim().equals("")){
	    return true;
	}
	else{
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
	    sdf.setLenient(false);
	    try
	    {
	        Date javaDate = sdf.parse(strDate); 
//	        System.out.println(strDate+" is valid date format");
	    }
	    catch (ParseException e)
	    {
	        System.out.println(strDate+" is Invalid Date format");
	        return false;
	    }
	    return true;
	}
   }
    
    public String inputDate(String mess){
        while(true){
            if(!"".equals(mess))System.out.println(mess);
            String input=sc.nextLine().trim();
            if(input.equalsIgnoreCase("nope")){
                return "nope";
            }
            if(validateDate(input))
                return input;
        }
    }
    
    HashMap<Integer, Task> allTask = new HashMap<>();
    
    TaskManager(){
    
        allTask.put(++ID, new Task(ID,2,"Alpha","Aug-10-2021",8.5,12.0,"Yasuo","Zed"));
        allTask.put(++ID, new Task(ID,3,"Beta","Aug-10-2021",8.0,13.5,"Lux","Garen"));
        allTask.put(++ID, new Task(ID,1,"Gamma","Aug-10-2021",12.5,16.0,"Vi","Urgot"));
    }
    
    public int addTask() throws Exception{
        System.out.println("-------------Add Task-------------");
        String reqName=inputString("Requirement Name: ");
        int taskType=inputInteger("Task Type(1-4): ",1,4);
        String date=inputDate("Date(MMM-DD-YYYY): ");
        Double from=inputDouble("From(8.0-17.5): ",8.0,17.5);
        Double to=inputDouble("To(8.0-17.5): ",from,17.5);
        String ass=inputString("Assignee: ");
        String rev=inputString("Reviewer: ");
        
        allTask.put(++ID, new Task(ID,taskType,reqName,date,from,to,ass,rev));
        return ID;
    }
    
    public String changeDate(String req){
        String res="";
        String temp[]=req.split("-");
        res+=temp[1]+"-"+temp[0]+"-"+temp[2];
        return res;
    }
    
    public List<Task> getDataTasks(){
        System.out.println("---------------------------- Task descending order ---------------------------------");
        System.out.printf("%-10s%-15s%-12s%-15s%-10s%-12s%-12s\n","ID","Name","Task Type","Date","Time","Assignee","Reviewer");
        List<Task> res = new LinkedList<>();
        for(int i = ID; i >= 1; i--)
            if(allTask.containsKey(i)){
                Task x = allTask.get(i);
                res.add(x);
                System.out.printf("%-10d%-15s%-12s%-15s%-10.1f%-12s%-12s\n",x.getId(),x.getReqName(),x.getRealType(),changeDate(x.getDate()),x.getPlanTo()-x.getPlanFrom(),x.getAssignee(),x.getReviewer());
            }
        return res;
    }
    
    public void updateTask() {
        System.out.println("-------------Update Task-------------");
        int id;
        while(true){
            id=inputInteger("Requirement ID: ",1,Integer.MAX_VALUE);
            if(allTask.containsKey(id))break;
            System.out.println("Code does not exist!");
        }
        
        String reqName=inputString("Requirement Name: ");
        if(!reqName.equalsIgnoreCase("nope")){
            allTask.get(id).setReqName(reqName);
        }
        
        int taskType=inputInteger("Task Type(1-4): ",1,4);
        if(taskType!=-1){//if type == -1 mean nope
            allTask.get(id).setTaskTypeId(taskType);
        }
        
        String date=inputDate("Date(MMM-DD-YYYY): ");
        if(!date.equalsIgnoreCase("nope")){
            allTask.get(id).setDate(date);
        }
        
        Double from=inputDouble("From(8.0-17.5): ",8.0,17.5);
        if(from!=-1.0){//if from == -1.0 mean nope 
            allTask.get(id).setPlanFrom(from);
        }
        
        Double oldTo=allTask.get(id).getPlanTo();
        Double newFrom=allTask.get(id).getPlanFrom();
//        System.out.println(oldTo);
//        System.out.println(newFrom);
        while(true){
            Double to=inputDouble("To(8.0-17.5): ",newFrom,17.5);
            if(to!=-1){
                allTask.get(id).setPlanTo(to);
            }else{
                if(newFrom>allTask.get(id).getPlanTo()){
                    System.out.println("");
                    continue;
                }else{
                    break;
                }
            }
        }

        
        String ass=inputString("Assignee: ");
        String rev=inputString("Reviewer: ");
        if(!ass.equalsIgnoreCase("nope")){
            allTask.get(id).setAssignee(ass);
        }
        if(!rev.equalsIgnoreCase("nope")){
            allTask.get(id).setReviewer(rev);
        }
        
    }
    
    public void deleteTask(String id) throws Exception{
        if(!isInteger(id)){
            System.out.println("Id is invalid!");
            return;
        }
        int x=Integer.parseInt(id);
        if(!allTask.containsKey(x)){
            System.out.println("Id is invalid!");
            return;
        }
        allTask.remove(x);
        System.out.println("Delete succesfully!");
    }
    
}
