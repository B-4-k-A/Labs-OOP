package BLL.InfoStructure;

import BLL.DTO.WorkerDTO;

import java.util.List;

public interface IWorkerService {

    void addWorker(WorkerDTO item);

    List<WorkerDTO> getAll();

    WorkerDTO getWorker(WorkerDTO worker) throws Exception;

    void setChief(WorkerDTO item, WorkerDTO chief) throws Exception;

    void setChildWorker(WorkerDTO item, List<WorkerDTO> workerList) throws Exception;
}

<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
