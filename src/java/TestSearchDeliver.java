
import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.ComputerSpec;
import com.asset.model.DeliverAsset;
import com.asset.model.Person;
import com.asset.model.ProblemReport;
import com.asset.model.Ticket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seraght
 */
public class TestSearchDeliver {

    public static void main(String[] args) {

        int status = 0;
        Map m = DeliverAsset.countDeliver();

        String message = "";

        if (m == null) {
            message = "Computer name '" + m + "'does not exits !!!";
            System.out.println(message);
        } else {
            System.out.println(m.get("count_sum"));
            System.out.println(m.get("count_deliver"));
            System.out.println(m.get("count_accept"));
        }
    }
}
