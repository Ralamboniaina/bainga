package mg.panomba.bainga_wages_calculator_main;

import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorApplication;
import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorOutputBoundary;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;
import mg.panomba.bainga_wages_calculator_commit_from_command_line.BaingaWagesCalculatorCommitFromCommandLine;
import mg.panomba.bainga_wages_calculator_console.BaingaWagesCalculatorConsolePresenter;

import java.math.BigDecimal;

public class BaingaWagesCalculatorMain {

    public static void main(String[] args) {
        CommitRepository commitRepository = new BaingaWagesCalculatorCommitFromCommandLine("/Users/andrianarison/Documents/WORK/PANOMBA/hexagone-backoffice");
        BaingaWagesCalculatorOutputBoundary outputBoundary = new BaingaWagesCalculatorConsolePresenter();
        BigDecimal rate = BigDecimal.valueOf(40000);
        new BaingaWagesCalculatorApplication(commitRepository, outputBoundary, rate).createReport();
    }

}
