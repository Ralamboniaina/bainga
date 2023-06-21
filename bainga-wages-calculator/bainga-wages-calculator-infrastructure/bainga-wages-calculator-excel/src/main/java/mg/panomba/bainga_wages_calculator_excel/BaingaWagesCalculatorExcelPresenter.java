package mg.panomba.bainga_wages_calculator_excel;

import mg.panomba.bainga_wages_calculator.application.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;

public class BaingaWagesCalculatorExcelPresenter implements BaingaWagesCalculatorOutputBoundary {

    Workbook workbook;

    public BaingaWagesCalculatorExcelPresenter() {
        try {
            workbook = WorkbookFactory.create(ClassLoader.getSystemResourceAsStream("template.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(BaingaWagesCalculatorOutputData outputData) {
        workbook.getSheetAt(0).getRow(2).createCell(1);
        workbook.getSheetAt(0).getRow(3).createCell(1);
        workbook.getSheetAt(0).getRow(2).createCell(4);
        workbook.getSheetAt(0).getRow(3).createCell(4);
        workbook.getSheetAt(0).getRow(2).getCell(1).setCellValue(outputData.numberOfPomodoro());
        workbook.getSheetAt(0).getRow(3).getCell(1).setCellValue(outputData.rate().doubleValue());
        workbook.getSheetAt(0).getRow(2).getCell(4).setCellValue(outputData.hoursSpent());
        workbook.getSheetAt(0).getRow(3).getCell(4).setCellValue(outputData.wages().doubleValue());
        int currentRow = 6;
        int mergeDailyTaskStart;
        int mergeDailyTaskEnd;
        int mergePomodoroStart;
        int mergePomodoroEnd;
        String repositoryURL = "https://github.com/MD2I-Madagascar/seed-reporting/commit/";
        for (DailyTaskOutputData dailyTaskOutputData : outputData.dailyTask()) {
            mergeDailyTaskStart = currentRow;
            mergeDailyTaskEnd = currentRow;
            for (PomodoroOuptputData pomodoroOuptputData : dailyTaskOutputData.pomodoro()) {
                mergePomodoroStart = currentRow;
                mergePomodoroEnd = currentRow;
                for (CommitOutputData commit : pomodoroOuptputData.commits()) {
                    workbook.getSheetAt(0).createRow(currentRow);
                    workbook.getSheetAt(0).getRow(currentRow).createCell(0);
                    workbook.getSheetAt(0).getRow(currentRow).createCell(1);
                    workbook.getSheetAt(0).getRow(currentRow).createCell(2);
                    workbook.getSheetAt(0).getRow(currentRow).createCell(3);
                    workbook.getSheetAt(0).getRow(currentRow).createCell(4);
                    workbook.getSheetAt(0).getRow(currentRow).getCell(0).setCellValue(dailyTaskOutputData.date().toString());
                    workbook.getSheetAt(0).getRow(currentRow).getCell(1).setCellValue(commit.message());
                    workbook.getSheetAt(0).getRow(currentRow).getCell(2).setCellValue(repositoryURL.concat(commit.id()));
                    workbook.getSheetAt(0).getRow(currentRow).getCell(3).setCellValue(pomodoroOuptputData.interval());
                    workbook.getSheetAt(0).getRow(currentRow).getCell(4).setCellValue(0.5);
                    currentRow++;
                    mergeDailyTaskEnd++;
                    mergePomodoroEnd++;
                }
                if (mergePomodoroStart != mergePomodoroEnd - 1) {
                    workbook.getSheetAt(0).addMergedRegion(new CellRangeAddress(mergePomodoroStart, mergePomodoroEnd - 1, 3, 3));
                    workbook.getSheetAt(0).addMergedRegion(new CellRangeAddress(mergePomodoroStart, mergePomodoroEnd - 1, 4, 4));
                }
            }
            if (mergeDailyTaskStart != mergeDailyTaskEnd - 1)
                workbook.getSheetAt(0).addMergedRegion(new CellRangeAddress(mergeDailyTaskStart, mergeDailyTaskEnd - 1, 0, 0));
        }
        try {
            workbook.write(new FileOutputStream("report.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}