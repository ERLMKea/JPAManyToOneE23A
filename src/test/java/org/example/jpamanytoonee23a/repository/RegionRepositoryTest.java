package org.example.jpamanytoonee23a.repository;

import jakarta.transaction.Transactional;
import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.model.Region;
import org.example.jpamanytoonee23a.service.ServiceKommuner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    ServiceKommuner serviceKommuner;

    @Test
    void test5Regioner() {
        List<Region> regions = regionRepository.findAll();
        assertEquals(10, regions.size());
    }

    @Test
    void testStarterMedBogstav() {
        var obj = serviceKommuner.getKommunerStartsWith('C');
        assertEquals(1, obj.size());
    }

    @DisplayName("TestStatsMed")
    @ParameterizedTest
    @MethodSource("komdata")
    void testStartsWithParm(char c, int cnt) {
        List<Kommune> lstKom = serviceKommuner.getKommunerStartsWith(c);
        assertEquals(cnt, lstKom.size());
    }

    private static Stream<Arguments> komdata() {
        return Stream.of(
                Arguments.of('C', 1),
                Arguments.of('B', 5),
                Arguments.of('K', 9),
                Arguments.of('R', 7)
        );
    }

    @Test
    @Transactional
    void testKommunerInRegionNordjyl() {
        Optional<Region> regOpt = regionRepository.findById("1081");
        if (regOpt.isPresent()) {
            Region reg = regOpt.get();
            Set<Kommune> kommuner= reg.getKommuner();
            assertEquals(15, kommuner.size());
        } else {
            fail("Region not found");
        }
    }


}