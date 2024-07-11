package com.example.entity;

import com.example.config.MyBatisConfig;
import com.example.repository.mybatis.BoardMapper;
import com.example.repository.mybatis.BoardServiceImpl;
import com.example.web.dtos.BoardDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@SpringBootTest
@SpringBootConfiguration

@MybatisTest
class BoardServiceTest {



    @Test
    void findBoard(){
      AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);
        BoardServiceImpl boardService = ac.getBean("boardService", BoardServiceImpl.class);

        List<BoardDto> contents  = boardService.findAll();

        for (BoardDto boardDto : contents){
            System.out.println(boardDto);
        }

        // given


        // when

        // then
//        Assertions.assertThat(contents.size()).isEqualTo(3);
    }
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyBatisConfig.class);


//    @Test
//    @DisplayName("모든 빈 출력하기")
//    void findAllBean() {
//        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름 조회
//        for (String beanDefinitionName : beanDefinitionNames) {
//            Object bean = ac.getBean(beanDefinitionName);// getBean(): Bean 이름으로 Bean 객체(인스턴스)를 조회
//            System.out.println("name = " + beanDefinitionName + " object: " + bean);
//        }
//    }

}