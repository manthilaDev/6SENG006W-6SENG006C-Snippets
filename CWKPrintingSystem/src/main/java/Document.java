/** *********************************************************************
 * File:      Document.java  (Class)
 * Author:    P. Howells	
 * Contents:  6SENG002W CWK  
 *            This provides an "abstract" document object. 
 *            It includes the user id, the document's name & its length 
 *            in pages.
 * Date:      22/10/20
 * Version:   1.0	
 ************************************************************************ */

class Document
{
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

    public int    getNumberOfPages( ) { return numberOfPages ; }


    public String toString( )
    {
       return new String( "Document[ "  +
                                     "UserID: " + userID        + ", " + 
                                     "Name: "   + documentName  + ", " + 
                                     "Pages: "  + numberOfPages + 
                                  "]"  ) ;
    }

} // Document


