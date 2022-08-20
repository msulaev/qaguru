package files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import net.lingala.zip4j.ZipFile;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class FilesTest {

    @Test
    void zipTest() throws Exception {
        ZipFile zipFile = new ZipFile(new File("src/test/resources/archive.zip"));
        zipFile.extractAll("out/test/resources");

        PDF pdf = new PDF(new File("out/test/resources/test.pdf"));
        assertThat(pdf).containsExactText("test_pdf");

        XLS spreadsheet = new XLS(new File("out/test/resources/test.xlsx"));
        assertThat(spreadsheet.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).isEqualTo("test_xlsx");

        CSVReader reader = new CSVReader(new FileReader("out/test/resources/test.csv"));
        assertThat(reader.readNext()).contains("test_csv");
    }
}
