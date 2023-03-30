package mg.panomba.bainga_wages_calculator.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaingaWagesCalculator {

    private int numberOfPomodoro = 0;
    private int hourSpent = 0;
    private BigDecimal wages = BigDecimal.ZERO;
    private ArrayList<DailyTask> dailyTasks = new ArrayList<>();

    public int numberOfPomodoro() {
        return numberOfPomodoro;
    }

    public int hourSpent() {
        return hourSpent;
    }

    public BigDecimal wages() {
        return wages;
    }

    public List<DailyTask> dailyTasks() {
        return dailyTasks;
    }
}
