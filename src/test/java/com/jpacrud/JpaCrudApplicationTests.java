package com.jpacrud;

import com.jpacrud.controller.LibraryController;
import com.jpacrud.service.LibraryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest // 통합테스트
@WebMvcTest(LibraryController.class) // 단위 테스트
@DisplayName("LibraryController 테스트")

class JpaCrudApplicationTests {




}
