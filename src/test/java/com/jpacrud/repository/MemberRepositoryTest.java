package com.jpacrud.repository;


import org.junit.jupiter.api.Test;



class MemberRepositoryTest {



    @Test
    public void 회원생성() throws Exception{
        //given



    }





}






//    @Test
//    @Transactional
//    public void memberRead(){ //조회
//        Optional<Member> readMember = memberRepository.findById(1L);
//        Optional<Team> readTeam = teamRepository.findById(1L);
//
//
//        readMember.ifPresent(selectMember ->{ // 멤버 조회
//
//            System.out.println(selectMember.getMemberAccount());
//            System.out.println(selectMember.getMemberName());
//            System.out.println(selectMember.getMemberPassword());
//            System.out.println(selectMember.getTeam());
//        });
//
//        readTeam.ifPresent(selectTeam ->{ // 팀 조회
//
//            System.out.println(selectTeam.getTeamName());
//            System.out.println(selectTeam.getTeamAddress());
//            System.out.println(selectTeam.getMembers());
//
//
//        });
//
//    }
//
//
//
//
//
//    @Test
//    public void update(){ // 수정
//        Optional<Member> member = memberRepository.findById(1L);
//        Optional<Team> team = teamRepository.findById(1L);
//
//        member.ifPresent(selectMember->{
//
////            selectMember.setMemberPassword("수정된패스워드");
////            selectMember.setMemberAccount("수정된계정");
////            selectMember.setMemberName("수정된이름");
//
//            memberRepository.save(selectMember);
//        });
//
//        team.ifPresent(selectTeam-> {
//            selectTeam.setTeamName("수정팀");
//            selectTeam.setTeamAddress("수정된주소");
//
//            teamRepository.save(selectTeam);
//        });
//
//    }
//

//    @Test
//    public void delete(){ // 삭제
//        Optional<Member> member = memberRepository.findById(3L);
//        Optional<Team> team  = teamRepository.findById(2L);
//
//        member.ifPresent(selectMember ->{
//            memberRepository.delete(selectMember);
//        });
//
//        team.ifPresent(selectTeam ->{
//            teamRepository.delete(selectTeam);
//        });
//
//
//    }

//}