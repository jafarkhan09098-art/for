
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.*;
import jxl.read.*;
import jxl.write.*;

import java.io.*;

public class updatestudrecords {

    @BeforeClass
    public void f1() {
        // Setup code
    }

    @Test
    public void testImportexport1() throws Exception {

        FileInputStream fi = new FileInputStream(
            "C:\\Selenium\\myBook1.xls"
        );

        Workbook w = Workbook.getWorkbook(fi);
        Sheet s = w.getSheet(0);

        String a[][] = new String[s.getRows()][s.getColumns()];

        FileOutputStream fo = new FileOutputStream(
            "C:\\Selenium\\myBook1res.xls"
        );

        WritableWorkbook wwb = Workbook.createWorkbook(fo);
        WritableSheet ws = wwb.createSheet("result1", 0);

        // Copy data from input Excel file
        for (int i = 0; i < s.getRows(); i++) {

            for (int j = 0; j < s.getColumns(); j++) {

                a[i][j] = s.getCell(j, i).getContents();

                Label l2 = new Label(j, i, a[i][j]);
                ws.addCell(l2);
            }
        }

        // Add Result heading
        Label resultHeading = new Label(6, 0, "Result");
        ws.addCell(resultHeading);

        // Check student marks
        for (int i = 1; i < s.getRows(); i++) {

            for (int j = 2; j < s.getColumns(); j++) {

                a[i][j] = s.getCell(j, i).getContents();

                int x = Integer.parseInt(a[i][j]);

                if (x > 35) {

                    Label result = new Label(6, i, "pass");
                    ws.addCell(result);

                } else {

                    Label result = new Label(6, i, "fail");
                    ws.addCell(result);
                    break;
                }
            }
        }

        // Save and close Excel files
        wwb.write();
        wwb.close();
        w.close();
        fi.close();
        fo.close();
    }
}
