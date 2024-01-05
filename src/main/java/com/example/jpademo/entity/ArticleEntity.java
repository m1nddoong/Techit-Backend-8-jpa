package com.example.jpademo.entity;

/*
CREATE TABLE article (
    id INTEGER PRIMARY KEY AUTOINCREMENT, -- Long
    title TEXT,   -- String
    content TEXT,      -- String
);
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 이 클래스가 데이터베이스 상의 어떤 테이블을 나타내는 클래스 임을 알려주는 어노테이션
// 클래스 이름과 실제 테이블이 다르거나 기타 설정등을 제공하기 위한 어노테이션
@Table(name="article")
public class ArticleEntity {
    @Id // 이 속성(필드)가 테이블의 PK(Identity)임을 나타내는 어노테이션
    // 이 속성의 컬럼 데이터는 데이터베이스에서 자동으로 부여하는 값 및 어떻게 부여할지를 정의하는 어노테이션
    // 쉽게 말해 AUTOINCREMENT 이다 라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    // 실제 테이블의 컬럼 설정 전달
    @Column(name = "username")
    private String writer;
    private String category;
}


