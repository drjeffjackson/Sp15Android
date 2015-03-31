package medicalfaxnew.duqsp15.com.medicalfax.Presenter;

/**
 * Created by Dan on 3/30/2015.
 */
public class HTMLParagraph {
    Object contents;
    public HTMLParagraph(Object s){contents = s;}

    public String toString()
    {
        if(contents!=null)
            return "<p>"+ contents.toString()+"</p>";
        else
            return "<p>"+"</p>";
    }
}
