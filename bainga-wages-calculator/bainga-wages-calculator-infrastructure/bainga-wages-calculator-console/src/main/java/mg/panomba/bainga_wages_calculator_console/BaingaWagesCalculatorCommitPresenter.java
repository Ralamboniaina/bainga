package mg.panomba.bainga_wages_calculator_console;

import mg.panomba.bainga_wages_calculator.application.*;

public class BaingaWagesCalculatorCommitPresenter implements BaingaWagesCalculatorOutputBoundary {

    @Override
    public void print(BaingaWagesCalculatorOutputData outputData) {
        System.out.println();
        System.out.printf("Number of pomodoro: %s%n", outputData.numberOfPomodoro());
        System.out.printf("Hours spent: %s%n", outputData.hoursSpent());
        System.out.printf("Wages: %s%n", outputData.wages());
        for (DailyTaskOutputData dailyTaskOutputData : outputData.dailyTask()) {
            System.out.println();
            System.out.println("Date: " + dailyTaskOutputData.date());
            for (PomodoroOuptputData pomodoroOuptputData : dailyTaskOutputData.pomodoro()) {
                System.out.println("\tInterval: " + pomodoroOuptputData.interval());
                for (CommitOutputData commitOutputData : pomodoroOuptputData.commits()) {
                    System.out.printf("\t\tCommit %s: %s%n", commitOutputData.id(), commitOutputData.message());
                }
            }
        }
    }

}
