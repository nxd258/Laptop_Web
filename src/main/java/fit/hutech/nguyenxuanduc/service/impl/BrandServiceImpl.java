package fit.hutech.nguyenxuanduc.service.impl;

import fit.hutech.nguyenxuanduc.entity.Brand;
import fit.hutech.nguyenxuanduc.exception.BadRequestException;
import fit.hutech.nguyenxuanduc.exception.InternalServerException;
import fit.hutech.nguyenxuanduc.exception.NotFoundException;
import fit.hutech.nguyenxuanduc.model.mapper.BrandMapper;
import fit.hutech.nguyenxuanduc.model.request.CreateBrandRequest;
import fit.hutech.nguyenxuanduc.repository.BrandRepository;
import fit.hutech.nguyenxuanduc.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static fit.hutech.nguyenxuanduc.config.Contant.LIMIT_BRAND;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Brand> adminGetListBrands(String id, String name, String status, Integer page) {
        page--;
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, LIMIT_BRAND, Sort.by("created_at").descending());
        return brandRepository.adminGetListBrands(id, name, status, pageable);

    }

    @Override
    public List<Brand> getListBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand createBrand(CreateBrandRequest createBrandRequest) {
        Brand brand = brandRepository.findByName(createBrandRequest.getName());
        if (brand != null) {
            throw new BadRequestException("Tên nhãn hiệu đã tồn tại trong hệ thống, Vui lòng chọn tên khác!");
        }
        brand = BrandMapper.toBrand(createBrandRequest);
        brandRepository.save(brand);
        return brand;
    }

    @Override
    public void updateBrand(CreateBrandRequest createBrandRequest, Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new NotFoundException("Tên nhãn hiệu không tồn tại!");
        }
        Brand br = brandRepository.findByName(createBrandRequest.getName());
        if (br != null) {
            if (!createBrandRequest.getId().equals(br.getId()))
                throw new BadRequestException("Tên nhãn hiệu " + createBrandRequest.getName() + " đã tồn tại trong hệ thống, Vui lòng chọn tên khác!");
        }
        Brand rs = brand.get();
        rs.setId(id);
        rs.setName(createBrandRequest.getName());
        rs.setDescription(createBrandRequest.getDescription());
        rs.setThumbnail(createBrandRequest.getThumbnail());
        rs.setStatus(createBrandRequest.isStatus());
        rs.setModifiedAt(new Timestamp(System.currentTimeMillis()));

        try {
            brandRepository.save(rs);
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi chỉnh sửa nhãn hiệu");
        }
    }

    @Override
    public void deleteBrand(long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new NotFoundException("Tên nhãn hiệu không tồn tại!");
        }
        try {
            brandRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Lỗi khi xóa nhãn hiệu!");
        }
    }

    @Override
    public Brand getBrandById(long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new NotFoundException("Tên nhãn hiệu không tồn tại!");
        }
        return brand.get();
    }

    @Override
    public long getCountBrands() {
        return brandRepository.count();
    }
}
