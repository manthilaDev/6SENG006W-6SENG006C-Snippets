package lec_7_a;

public class Document {

    private final String userID ;
    private final String documentName ;
    private final int    numberOfPages ;


    public Document( String UID, String name, int length )
    {
        this.userID        = UID ;
        this.documentName  = name ;
        this.numberOfPages = length ;
    }


    public String getUserID( )        { return userID ; }

    public String getDocumentName( )  { return documentName ; }

    public int getNumberOfPages( ) { return numberOfPages ; }


    public String toString( )
    {
        return new String( "Document[ "  +
                "UserID: " + userID        + ", " +
                "Name: "   + documentName  + ", " +
                "Pages: "  + numberOfPages +
                "]"  ) ;
    }
}
