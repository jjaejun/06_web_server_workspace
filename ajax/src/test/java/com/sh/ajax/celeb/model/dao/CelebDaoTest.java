package com.sh.ajax.celeb.model.dao;

import com.sh.ajax.celeb.model.entity.Celeb;
import com.sh.ajax.celeb.model.entity.Type;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sh.ajax.common.SqlSessionTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class CelebDaoTest {
    CelebDao celebDao;
    SqlSession session;

    @BeforeEach
    public void setUp() {
        // fixture 생성
        this.celebDao = new CelebDao();
        this.session = getSqlSession();
    }

    @AfterEach
    public void tearDown() {
        // fixture 객체
        // session rollback 처리
        this.session.rollback();
        this.session.close();
    }

    @Test
    public void test() {
        assertThat(celebDao).isNotNull();
        assertThat(session).isNotNull();
    }

    @DisplayName("Celeb 전체조회")
    @Test
    public void test1() {
        // when
        List<Celeb> celebs = celebDao.findAll(session);

        // then
        assertThat(celebs)
                .isNotNull()
                .allSatisfy((celeb) -> {
                    // pk, 필수값 확인
                    assertThat(celeb.getId()).isNotZero();
                    assertThat(celeb.getName()).isNotNull();
                    assertThat(celeb.getProfile()).isNotNull();
                    assertThat(celeb.getType()).isNotNull();
                });
    }

    @DisplayName("Celeb 존재하는 한건 조회")
    @ParameterizedTest
    @MethodSource("celebIdProvider")
    public void test2(long id) {
        // when
        Celeb celeb = celebDao.findById(session, id);

        // then
        assertThat(celeb)
                .isNotNull()
                .satisfies((_celeb) -> {
                    assertThat(_celeb.getId()).isNotZero();
                    assertThat(_celeb.getName()).isNotNull();
                    assertThat(_celeb.getProfile()).isNotNull();
                    assertThat(_celeb.getType()).isNotNull();
                });
    }

    @DisplayName("Celeb 존재하지 않는 한건 조회")
    @ParameterizedTest
    @ValueSource(longs = {1000, 1001, 1002})
    public void test3(long id) {
        // when
        Celeb celeb = celebDao.findById(session, id);

        // then
        assertThat(celeb).isNull();
    }

    @DisplayName("Celeb 등록")
    @ParameterizedTest
    @CsvSource({"동방신기, 동방신기.jpg, SINGER"})
    @Order(1)
    public void test4(String name, String profile, Type type) {
        // given
        assertThat(name).isNotNull();
        assertThat(profile).isNotNull();
        assertThat(type).isNotNull();

        Celeb celeb = new Celeb();
        celeb.setName(name);
        celeb.setProfile(profile);
        celeb.setType(type);
        System.out.println(celeb);

        // when
        int result = celebDao.insertCeleb(session, celeb);

        // then
        assertThat(result).isGreaterThan(0);
        Long id = celeb.getId(); // <selectKey>로 가져온 값
        Celeb celebInserted = celebDao.findById(session, id);
        System.out.println(celebInserted);
        assertThat(id).isNotZero();
        assertThat(celebInserted).satisfies((c) -> {
            assertThat(c.getName()).isNotNull();
            assertThat(c.getProfile()).isNotNull();
            assertThat(c.getType()).isNotNull();
        });
    }

    @DisplayName("Celeb 수정")
    @ParameterizedTest
    @MethodSource("celebIdProvider")
    @Order(2)
    public void test5(long id) {
        // given
        Celeb celeb = celebDao.findById(session, id);
        assertThat(celeb).isNotNull();

        String newName = "빅뱅";
        String newProfile = "빅뱅.jpg";
        Type newType = Type.SINGER;
        celeb.setName(newName);
        celeb.setProfile(newProfile);
        celeb.setType(newType);

        // when
        int result = celebDao.updateCeleb(session, celeb);

        // then
        assertThat(result).isGreaterThan(0);
        Celeb celebUpdated = celebDao.findByName(session, "빅뱅");
        assertThat(celebUpdated).satisfies((c) -> {
            assertThat(c.getName()).isNotNull();
            assertThat(c.getProfile()).isNotNull();
            assertThat(c.getType()).isNotNull();
        });
    }

    @DisplayName("Celeb 삭제")
    @ParameterizedTest
    @MethodSource("celebIdProvider")
    @Order(3)
    public void test6(Long id) {
        // given
        assertThat(id).isNotNull().isNotZero();

        // when
        int result = celebDao.deleteCeleb(session, id);

        // then
        assertThat(result).isGreaterThan(0);
        Celeb celebDeleted = celebDao.findById(session, id);
        assertThat(celebDeleted).isNull();
    }

    public static Stream<Long> celebIdProvider() {
        CelebDao celebDao = new CelebDao();
        SqlSession session = getSqlSession();
        List<Celeb> celebs = celebDao.findAll(session);
        return celebs.stream() // Stream<Celeb>
                .filter((celeb) -> celeb.getId() <= 5)
                .map((celeb -> celeb.getId()));
    }
}
