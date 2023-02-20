package shop.mtcoding.blog.model;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoveRepositoryTest {
    @Test
    public void findByBoardIdAndUserId_test() throws Exception {
        // given
        int boardId = 1;
        int userId = 1;

        // ObjectMapper는 Timestamp 파싱을 못함!!
        // ObjectMapper om = new ObjectMapper(); // Jackson

        // when
        Love lovePS = loveRepository.findByBoardIdAndUserId(boardId, userId);

        // String responseBody = om.writeValueAsString(lovePS);
        // System.out.println("테스트 : " + responseBody);

        // then
        assertThat(lovePS.getBoardId()).isEqualTo(1);
        assertThat(lovePS.getUserId()).isEqualTo(1);
    }
}
