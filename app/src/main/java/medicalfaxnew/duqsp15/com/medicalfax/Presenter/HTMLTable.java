package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import java.util.ArrayList;

/**
 * Created by Dan on 3/25/2015.
 */
public class HTMLTable extends ArrayList<HTMLTableRow> {
    @Override
    public String toString() {
        String theTable = new String();
        theTable+="<table border=\"1\" style=\"width:100%\">";

        for(HTMLTableRow row:this)
        {
            theTable+="<tr>";
            theTable+=row.toString();
            theTable+="</tr>";
        }

        theTable+="</table>";
        System.out.println(theTable);
        return theTable;
    }
}
