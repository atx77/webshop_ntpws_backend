package hr.tvz.diplomski.webshop_ntpws.service.impl;

import hr.tvz.diplomski.webshop_ntpws.domain.Banner;
import hr.tvz.diplomski.webshop_ntpws.repository.BannerRepository;
import hr.tvz.diplomski.webshop_ntpws.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerRepository bannerRepository;

    @Override
    public List<String> getAllBanners() {
        return bannerRepository.findAll().stream().map(Banner::getUrl).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
