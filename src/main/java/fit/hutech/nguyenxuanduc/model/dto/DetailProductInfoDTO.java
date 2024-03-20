package fit.hutech.nguyenxuanduc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import fit.hutech.nguyenxuanduc.entity.Brand;
import fit.hutech.nguyenxuanduc.entity.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DetailProductInfoDTO {
    private String id;

    private String name;

    private String slug;

    private long price;

    private int views;

    private long totalSold;

    private ArrayList<String> productImages;

    private ArrayList<String> feedbackImages;

    private long promotionPrice;

    private String couponCode;

    private String description;

    private Brand brand;

    private List<Comment> comments;
}
