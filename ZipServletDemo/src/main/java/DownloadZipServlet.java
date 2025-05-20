

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Servlet implementation class DownloadZipServlet
 */
@WebServlet("/DownloadZipServlet")
public class DownloadZipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadZipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=file.zip");

        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
            String xml = "<cards>\n"
            		+ "<creditcard id=\"ajey\">12121212121212</creditcard>\n"
            		+ "<creditcard id=\"mano\">12121212121213</creditcard>\n"
            		+ "</cards>";
            zipOut.putNextEntry(new ZipEntry("note.xml"));
            zipOut.write(xml.getBytes());
            zipOut.closeEntry();
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
