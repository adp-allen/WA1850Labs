package com.example.service;

import com.example.dao.PurchaseDao;
import com.example.entity.Purchase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImplTests {

    @Mock 
    PurchaseDao purchaseDao;

    @InjectMocks 
    PurchaseServiceImpl purchaseService;

    @Test
    public void testFindAllPurchases() {
        Purchase p1 = new Purchase("John", "Basketball", new Date());
        Purchase p2 = new Purchase("Paul", "Football", new Date());
        List<Purchase> expectedPurchases = Arrays.asList(p1, p2);

        when(purchaseDao.getAllPurchases()).thenReturn(expectedPurchases);

        List<Purchase> result = purchaseService.findAllPurchases();

        assertThat(result).containsExactlyElementsOf(expectedPurchases);

        verify(purchaseDao).getAllPurchases();
    }
}