
package taskmaster;

/**
 *
 * @author NVT
 */
public class Task {
    private int id,taskTypeId;
    private String reqName,date,Assignee, Reviewer;
    private Double planFrom,planTo;
    String[] nameofType={"","Code","Test","Design","Review"};
    
    public Task() {
    }

    public Task(int id, int taskTypeId, String reqName, String date, Double planFrom, Double planTo, String Assignee, String Reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.reqName = reqName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(Double planFrom) {
        this.planFrom = planFrom;
    }

    public Double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(Double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }
    
    public String getRealType(){
        return nameofType[this.getTaskTypeId()];
    }
}
