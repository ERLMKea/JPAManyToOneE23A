package org.example.jpamanytoonee23a.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    @Test
    void inlineTest() {
        Map mapMock = mock(Map.class);
        assertEquals(0, mapMock.size());
    }

    @Test
    void testInlineMock2() {
        Map<String, String> mapMock = mock(Map.class);
        assertEquals(mapMock.size(), 0);
        when(mapMock.get("hej")).thenReturn("ehej");
        assertEquals("ehej", mapMock.get("hej"));
    }

    @Test
    void testListThenThen() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2,listMock.size());
        assertEquals(3, listMock.size());
    }

}
