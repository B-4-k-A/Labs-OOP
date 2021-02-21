package BLL.DTO;

import DAL.Entities.Worker;

import java.util.List;
import java.util.Optional;

public class WorkerDTO {
    private int id;
    private String name;
    private List<WorkerDTO> childWorkers;
    private WorkerDTO chief;

    public WorkerDTO(String name) {
        this.name = name;
    }

    public WorkerDTO(int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Worker convertToDAL() {
//        var worker = new Worker(id, name);
//        return worker;
//    }

    public List<WorkerDTO> getChildWorkers() {
        return childWorkers;
    }

    public WorkerDTO getChief() {
        return chief;
    }

    public void setChief(WorkerDTO chief) {
        this.chief = chief;
    }

    public void setChildWorkers(List<WorkerDTO> childWorkers) {
        this.childWorkers = childWorkers;
    }
}
