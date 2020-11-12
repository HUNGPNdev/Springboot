package btvn.lesson18.controller;

import btvn.lesson18.entities.*;
import btvn.lesson18.repository.OrderRepository;
import btvn.lesson18.service.BrandService;
import btvn.lesson18.service.ColorService;
import btvn.lesson18.service.OrderService;
import btvn.lesson18.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService prodSv;

    @Autowired
    BrandService brandSv;

    @Autowired
    ColorService colorService;

    @Autowired
    OrderService orderService;

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/color")
    public String getColor(Model model) {
        model.addAttribute("prod", prodSv.getAllProduct());
        return "color";
    }

    @GetMapping("/brand")
    public String getBrand(Model model) {
        model.addAttribute("brand", brandSv.getAllBrand());
        return "brand";
    }

    @GetMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("prod", prodSv.getAllProduct());
        model.addAttribute("oder", orderService.getAllOrder());
        return "order";
    }

    @PostMapping("/order")
    public String postOrder(Model model, @RequestParam String orderAddress, @RequestParam String customerName,
                            @RequestParam String customerPhone, @RequestParam int count, @RequestParam int[] productId) {
        List<ProductEntity> pro = new ArrayList<>();
        for (int id : productId) {
            pro.add(prodSv.getProductById(id));
            System.out.println(prodSv.getProductById(id).getProductName());
        }
        List<Order_details> order_details = new ArrayList<>();
        for (ProductEntity p : pro) {
            order_details.add(new Order_details(p, count));
        }
        OrderEntity orderEntity = new OrderEntity(orderAddress,customerName,customerPhone,order_details);

        orderService.insertOrder(orderEntity);
        return "redirect:/order";
    }


    @GetMapping("/product")
    public String getProduct(Model model) {
        model.addAttribute("prod", prodSv.getAllProduct());
        model.addAttribute("brand", brandSv.getAllBrand());
        model.addAttribute("color", colorService.getAllColor());
        return "product";
    }

    @PostMapping("/product")
    public String postProduct(Model model, @RequestParam int[] color, @RequestParam String productName,
                              @RequestParam long price, @RequestParam int brand) {
        List<ColorEntity> colorEntities = new ArrayList<>();
        for (int id : color) {
            colorEntities.add(colorService.getColorById(id));
        }
        prodSv.insertProduct(new ProductEntity(productName, colorEntities, price, brandSv.getBrandById(brand)));
        return "redirect:/product";
    }
}
