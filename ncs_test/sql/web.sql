-- test 계정 생성 (관리자)
alter session set "_oracle_script" = true;

create userDTO ncs_test
identified by ncs_test
default tablespace users;

grant connect, resource to ncs_test;

alter userDTO ncs_test quota unlimited on users;

-- ncs_test 계정 시작
CREATE TABLE TB_USER(
USER_NO NUMBER PRIMARY KEY,
USER_ID VARCHAR2(50) UNIQUE NOT NULL,
USER_NAME VARCHAR2(50) NOT NULL,
USER_AGE NUMBER NOT NULL
);

CREATE SEQUENCE SEQ_UNO
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO TB_USER VALUES(SEQ_UNO.NEXTVAL, 'gd_hong', '홍길동', 20);

INSERT INTO TB_USER VALUES(SEQ_UNO.NEXTVAL, 'sh_han', '한소희', 28);

INSERT INTO TB_USER VALUES(SEQ_UNO.NEXTVAL, 'jm_park', '지민', 27);

COMMIT;

select * from tb_user;

-- ncs_test2
create table student(
    student_number number primary key
    , student_name varchar2(15)
    , korean_score number
    , english_score number
    , math_score number
);

create table tb_manager(
    manager_number number primary key
    , manager_name varchar2(15)
    , manager_hire_date varchar2(10)
);

insert into tb_manager values(1, '홍길동', '2023-10-10');