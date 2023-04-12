package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.BaingaWagesCalculator;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;

import java.math.BigDecimal;

public class BaingaWagesCalculatorApplication {
    private final BaingaWagesCalculatorOutputBoundary outputBoundary;
    private final BaingaWagesCalculator baingaWagesCalculator;

    public BaingaWagesCalculatorApplication(
            CommitRepository commitRepository,
            BaingaWagesCalculatorOutputBoundary outputBoundary,
            BigDecimal rate) {
        this.outputBoundary = outputBoundary;
        baingaWagesCalculator = new BaingaWagesCalculator(commitRepository, rate);
    }

    public void createReport() {
        baingaWagesCalculator.createReport();
        outputBoundary.print(new BaingaWagesCalculatorOutputData(baingaWagesCalculator));
    }
}
