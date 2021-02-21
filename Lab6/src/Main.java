import BLL.ReportService;
import BLL.TaskService;
import BLL.WorkerService;
import DAL.ReportRepository;
import DAL.TaskRepository;
import DAL.WorkerRepository;
import UI.TaskController;
import UI.ReportController;
import UI.ViewModel.SprintReportView;
import UI.ViewModel.TaskView;
import UI.ViewModel.WorkerView;
import UI.WorkerController;

import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        try {
            var workRepo = new WorkerRepository();
            var workSevice = new WorkerService(workRepo);
            var workController = new WorkerController(workSevice);

            var taskRepo = new TaskRepository();
            var taskService = new TaskService(taskRepo);
            var taskController = new TaskController(taskService);

            var reportRepo = new ReportRepository();
            var reportService = new ReportService(reportRepo);
            var reportConroller = new ReportController(reportService);
//            var mainController = new MainController(controller);

            var alex = new WorkerView("Alex");
            var sasha = new WorkerView("Sasha");
            var pasha = new WorkerView("Pasha");
            var santa = new WorkerView("Santa");

            workController.addWorker(alex);
            workController.addWorker(sasha);
            workController.addWorker(pasha);
            workController.addWorker(santa);

            var task1 = new TaskView("task1", "some info");

            taskController.addTask(task1);
//            taskController.doWork(task1, alex);
            taskController.setOwner(task1, alex);
            taskController.doWork(task1, alex);

            workController.setChildWorker(alex, Arrays.asList(sasha, santa));

            var sprintReport = new SprintReportView(alex, Calendar.getInstance());
            reportConroller.addSprintReport(sprintReport);

            String text = sprintReport.getText();

            text += "editing report";

            reportConroller.writeReport(alex, sprintReport, text);

            reportConroller.saveSprintReport(alex, sprintReport);

            System.out.println(sprintReport.getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
//    boolean exit = false;
//            while (!exit) {
//                var scanner = new Scanner(System.in);
//                System.out.println("1. Action with Worker");
//                System.out.println("0. Exit");
//                int cmd = scanner.nextInt();
//                switch (cmd) {
//                    case 1:
//                        mainController.workerController.cmd();
//                        break;
//                    case 0:
//                        exit = true;
//                        break;
////                case 3:
////                case 4:
////                case 5:
//                }
//            }