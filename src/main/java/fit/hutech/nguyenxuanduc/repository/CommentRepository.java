package fit.hutech.nguyenxuanduc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.hutech.nguyenxuanduc.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
