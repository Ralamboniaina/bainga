package mg.panomba.bainga_wages_calculator_main;

import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorApplication;
import mg.panomba.bainga_wages_calculator.application.BaingaWagesCalculatorOutputBoundary;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;
import mg.panomba.bainga_wages_calculator_commit_from_command_line.BaingaWagesCalculatorCommitFromCommandLine;
import mg.panomba.bainga_wages_calculator_excel.BaingaWagesCalculatorExcelPresenter;

import java.math.BigDecimal;

public class BaingaWagesCalculatorMain {

    public static void main(String[] args) {
        CommitRepository commitRepository = new BaingaWagesCalculatorCommitFromCommandLine(".");
        BaingaWagesCalculatorOutputBoundary outputBoundary = new BaingaWagesCalculatorExcelPresenter();
        BigDecimal rate = BigDecimal.valueOf(20000);
        new BaingaWagesCalculatorApplication(commitRepository, outputBoundary, rate).createReport();
    }

}
