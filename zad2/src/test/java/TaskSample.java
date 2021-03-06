
public class TaskSample implements TaskInterface {

    private int firstQueue;
    private int lastQueue;
    private int taskId;
    private boolean keepOrder;

    public TaskSample(int firstQueue, int lastQueue, int taskId, boolean keepOrder) {
        this.firstQueue = firstQueue;
        this.lastQueue = lastQueue;
        this.taskId = taskId;
        this.keepOrder = keepOrder;
    }

    @Override
    public int getFirstQueue() {
        return firstQueue;
    }

    @Override
    public int getLastQueue() {
        return lastQueue;
    }

    @Override
    public int getTaskID() {
        return taskId;
    }

    @Override
    public boolean keepOrder() {
        return keepOrder;
    }

    @Override
    public TaskInterface work(int queue) {
        System.out.println(String.format("Task %d doing work on queue: %d.", taskId, queue));
        try {
            if (firstQueue == lastQueue) {
                System.out.println(String.format("Task %d DONE queue %d.", getTaskID(), queue));
            }
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TaskSample(firstQueue + 1, lastQueue, taskId, keepOrder);

    }
}
