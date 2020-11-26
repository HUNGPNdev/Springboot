package t3h.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import t3h.springboot.service.Impl.Mailer;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
@RequestMapping("/lab5/")
public class Lab5Controller {

    @Autowired
    ServletContext context;

    @RequestMapping("bai2form")
    public String bai2form() {
        return "lab5form";
    }

    @RequestMapping("bai2apply")
    public String bai2apply(Model model, @RequestParam("fullname") String fullname, @RequestParam("photo") MultipartFile photo,
                            @RequestParam("cv") MultipartFile cv) {
        if(photo.isEmpty()) {
//             || cv.isEmpty()
            model.addAttribute("message", "Vui lòng chọn file!");
        } else {
            try {
                String photoPath = context.getRealPath("/files/"+photo.getOriginalFilename());
                photo.transferTo(new File(photoPath));

                String cvPath = context.getRealPath("/files/"+ cv.getOriginalFilename());
                cv.transferTo(new File(cvPath));

                model.addAttribute("cv_name", cv.getOriginalFilename());
                model.addAttribute("cv_type", cv.getContentType());
                model.addAttribute("cv_size", cv.getSize());
                model.addAttribute("photo_name", photo.getOriginalFilename());
            } catch (Exception e) {

            }
        }
        return "lab5apply";
    }

    @RequestMapping("bai3")
    public String bai3() {
        return "bai3";
    }

    @Autowired
    Mailer mailer;
    @RequestMapping("send")
    public String send(Model model, @RequestParam("from") String from, @RequestParam("to") String to,
                       @RequestParam("subject") String subject, @RequestParam("body") String body) {
        try {
            mailer.send(to,subject,body);
            model.addAttribute("message", "Đã gửi");
        } catch (Exception e) {
            model.addAttribute("message", "Gửi thất bại");
        }
        return "bai3";
    }
}
