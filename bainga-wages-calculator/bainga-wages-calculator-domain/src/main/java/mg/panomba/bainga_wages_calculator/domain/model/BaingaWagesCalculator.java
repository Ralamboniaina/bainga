package mg.panomba.bainga_wages_calculator.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaingaWagesCalculator {

    private int numberOfPomodoro = 0;
    private double hourSpent = 0;
    private BigDecimal wages = BigDecimal.ZERO;
    private BigDecimal rate = BigDecimal.TEN;
    private ArrayList<DailyTask> dailyTasks = new ArrayList<>();
    private CommitRepository commitRepository;

    public BaingaWagesCalculator(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }

    public int numberOfPomodoro() {
        return numberOfPomodoro;
    }

    public double hourSpent() {
        return hourSpent;
    }

    public BigDecimal wages() {
        return wages;
    }

    public List<DailyTask> dailyTasks() {
        return dailyTasks;
    }

    public void createReport() {
        numberOfPomodoro = 1;
        hourSpent = 0.5;
        wages = rate.multiply(BigDecimal.valueOf(hourSpent));
        DailyTask dailyTask = new DailyTask();
        for (Commit commit : commitRepository.list())
            dailyTask.addCommit(commit);
        dailyTasks.add(dailyTask);
    }
}
