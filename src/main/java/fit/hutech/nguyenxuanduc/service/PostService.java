package fit.hutech.nguyenxuanduc.service;

import fit.hutech.nguyenxuanduc.entity.Post;
import fit.hutech.nguyenxuanduc.entity.User;
import fit.hutech.nguyenxuanduc.model.dto.PageableDTO;
import fit.hutech.nguyenxuanduc.model.request.CreatePostRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    PageableDTO adminGetListPost(String title, String status, int page);

    Post createPost(CreatePostRequest createPostRequest, User user);

    void updatePost(CreatePostRequest createPostRequest, User user, Long id);

    void deletePost(long id);

    Post getPostById(long id);

    Page<Post> adminGetListPosts(String title, String status, Integer page);

    List<Post> getLatesPost();

    Page<Post> getListPost(int page);

    List<Post> getLatestPostsNotId(long id);

    long getCountPost();
}
