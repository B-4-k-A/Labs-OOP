package DAL.InfoStructure;

import DAL.Entities.Worker;

import java.util.List;

public interface IWorkerRepository {

    void createWorker(Worker worker);

    void setChief(Worker worker, Worker chief) throws Exception;

    void setChildWorker(Worker worker, List<Worker> childWorkers) throws Exception;

    List<Worker> getAll();

    Worker getWorker(Worker worker) throws Exception;
}
