package DAL.Entities;

import DAL.InfoStructure.IEntity;

import java.util.List;
import java.util.UUID;

public class Worker implements IEntity {
    private int id;
    private String name;
    private List<Worker> childWorkers;
    private Worker chief;

    public Worker(String name) {
       this.name = name;
    }

    public Worker(int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Worker> getChildWorkers() {
        return childWorkers;
    }

    public Worker getChief() {
        return chief;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChief(Worker chief) {
        this.chief = chief;
    }

    public void setChildWorkers(List<Worker> childWorkers) {
        this.childWorkers = childWorkers;
    }
}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
