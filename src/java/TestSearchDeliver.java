
import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.ComputerSpec;
import com.asset.model.DeliverAsset;
import com.asset.model.Person;
import com.asset.model.ProblemReport;
import com.asset.model.Ticket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

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

        ArrayList<String> str = new ArrayList<String>();
        str.add("51-1-001-1");
        str.add("51-1-002-1");
        str.add("51-1-003-1");
        
        String[] strs = new String[4];
        strs[0] = "51-1-001-1";
        strs[1] = "51-1-002-1";
        strs[2] = "51-1-003-1";
        strs[3] = "51-1-004-1";
        
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        System.out.println("");

        int index = 0;

        while (index < strs.length) {
            List<String> items = Arrays.asList(strs[index].split("-"));
            System.out.println(strs.length);
            System.out.println(index);
            System.out.println(strs[index]);
            System.out.println(items.get(0));
            System.out.println(items.get(1));
            System.out.println(items.get(2));
            System.out.println(items.get(3));
            System.out.println("");
            index++;
        }

    }

}
