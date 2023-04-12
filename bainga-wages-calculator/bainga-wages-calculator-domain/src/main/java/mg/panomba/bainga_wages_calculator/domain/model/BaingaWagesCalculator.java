package mg.panomba.bainga_wages_calculator.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaingaWagesCalculator {

    private final CommitRepository commitRepository;
    private final List<DailyTask> dailyTasks = new ArrayList<>();

    private final BigDecimal rate = BigDecimal.TEN;

    public BaingaWagesCalculator(CommitRepository commitRepository) {
        this.commitRepository = commitRepository;
    }

    public BigDecimal wages() {
        return BigDecimal.valueOf(hourSpent()).multiply(rate);
    }

    public double hourSpent() {
        return numberOfPomodoro() * 0.5;
    }

    public int numberOfPomodoro() {
        int result = 0;
        for (DailyTask dailyTask : dailyTasks) result = result + dailyTask.pomodoroList().size();
        return result;
    }

    public List<DailyTask> dailyTasks() {
        return dailyTasks;
    }

    public void createReport() {
        for (Commit commit : commitRepository.list()) addCommit(commit);
    }

    private void addCommit(Commit commit) {
        DailyTask dailyTask = new DailyTask(commit);
        try {
            dailyTasks.get(dailyTasks.indexOf(dailyTask)).addCommit(commit);
        } catch (Exception e) {
            dailyTasks.add(dailyTask);
        }
    }

}
