
package taskmaster;

/**
 * https://docs.google.com/document/d/1sRz1J2MeDSRCYzndgMxG6pWfwzV65wjj/edit
 * @author NVT
 */
public class TaskMASTER {
    public static void main(String[] args) throws Exception {
        TaskManager Manage=new TaskManager();
        while(true){
            System.out.println("========== Task Program ===========");
            System.out.println("   1.   Add Task");
            System.out.println("   2.   Update Task");
            System.out.println("   3.   Delete Task");
            System.out.println("   4.   Display Task");
            System.out.println("   5.   Exit");
            int choice=Manage.inputInteger("PLS enter your choice:",1,5);
            switch(choice){
                case 1:{
                    Manage.addTask();
                    break;
                }
                case 2:{
                    Manage.updateTask();
                    break;
                }
                case 3:{
                    System.out.println("-------------Del Task-------------");
                    String id=Manage.inputString("Input the id: ");
                    Manage.deleteTask(id);
                    break;
                }
                case 4:{
                    Manage.getDataTasks();
                    break;
                }
                case 5:{
                    return;
                }
            }
        }
    }
    
}
