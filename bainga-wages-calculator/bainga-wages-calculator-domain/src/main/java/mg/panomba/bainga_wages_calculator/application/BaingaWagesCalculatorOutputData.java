package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.BaingaWagesCalculator;
import mg.panomba.bainga_wages_calculator.domain.model.DailyTask;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaingaWagesCalculatorOutputData {
    private final BaingaWagesCalculator baingaWagesCalculator;

    public BaingaWagesCalculatorOutputData(BaingaWagesCalculator baingaWagesCalculator) {

        this.baingaWagesCalculator = baingaWagesCalculator;
    }

    public List<DailyTaskOutputData> dailyTask() {
        List<DailyTaskOutputData> result = new ArrayList<>();
        for (DailyTask dailyTask : baingaWagesCalculator.dailyTasks()) result.add(new DailyTaskOutputData(dailyTask));
        return result;
    }

    public Integer numberOfPomodoro() {
        return baingaWagesCalculator.numberOfPomodoro();
    }

    public Double hoursSpent() {
        return baingaWagesCalculator.hourSpent();
    }

    public BigDecimal wages() {
        return baingaWagesCalculator.wages();
    }
}
