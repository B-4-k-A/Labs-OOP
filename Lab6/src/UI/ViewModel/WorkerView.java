package UI.ViewModel;

public class WorkerView {
    private int id;
    private String name;

    public WorkerView(String name) {
        this.name = name;
    }

    public WorkerView(int id) {
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

}
