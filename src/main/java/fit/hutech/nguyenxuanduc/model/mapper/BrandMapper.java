package fit.hutech.nguyenxuanduc.model.mapper;

import fit.hutech.nguyenxuanduc.entity.Brand;
import fit.hutech.nguyenxuanduc.model.dto.BrandDTO;
import fit.hutech.nguyenxuanduc.model.request.CreateBrandRequest;

import java.sql.Timestamp;

public class BrandMapper {
    public static BrandDTO toBrandDTO(Brand brand){
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        brandDTO.setDescription(brand.getDescription());
        brandDTO.setThumbnail(brand.getThumbnail());
        brandDTO.setStatus(brand.isStatus());

        return brandDTO;
    }

    public static Brand toBrand(CreateBrandRequest createBrandRequest){
        Brand brand= new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setDescription(createBrandRequest.getDescription());
        brand.setThumbnail(createBrandRequest.getThumbnail());
        brand.setStatus(createBrandRequest.isStatus());
        brand.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        return brand;
    }
}
