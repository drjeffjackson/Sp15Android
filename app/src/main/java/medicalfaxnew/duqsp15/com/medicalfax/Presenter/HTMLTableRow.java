package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

import java.util.ArrayList;

/**
 * Created by Dan on 3/25/2015.
 */
public class HTMLTableRow extends ArrayList<Object> {
    @Override
    public String toString() {
        String theRow = new String();
        for(Object cell: this)
        {
            theRow+="<td>";
            if(cell!=null)
                theRow+=cell.toString();

            theRow+="</td>";
        }
        return theRow;
    }
}
