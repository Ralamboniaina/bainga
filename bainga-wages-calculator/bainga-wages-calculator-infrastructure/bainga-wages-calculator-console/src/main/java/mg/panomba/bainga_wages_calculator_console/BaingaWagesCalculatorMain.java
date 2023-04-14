package mg.panomba.bainga_wages_calculator_console;

import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorApplication;
import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorOutputBoundary;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;
import mg.panomba.bainga_wages_calculator_commit_from_command_line.BaingaWagesCalculatorCommitFromCommandLine;

import java.math.BigDecimal;

public class BaingaWagesCalculatorMain {

    public static void main(String[] args) {
        CommitRepository commitRepository = new BaingaWagesCalculatorCommitFromCommandLine(".");
        BaingaWagesCalculatorOutputBoundary outputBoundary = new BaingaWagesCalculatorCommitPresenter();
        BigDecimal rate = BigDecimal.valueOf(20000);
        new BaingaWagesCalculatorApplication(commitRepository, outputBoundary, rate).createReport();
    }

}
