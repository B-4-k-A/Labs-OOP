package BLL;

import BLL.DTO.WorkerDTO;
import BLL.InfoStructure.IWorkerService;
import DAL.Entities.Worker;
import DAL.InfoStructure.IWorkerRepository;

<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WorkerService implements IWorkerService {

    private IWorkerRepository repo;

    public WorkerService(IWorkerRepository item) {
        this.repo = item;
    }

    @Override
    public void addWorker(WorkerDTO item) {
        var dalWorker = new Worker(item.getName());
        repo.createWorker(dalWorker);
        item.setId(dalWorker.getId());
    }

    @Override
    public List<WorkerDTO> getAll() {
        return repo.getAll().stream().map(w -> new WorkerDTO(w.getId())).
                collect(Collectors.toList());
    }

    public WorkerDTO getWorker(WorkerDTO item) throws Exception {
        Optional<WorkerDTO> option = getAll().stream().filter(w -> w.getId() == item.getId()).findFirst();
        if (option.isEmpty()) {
            throw new Exception("Worker with" + item.getId() + " ID doesn't exists");
        }
        return option.get();
    }

    @Override
    public void setChief(WorkerDTO item, WorkerDTO chief) throws Exception {
        var dalWorker = new Worker(item.getId());
        var dalChief = new Worker(chief.getId());
        repo.setChief(dalWorker, dalChief);
    }

    @Override
    public void setChildWorker(WorkerDTO item, List<WorkerDTO> workerList) throws Exception {
        var dalWorker = new Worker(item.getId());
        List<Worker> list = workerList.stream().map(w -> new Worker(w.getId()))
                .collect(Collectors.toList());
        repo.setChildWorker(dalWorker, list);
    }

}
<<<<<<< HEAD

=======
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
