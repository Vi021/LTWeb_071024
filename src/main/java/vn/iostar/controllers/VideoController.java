package vn.iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entities.Video;
import vn.iostar.services.ICategoryService;
import vn.iostar.services.IVideoService;
import vn.iostar.services.impl.CategoryService;
import vn.iostar.services.impl.VideoService;
import vn.iostar.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet(urlPatterns = {"/videos", "/video/add", "/video/insert",
        "/video/edit", "/video/update", "/video/delete"})
public class VideoController extends HttpServlet {
    public IVideoService vidService = new VideoService();
    public ICategoryService catService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if (url.contains("/videos")) {
            List<Video> lst = vidService.findAll();

            req.setAttribute("listvid", lst);
            req.getRequestDispatcher("/views/video/video-list.jsp").forward(req, resp);
        } else if (url.contains("/video/add")) {
            req.getRequestDispatcher("/views/video/video-add.jsp").forward(req, resp);
        } else if (url.contains("/video/edit")) {
            String id = req.getParameter("id");
            Video video = vidService.findById(id);

            req.setAttribute("vid", video);
            req.getRequestDispatcher("/views/video/video-edit.jsp").forward(req, resp);
        } else if (url.contains("/video/delete")) {
            String vidid = req.getParameter("id");

            try {
                vidService.delete(vidid);

            } catch (Exception e) {
                e.printStackTrace();
            }

            resp.sendRedirect(req.getContextPath() + "/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String url = req.getRequestURI();
        if (url.contains("/video/insert")) {
            Video video = new Video();

            String id = req.getParameter("vidid");
            String title = req.getParameter("title");
            String description = req.getParameter("desc");
            int views = Integer.parseInt(req.getParameter("views"));
            boolean active = Boolean.parseBoolean(req.getParameter("status"));
            String catid = req.getParameter("catid");

            video.setVideoid(id);
            video.setTitle(title);
            video.setDescription(description);
            video.setViews(views);
            if (!catid.isEmpty() && catid != null) {
                video.setCategory(catService.findById(Integer.parseInt(catid)));
            }
            video.setActive(active);

            String filename = "";
            File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("posterfile"); // #
                if (part != null && part.getSize() > 0) {
                    String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                    int index = fname.lastIndexOf(".");
                    String ext = fname.substring(index + 1);
                    filename = System.currentTimeMillis() + "." + ext;

                    part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);

                    video.setPoster(filename);
                } else {
                    video.setPoster("sunglasses_sunflower.jpg");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            vidService.insert(video);

            resp.sendRedirect(req.getContextPath() + "/videos");
        } else if (url.contains("/video/update")) {
            Video video = new Video();

            String id = req.getParameter("vidid");
            String title = req.getParameter("title");
            String description = req.getParameter("desc");
            int views = Integer.parseInt(req.getParameter("views"));
            boolean active = Boolean.parseBoolean(req.getParameter("status"));
            String catid = req.getParameter("catid");

            video.setVideoid(id);
            video.setTitle(title);
            video.setDescription(description);
            video.setViews(views);
            if (!catid.isEmpty() && catid != null) {
                video.setCategory(catService.findById(Integer.parseInt(catid)));
            }
            video.setActive(active);

            Video vidold = vidService.findById(id);
            String posold = vidold.getPoster();
            String filename = "";
            File uploadDir = new File(Constants.UPLOAD_DIRECTORY);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("posterfile"); // #
                if (part != null && part.getSize() > 0) {
                    String fname = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                    int index = fname.lastIndexOf(".");
                    String ext = fname.substring(index + 1);
                    filename = System.currentTimeMillis() + "." + ext;

                    part.write(Constants.UPLOAD_DIRECTORY + "/" + filename);

                    video.setPoster(filename);
                } else {
                    video.setPoster(posold);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            vidService.update(video);

            resp.sendRedirect(req.getContextPath() + "/videos");
        }
    }
}
