import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Insert2DB {


    public static void main(String[] args) {
        PreparedStatement pstm = null;
        DBConnection con;
        try {
            con = new DBConnection();
            FileInputStream input = new FileInputStream("AKT OSAGO.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String REG_NUM = row.getCell(2).getStringCellValue();
                String PSEVDONIM = row.getCell(3).getStringCellValue();
                String FULL_NAME = row.getCell(4).getStringCellValue();
                String STATUS = row.getCell(5).getStringCellValue();
                String N_SVID_RSA = row.getCell(6).getStringCellValue();
                String DT_SVID_RSA = row.getCell(7).getStringCellValue();
                String ADRES = row.getCell(8).getStringCellValue();
                String sql = "INSERT INTO test.acts_table VALUES('"+ null + "','" + null + "','" + REG_NUM + "','" + PSEVDONIM + "','" + FULL_NAME + "','" + STATUS + "','" + N_SVID_RSA + "','" + DT_SVID_RSA + "','" + ADRES + "','" + null +"','" + null +"','" + null +"','" + 0 +"','" + 0 +"','" + 0 +"')";
                System.out.println(sql);
                pstm = con.getConnection().prepareStatement(sql);
                pstm.execute();
                System.out.println("Import rows " + i);
            }
            pstm.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }
}