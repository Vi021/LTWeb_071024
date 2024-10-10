package vn.iostar.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.utils.Constants;

@WebServlet(urlPatterns = {"/image"})
public class DowloadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("filename");
		File file = new File(Constants.UPLOAD_DIRECTORY + "/" + filename);
		
		resp.setContentType("image/jpeg");
		if(file.exists()) {
			IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
		}
		
	}
}
