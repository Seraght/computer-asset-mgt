
import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.ComputerSpec;
import com.asset.model.Person;
import com.asset.model.ProblemReport;
import com.asset.model.Ticket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
public class TestSearchComputer {

    public static void main(String[] args) {
        String assetKey = "57-1-001-1";
        
        String assetYear = assetKey.substring(0, 2);
        int assetGet = Integer.parseInt(assetKey.substring(3, 4));
        String assetNumber = assetKey.substring(5, 8);
        int typeID = Integer.parseInt(assetKey.substring(9, 10));
        
        System.out.println(assetYear);
        System.out.println(assetGet);
        System.out.println(assetNumber);
        System.out.println(typeID);
    }
}
