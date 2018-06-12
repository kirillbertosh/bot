package bot.filemanager;

import bot.entities.Ticker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class XLSDocument {

    private static String CURRENCY_TOP_FILENAME = "currencyTop";

    private int rowNumber;
    private static String[] columns =
            {"Currency pair", "Higher price", "Lower price", "Volume",
                    "Volume in currency", "Date and time             ", " "};

    private Workbook workbook = new XSSFWorkbook();
    private Sheet sheet;

    public XLSDocument(String currency) {
        CURRENCY_TOP_FILENAME += currency.toUpperCase() + ".xls";
        sheet = workbook.createSheet(new SimpleDateFormat("yyyy MM dd").format(Calendar.getInstance().getTime()));
        initialize();
        File file = new File(CURRENCY_TOP_FILENAME);
        if (file.exists()) {
            load();
            System.out.println("File exist");
        } else {
            rowNumber = 2;
            sheet.createRow(0);
            sheet.getRow(0).createCell(0).setCellValue(rowNumber - 2);
            save();
        }
    }

    private void initialize() {
        Row headerRow = sheet.createRow(1);

        int k = 0;
        for (int i = 0; i < 10; i++) {
            for (String column : columns) {
                Cell cell = headerRow.createCell(k);
                cell.setCellValue(column);
                sheet.autoSizeColumn(k++);
            }
        }
    }

    public void addTickerListToXLSDocument(List<Ticker> tickerList) {
        Row row = sheet.createRow(rowNumber);
        for (int i = 0; i < tickerList.size(); i++) {
            addTickerToXLSDocument(tickerList.get(i), i * 7, row);
        }
        rowNumber++;
        sheet.getRow(0).getCell(0).setCellValue(rowNumber - 2);
        System.out.println(sheet.getRow(0).getCell(0).getNumericCellValue());
    }

    private void addTickerToXLSDocument(Ticker ticker, int index, Row row) {
        row.createCell(index).setCellValue(ticker.getTickerPairName());
        row.createCell(index + 1).setCellValue(ticker.getHigherPrice());
        row.createCell(index + 2).setCellValue(ticker.getLowerPrice());
        row.createCell(index + 3).setCellValue(ticker.getVolume());
        row.createCell(index + 4).setCellValue(ticker.getVolumeInCurrency());
        row.createCell(index + 5)
                .setCellValue(new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime()));
    }

    public void load() {
        try (FileInputStream fileInput = new FileInputStream(CURRENCY_TOP_FILENAME)) {
            workbook = new XSSFWorkbook(fileInput);
            sheet = workbook.getSheetAt(0);
            rowNumber = (int)sheet.getRow(0).getCell(0).getNumericCellValue() + 2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream(CURRENCY_TOP_FILENAME);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
