package com.jpacrud.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.MatcherAssert.assertThat;


@RestController
@RequiredArgsConstructor
@SpringBootTest
class BoardApiControllerTest {

    @LocalServerPort // 로컬서버 동작여부
    private int port;

    private final PostRepository postRepository;

    private final TestRestTemplate testRestTemplate;

    @Test
    public void 게시판_생성() throws Exception{
        //given
        String title = "제목";
        String author = "글쓴이";
        String content = "내용";
        PostDto postsRequestDto = PostDto.builder()
                .title(title)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/api/board/create";

        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, postsRequestDto, Long.class);


        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Posts> all = postRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(title);
//        assertThat(all.get(0).getContent()).isEqualTo(content);


    }

}