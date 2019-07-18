package tests.google;

import actions.google.Geocoding;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class GoogleAPITest {

    public static final String csvFile = System.getProperty("user.dir") + "/src/test/java/resources/test-data.csv";

    @Test(dataProvider = "csv")
    public void TC_Verify_Latitude_Longitude_matched(Hashtable<String, JSONObject> data) throws Exception {
        Set<String> addresses = data.keySet();
        for (String address : addresses) {
            Geocoding.verifyLocation(address, data.get(address));
        }
    }


    @DataProvider(name = "csv")
    public static Object[][] readCsv() {
        try {
            FileReader fileReader = new FileReader(csvFile);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
            List<String[]> allData = csvReader.readAll();
            Object[][] obj = new Object[allData.size()][1];
            for (String[] row : allData) {
                Hashtable<Object, Object> data = new Hashtable<>();
                JSONObject temp = new JSONObject();
                temp.put("lat", Double.parseDouble(row[1]));
                temp.put("lng", Double.parseDouble(row[2]));
                data.put(row[0], new JSONObject(temp));
                obj[allData.indexOf(row)][0] = data;
            }
            return obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
