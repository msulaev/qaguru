package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;
import utils.FileExtensions;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
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
    public void pdfTest() {
        try {
            PDF pdf = new PDF(getFileFromZIP(FileExtensions.PDF));
            assertThat(pdf).containsExactText("test_pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void csvTest() {
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getFileFromZIP(FileExtensions.CSV), UTF_8));
            assertThat(reader.readNext()).contains("test_csv");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xlsTest() {
        try {
            XLS spreadsheet = new XLS(getFileFromZIP(FileExtensions.XLS));
            assertThat(Objects.requireNonNull(spreadsheet).excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).isEqualTo("test_xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public InputStream getFileFromZIP(FileExtensions fileExtension) {
        Path path = null;
        try {
            path = Path.of(Objects.requireNonNull(classLoader.getResource("archive.zip")).toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ZipFile zipFile = null;
        try {
            assert path != null;
            zipFile = new ZipFile(path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Enumeration<? extends ZipEntry> entries = Objects.requireNonNull(zipFile).entries();
        InputStream inputStream = null;

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            try {
                inputStream = zipFile.getInputStream(entry);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (entry.getName().contains(fileExtension.toString().toLowerCase())) {
                return inputStream;
            }
        }
        return inputStream;
    }
}

