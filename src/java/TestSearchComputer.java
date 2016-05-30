
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
        String assetNum = "57-1-001-1";
        
        String assetYear = assetNum.substring(0, 2);
//        String assetGet = assetNum.substring(3, 4);
        int assetGet = Integer.parseInt(assetNum.substring(3, 4));
        String assetNumber = assetNum.substring(5, 8);
//        String typeID = assetNum.substring(9, 10);
        int typeID = Integer.parseInt(assetNum.substring(9, 10));
        
        System.out.println(assetYear);
        System.out.println(assetGet);
        System.out.println(assetNumber);
        System.out.println(typeID);
    }
}
