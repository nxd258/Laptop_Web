package fit.hutech.nguyenxuanduc.service;

import fit.hutech.nguyenxuanduc.entity.Comment;
import fit.hutech.nguyenxuanduc.model.request.CreateCommentPostRequest;
import fit.hutech.nguyenxuanduc.model.request.CreateCommentProductRequest;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment createCommentPost(CreateCommentPostRequest createCommentPostRequest,long userId);
    Comment createCommentProduct(CreateCommentProductRequest createCommentProductRequest, long userId);
}
