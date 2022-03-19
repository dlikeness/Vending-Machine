package com.techelevator.view;

import org.junit.*;
import org.junit.runners.MethodSorters;
import java.io.File;
import java.math.BigDecimal;
import java.text.Bidi;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matcher;
import org.mockito.Matchers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTest {
    File vendingMachineList = new File("vendingmachine.csv");
    File badVendingMachineList = new File("vendingmachine2.csv");
    VendingMachine vm;

    @Before
    public void setup() {
        vm = new VendingMachine();
    }

    @Test
    public void testGetInventory() {
        try {
            vm.getInventory(vendingMachineList);
            Assert.assertTrue(vm.getItemList().size() > 0);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testGetInventory_numberException() {
        try {
            vm.getInventory(badVendingMachineList);
        } catch (NumberFormatException e) {
            Assert.fail();
        }
    }

    @Test
    public void testFeedMoney() {
      BigDecimal actual = vm.feedMoney(5);
      BigDecimal expected = new BigDecimal("5");
      Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSelectProduct() {
    }

    @Test
    public void testFinishTransaction() {
    }
}
