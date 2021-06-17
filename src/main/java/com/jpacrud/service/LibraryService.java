package com.jpacrud.service;

import com.jpacrud.domain.*;
import com.jpacrud.dto.AuthorCreateRequestDto;

import com.jpacrud.dto.BookCreateRequestDto;
import com.jpacrud.dto.BookLendRequestDto;
import com.jpacrud.dto.MemberCreateRequestDto;
import com.jpacrud.repository.AuthorRepository;
import com.jpacrud.repository.BookRepository;
import com.jpacrud.repository.LendRepository;
import com.jpacrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // 의존성 주입 DI
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;
    private final LendRepository lendRepository;
    private final BookRepository bookRepository;


    public Book readBook(Long bookId) { //책 아이디 조회
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return book.get();
        }

        throw new EntityNotFoundException(
                "Cant find any book under given ID");
    }

    public List<Book> readBooks() {
        return bookRepository.findAll();
    }

    public Book readBook(String bookIsbn){  //
        Optional<Book> book = bookRepository.findByBookIsbn(bookIsbn);
        if(book.isPresent()){
            return book.get();
        }

        throw new EntityNotFoundException(
                "Cant find any book under given ISBN");
    }

    public Book createBook(BookCreateRequestDto bookCreateRequestDto) { //책 생성
        Optional<Author> author = authorRepository.findById(bookCreateRequestDto.getAuthorId());
        if (!author.isPresent()) {
            throw new EntityNotFoundException(
                    "Author Not Found");
        }

        Book bookToCreate = new Book();
        BeanUtils.copyProperties(bookToCreate, bookToCreate);
        bookToCreate.setAuthor(author.get());
        return bookRepository.save(bookToCreate);
    }

    public void deleteBook(Long id){ // 책 삭제
        bookRepository.deleteById(id);
    }

    public Member createMember(MemberCreateRequestDto memberCreateRequestDto){ // 사용자 생성
        Member member = new Member();
        BeanUtils.copyProperties(memberCreateRequestDto, member);
        return memberRepository.save(member);
    }

    public Member updateMember (Long memberId, MemberCreateRequestDto memberCreateRequestDto) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (!optionalMember.isPresent()) {
            throw new EntityNotFoundException(
                    "Member not present in the database");
        }


        Member member = optionalMember.get();
        member.setMemberName(memberCreateRequestDto.getMemberName());

        return memberRepository.save(member);
    }

    public Author createAuthor (AuthorCreateRequestDto authorCreateRequestDto ){ // 작가 생성
        Author author = new Author();
        BeanUtils.copyProperties(authorCreateRequestDto, author);
        return authorRepository.save(author);
    }


    public List<String> lendABook (List<BookLendRequestDto> list) {
        List<String> booksApprovedToBurrow = new ArrayList<>();
        list.forEach(bookLendRequestDto -> {
            Optional<Book> bookForId =
                    bookRepository.findById(bookLendRequestDto.getMemberId());
            if (!bookForId.isPresent()) {
                throw new EntityNotFoundException(
                        "Cant find any book under given ID");
            }

            Optional<Member> memberForId =
                    memberRepository.findById(bookLendRequestDto.getMemberId());
            if (!memberForId.isPresent()) {
                throw new EntityNotFoundException(
                        "Member not present in the database");
            }


            Member member = memberForId.get();
            if (member.getStatus() != MemberStatus.ACTIVE) {
                throw new RuntimeException(
                        "User is not active to proceed a lending.");
            }

            Optional<Lend> burrowedBook =
            lendRepository.findByBookAndStatus(
                    bookForId.get(), LendStatus.BURROWED);

            if (!burrowedBook.isPresent()){
                booksApprovedToBurrow.add(bookForId.get().getBookName());
                Lend lend = new Lend();
                lend.setMember(memberForId.get());
                lend.setBook(bookForId.get());
                lend.setStatus(LendStatus.BURROWED);
                lendRepository.save(lend);
            }
        });

        return booksApprovedToBurrow;


    }










}
