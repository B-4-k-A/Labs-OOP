package DAL;

import DAL.Entities.Worker;
import DAL.InfoStructure.IWorkerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WorkerRepository implements IWorkerRepository {

    List<Worker> workerList = new ArrayList<>();

    @Override
    public void createWorker(Worker worker) {
        worker.setId(workerList.size() + 1);
        workerList.add(worker);
    }

    public List<Worker> getAll() {
        return workerList;
    }

    public Worker getWorker(Worker worker) throws Exception {
        Optional<Worker> option = getOption(worker);
        if (option.isEmpty()) {
            throw new Exception("WorkerDTO doesn't exists in memory");
        }
        return option.get();
    }

    @Override
    public void setChief(Worker worker, Worker chief) throws Exception {
        getWorker(worker).setChief(chief);
        getWorker(chief).setChildWorkers(Arrays.asList(worker));
    }

    @Override
    public void setChildWorker(Worker worker, List<Worker> childWorkers) throws Exception {
        getWorker(worker).setChildWorkers(childWorkers);
        childWorkers.forEach(w -> w.setChief(worker));
    }

    protected Optional<Worker> getOption(Worker worker) {
        return workerList.stream().filter(w ->
                w.getId() == (worker.getId())).findFirst();
    }

    public void update(Worker worker) throws Exception {
        Worker w = getWorker(worker);
        w.setChief(worker.getChief());
        w.setChildWorkers(worker.getChildWorkers());
    }
}
