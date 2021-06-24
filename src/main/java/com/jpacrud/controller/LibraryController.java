////package com.jpacrud.controller;
////
////import com.jpacrud.domain.Author;
////import com.jpacrud.domain.Book;
////import com.jpacrud.domain.Member;
////import com.jpacrud.dto.AuthorCreateRequestDto;
////import com.jpacrud.dto.BookCreateRequestDto;
////import com.jpacrud.dto.BookLendRequestDto;
////import com.jpacrud.dto.MemberCreateRequestDto;
////import com.jpacrud.service.LibraryService;
////import lombok.RequiredArgsConstructor;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import javax.websocket.server.PathParam;
////import java.util.List;
////
////@RestController
////@RequestMapping(value ="/api/library")
////@RequiredArgsConstructor
////public class LibraryController {
////
////    private final LibraryService libraryService;
////
////    /**
////     * *주의! 실제 서비스를 개발할때는 Repository에서 반환하는 ResponseEntity를 응답값으로 반환하면 안됩니다.
////     * RepositoryEntity 스팩이 변경되면 API의 응답값이 변경되기 때문입니다.
////     * 조회한 객체를 응답값으로 매핑하는 로직이 필요하지만 해당 예제에서는 생략하겠습니다.
////     *
////     * @param
////     * @return
////     */
////
////    @GetMapping("/book") // 전체 책 조회
////    public ResponseEntity readBooks(@RequestParam(required = false) String bookIsbn) {
////        if (bookIsbn == null) {
////            return ResponseEntity.ok(libraryService.readBooks());
////        }
////        return ResponseEntity.ok(libraryService.readBook(bookIsbn));
////    }
////
////    @GetMapping("/book/{bookId}") // id 책 조회
////    public ResponseEntity<Book> readBook(@PathVariable Long bookId) {
////        return ResponseEntity.ok(libraryService.readBook(bookId));
////    }
////
//
//import org.springframework.web.bind.annotation.RequestBody;
//
//@PostMapping("/book")//책 생성
//    public ResponseEntity<Book> createBook(@RequestBody BookCreateRequestDto bookCreateRequestDto) {
//        return ResponseEntity.ok(libraryService.createBook(bookCreateRequestDto));
//    }
//
//
//    @DeleteMapping("/book/{bookId}") // 도서 삭제
//    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
//        libraryService.deleteBook(bookId);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/member")// 회원 생성
//    public ResponseEntity<Member> createMember (@RequestBody MemberCreateRequestDto memberCreateRequestDto) {
//        return ResponseEntity.ok(libraryService.createMember(memberCreateRequestDto));
//    }
//
//    @PatchMapping("/member/{memberId}") // 회원 변경
//    public ResponseEntity<Member> updateMember (@RequestBody MemberCreateRequestDto memberCreateRequestDto,
//                @PathVariable Long memberId) {
//        return ResponseEntity.ok(libraryService.updateMember(memberId, memberCreateRequestDto));
//    }
//
////    @PostMapping("/book/lend") //도서 대출
////    public ResponseEntity<List<String>> lendABook(@RequestBody BookLendRequestDto bookLendRequestDto) {
////        return ResponseEntity.ok(libraryService.lendABook((List<BookLendRequestDto>) bookLendRequestDto));
////    }
//
//    @PostMapping("/author") // 저자 추가
//    public ResponseEntity<Author> createAuthor (@RequestBody AuthorCreateRequestDto authorCreateRequestDto)
//    {
//        return ResponseEntity.ok(libraryService.createAuthor(authorCreateRequestDto));
//    }
//
//}
