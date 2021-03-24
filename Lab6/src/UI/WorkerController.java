package UI;

import BLL.DTO.WorkerDTO;
import BLL.InfoStructure.IWorkerService;
<<<<<<< HEAD
=======
import DAL.Entities.Worker;
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
import UI.ViewModel.WorkerView;

import java.util.*;
import java.util.stream.Collectors;

public class WorkerController {

    private IWorkerService service;
<<<<<<< HEAD
=======
//    private HashMap<String, Integer> workerID = new HashMap<>();
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af

    public WorkerController(IWorkerService service) {
        this.service = service;
    }

    public void addWorker(WorkerView item) {
        var bllWorker = new WorkerDTO(item.getName());
        service.addWorker(bllWorker);
        item.setId(bllWorker.getId());
    }

    public List<WorkerView> getAll() {
        return service.getAll().stream().map(w -> new WorkerView(w.getId())).
                collect(Collectors.toList());
    }

    public WorkerView getWorker(WorkerView item) throws Exception {
        return getAll().stream().filter(w -> w.getId() == item.getId()).findFirst().get();
    }

    public void setChief(WorkerView item, WorkerView chief) throws Exception {
        var bllWorker = new WorkerDTO(item.getId());
        var bllChief = new WorkerDTO(chief.getId());
        service.setChief(bllWorker, bllChief);
    }

    public void setChildWorker(WorkerView item, List<WorkerView> workerList) throws Exception {
        var bllWorker = new WorkerDTO(item.getId());
        List<WorkerDTO> list = workerList.stream().map(w -> new WorkerDTO(w.getId()))
                .collect(Collectors.toList());
        service.setChildWorker(bllWorker, list);
    }

    public String printWorkers() {
        StringBuilder sb = new StringBuilder();
        List<WorkerView> list = getAll();
        for(var w : list) {
            sb.append(w.getId() + ".\t" + w.getName() + "\n");
        }
        return sb.toString();
    }

//    public void cmd() throws Exception {
//        boolean exit = false;
//        while(!exit) {
//            System.out.println("1. AddNewWorker");
//            System.out.println("2. SetChildWorker");
//            System.out.println("3. SetChiefWorker");
//            var scanner = new Scanner(System.in);
//            var cmd = scanner.nextInt();
//            switch (cmd) {
//                case 1:
//                    System.out.println("Enter name of worker");
//                    String name = scanner.next();
//                    addWorker(new WorkerView(name));
//                    break;
//                case 2:
//                    System.out.println(printWorkers());
//                    System.out.println("Choose worker which childWorker you want set");
//                    int id = scanner.nextInt();
//                    var w = getWorker(new WorkerView(id, null));
//                    System.out.println("Choose workers who will childWorker for " + w.getName());
//                    printWorkers().lines().
//                            filter(str -> !str.contains(w.getId() + ".\t" + w.getName())).
//                            forEach(System.out::println);
//                    String[] ids = scanner.next().split(" ");
//                    List<WorkerView> list = new ArrayList<>();
//                    for(var i : ids) {
//                        list.add(getWorker(new WorkerView(Integer.parseInt(i), null)));
//                    }
//                    setChildWorker(w, list);
//            }
//        }
//    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 796b62f3b6b590a60f88f3488e46281af90009af
