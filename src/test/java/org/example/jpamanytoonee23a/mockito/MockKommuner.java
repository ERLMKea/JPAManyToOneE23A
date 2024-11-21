package org.example.jpamanytoonee23a.mockito;

import org.example.jpamanytoonee23a.model.Kommune;
import org.example.jpamanytoonee23a.service.ServiceKommuner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockKommuner {

    @Test
    void testKommuner() {
       ServiceKommuner serviceKommuner = mock(ServiceKommuner.class);
       List<Kommune> lstKommuner = serviceKommuner.getKommunerStartsWith('R');
       assertEquals(0, lstKommuner.size());
       Kommune komRos = new Kommune();
       komRos.setKode("0265");
       komRos.setNavn("Roskilde");
       List<Kommune> someKommune = new ArrayList<>();
       someKommune.add(komRos);
       Kommune komRing = new Kommune();
       komRing.setKode("329");
       someKommune.add(komRing);
       when(serviceKommuner.getKommunerStartsWith('R')).thenReturn(someKommune);
       List<Kommune> mockKommuner = serviceKommuner.getKommunerStartsWith('R');
       assertEquals(true, mockKommuner.size() == 2);
    }

}
