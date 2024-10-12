package vn.iostar.controllers;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entities.Category;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.impl.CategoryService;
import vn.iostar.utils.Constants;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet(urlPatterns = { "/categories", "/category/add", "/category/insert",
		"/category/update", "/category/edit", "/category/delete" })
public class CategoryController extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;
	public ICategoryService catService = new CategoryService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/categories")) {
			List<Category> lst = catService.findAll();

			req.setAttribute("listcat", lst);
			req.getRequestDispatcher("/views/category/category-list.jsp").forward(req, resp);
		} else if (url.contains("/category/add")) {
			req.getRequestDispatcher("/views/category/category-add.jsp").forward(req, resp);
		} else if (url.contains("/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = catService.findById(id);

			req.setAttribute("cat", category);
			req.getRequestDispatcher("/views/category/category-edit.jsp").forward(req, resp);
		} else if (url.contains("/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));

			try {
				catService.delete(id);

			} catch (Exception e) {
				e.printStackTrace();
			}

			resp.sendRedirect(req.getContextPath() + "/categories");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/category/insert")) {
			String categoryname = req.getParameter("catename");
			boolean status = Boolean.parseBoolean(req.getParameter("status"));
			Category category = new Category();
			
			category.setCategoryname(categoryname);
			category.setStatus(status);

			String filename = "";
			File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("cateimgfile"); // #
				if (part != null && part.getSize() > 0) {
					String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					int index = fname.lastIndexOf(".");
					String ext = fname.substring(index + 1);
					filename = System.currentTimeMillis() + "." + ext;

					part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);

					category.setImage(filename);
				} else {
					category.setImage("sunglasses_sunflower.jpg");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			catService.insert(category);

			resp.sendRedirect(req.getContextPath() + "/categories");
		} else if (url.contains("/category/update")) {
			int id = Integer.parseInt(req.getParameter("cateid"));
			String categoryname = req.getParameter("catename");
			boolean status = Boolean.parseBoolean(req.getParameter("status"));
			Category category = new Category();

			category.setCategoryid(id);
			category.setCategoryname(categoryname);
			category.setStatus(status);

			Category catold = catService.findById(id);
			String imgold = catold.getImage();

			String filename = "";

			File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("cateimgfile"); // #
				if (part != null && part.getSize() > 0) {
					String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					int index = fname.lastIndexOf(".");
					String ext = fname.substring(index + 1);
					filename = System.currentTimeMillis() + "." + ext;

					part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);

					category.setImage(filename);
				} else {
					category.setImage(imgold);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			catService.update(category);

			resp.sendRedirect(req.getContextPath() + "/categories");
		}
	}
}
