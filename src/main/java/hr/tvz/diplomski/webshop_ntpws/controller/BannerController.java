package hr.tvz.diplomski.webshop_ntpws.controller;

import hr.tvz.diplomski.webshop_ntpws.service.BannerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = "http://localhost:4200")
public class BannerController {

    @Resource
    private BannerService bannerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAllBanners() {
        return bannerService.getAllBanners();
    }
}
