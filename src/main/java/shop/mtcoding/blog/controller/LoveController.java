package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.blog.handler.ex.CustomApiException;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.service.LoveService;

@RestController
public class LoveController {

    @Setter
    @Getter
    public static class LoveSaveReqDto {
        private Integer boardId;
    }

    @Autowired
    private HttpSession session;

    @Autowired
    private LoveService loveService;

    @PostMapping("/love")
    public ResponseEntity<?> save(@RequestBody LoveSaveReqDto loveSaveReqDto) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            throw new CustomException("인증이 되지 않았습니다", HttpStatus.UNAUTHORIZED);
        }
        if (loveSaveReqDto.getBoardId() == null) {
            throw new CustomApiException("boerdId를 전달해주세요");
        }
        int loveId = loveService.좋아요(loveSaveReqDto.getBoardId(), principal.getId());

        return null;
    }
}
