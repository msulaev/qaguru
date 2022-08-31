package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import utils.FileExtensions;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FileTest {

    ClassLoader classLoader = FileTest.class.getClassLoader();

    @Test
    public void pdfTest() throws Exception {
        PDF pdf = new PDF(getFileFromZIP(FileExtensions.PDF));
        assertThat(pdf).containsExactText("test_pdf");
    }

    @Test
    public void csvTest() throws Exception {
        CSVReader reader = new CSVReader(new InputStreamReader(getFileFromZIP(FileExtensions.CSV), UTF_8));
        assertThat(reader.readNext()).contains("test_csv");
    }

    @Test
    public void xlsTest() throws Exception {
        XLS spreadsheet = new XLS(getFileFromZIP(FileExtensions.XLS));
        assertThat(spreadsheet.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).isEqualTo("test_xlsx");
    }


    public InputStream getFileFromZIP(FileExtensions fileExtension) throws Exception {
        Path path = Path.of(Objects.requireNonNull(classLoader.getResource("archive.zip")).toURI().getPath());
        ZipFile zipFile = new ZipFile(path.toString());

        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        InputStream inputStream = null;

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            inputStream = zipFile.getInputStream(entry);

            if (entry.getName().contains(fileExtension.toString().toLowerCase())) {
                return inputStream;
            }
        }
        return inputStream;
    }
}

