package fit.hutech.nguyenxuanduc.service.impl;

import fit.hutech.nguyenxuanduc.entity.Comment;
import fit.hutech.nguyenxuanduc.entity.Post;
import fit.hutech.nguyenxuanduc.entity.Product;
import fit.hutech.nguyenxuanduc.entity.User;
import fit.hutech.nguyenxuanduc.exception.InternalServerException;
import fit.hutech.nguyenxuanduc.model.request.CreateCommentPostRequest;
import fit.hutech.nguyenxuanduc.model.request.CreateCommentProductRequest;
import fit.hutech.nguyenxuanduc.repository.CommentRepository;
import fit.hutech.nguyenxuanduc.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createCommentPost(CreateCommentPostRequest createCommentPostRequest, long userId) {
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(createCommentPostRequest.getPostId());
        comment.setPost(post);
        User user = new User();
        user.setId(userId);
        comment.setUser(user);
        comment.setContent(createCommentPostRequest.getContent());
        comment.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            throw new InternalServerException("Có lỗi trong quá trình bình luận!");
        }
        return comment;
    }

    @Override
    public Comment createCommentProduct(CreateCommentProductRequest createCommentProductRequest, long userId) {
        Comment comment = new Comment();
        comment.setContent(createCommentProductRequest.getContent());
        comment.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        User user = new User();
        user.setId(userId);
        comment.setUser(user);
        Product product = new Product();
        product.setId(createCommentProductRequest.getProductId());
        comment.setProduct(product);
        try {
            commentRepository.save(comment);
        } catch (Exception e) {
            throw new InternalServerException("Có lỗi trong quá trình bình luận!");
        }
        return comment;
    }
}
