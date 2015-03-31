package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

/**
 * Created by Dan on 3/30/2015.
 */
public class HTMLHeader {
    Object contents;
    public HTMLHeader(Object s){contents = s;}

    public String toString()
    {
        return "<h2>"+ contents.toString()+"</h2>";
    }

}
