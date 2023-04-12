package mg.panomba.bainga_wages_calculator.application;

import mg.panomba.bainga_wages_calculator.domain.model.Commit;
import mg.panomba.bainga_wages_calculator.domain.model.CommitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("When report has been created")
class WhenReportHasBeenCreatedTest {

    @Test
    @DisplayName("then a report should be printed")
    void thenAReportShouldBePrinted() {
        //ARRANGE
        CommitRepository commitRepository = mock(CommitRepository.class);
        given(commitRepository.list()).willReturn(List.of(new Commit(
                "id",
                "author",
                LocalDateTime.now(),
                "message")));
        BaingaWagesCalculatorOutputBoundary outputBoundary = mock(BaingaWagesCalculatorOutputBoundary.class);
        //ACT
        new BaingaWagesCalculatorApplication(commitRepository, outputBoundary, BigDecimal.TEN).createReport();
        //ASSERT
        ArgumentCaptor<BaingaWagesCalculatorOutputData> outputDataCaptor = ArgumentCaptor.forClass(BaingaWagesCalculatorOutputData.class);
        verify(outputBoundary).print(outputDataCaptor.capture());
    }

}
