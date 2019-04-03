package com.joana.sportShop.Controler;

import com.joana.sportShop.exceptions.NoSuchProductException;
import com.joana.sportShop.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.joana.sportShop.services.serviceManifacturerImpl;
import com.joana.sportShop.services.serviceProductImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductControler {
   serviceManifacturerImpl serviceManifacturer;
   serviceProductImpl serviceProduct;
   public ProductControler (){
       serviceManifacturer=new serviceManifacturerImpl();
       serviceProduct=new serviceProductImpl();
   }
   @GetMapping("/show")
    public String products(Model model)
   {
       model.addAttribute("productsList",serviceProduct.findAllProducts());
       model.addAttribute("manufacturerList",serviceManifacturer.findAllManufacturer());
       model.addAttribute("product", new Product());
       return "products";
   }
   @GetMapping("/findById/{id}")
    public String productById(@PathVariable("id") Long id,Model model) throws NoSuchProductException {
       Product p=serviceProduct.findProductById(id);
       model.addAttribute("id",p.getId());
       model.addAttribute("name",p.getName());
       model.addAttribute("image",p.getUrlImage());
       model.addAttribute("manufacturer",p.getManufacturer().getName());
       model.addAttribute("category",p.getCategory().getName());
       return "productById";
   }
    @PostMapping("/add")
    public String addProduct(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        Long manId = Long.parseLong(request.getParameter("manufacturerId"));
        Long catId = Long.parseLong(request.getParameter("categoryId"));
        serviceProduct.addProduct(name, manId,catId,url);
        model.addAttribute("productsList",serviceProduct.findAllProducts());
        return "redirect:/products/";

    }
}
