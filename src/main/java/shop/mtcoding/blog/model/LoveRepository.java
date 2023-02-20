package shop.mtcoding.blog.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoveRepository {
    public Love findByBoardIdAndUserId(int boardId, int userId);

    public List<Love> findAll();

    public Love findById(int id);

    public int insert(Love love);

    public int updateById(Love love);

    public int deleteById(int id);
}
