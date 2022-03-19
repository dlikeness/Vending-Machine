package com.techelevator;

import com.techelevator.view.Item;
import com.techelevator.view.Log;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class VendingMachineCLI {
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    private List<Item> itemList;
    private Menu menu;
    private VendingMachine vm;
    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() throws IOException {
        File vendingMachineList = new File("vendingmachine.csv");
//        Log.createLogFile();
        vm = new VendingMachine();
        itemList = vm.getInventory(vendingMachineList);
        while (true) {

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                for (Item item: itemList){
                    System.out.println("Slot: " + item.getItemSlot() + " | " + "Item Name: " + item.getName() + " | " + "Item Price: " + item.getPrice() + " | " + "Item Type: " + item.getItemType() + " | " + "Item Quantity: " + item.getQuantity());
                }

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                System.out.println();
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println("Current Money Provided: " + "$" + df.format(vm.getCurrentBalance()));

                while (true) {

                    choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (choice.equals(PURCHASE_MENU_OPTIONS[0])) {
                        System.out.println();
                        df = new DecimalFormat("0.00");
                        vm.feedMoneySubMenu();
                        //method for feeding money. take input of currency
                    } else if (choice.equals(PURCHASE_MENU_OPTIONS[1])) {
                        //show current inventory stock
                        vm.selectProduct();
                        df = new DecimalFormat("0.00");
                        System.out.println("Current Money Provided: " + "$" + df.format(vm.getCurrentBalance()));
                        //method for selecting the product. update quantity if sufficient funds. if sold out show sold out
                    } else if (choice.equals(PURCHASE_MENU_OPTIONS[2])) {
                        //method for finishing
                        vm.finishTransaction();
                        break;
                    }
                }
//                System.out.println();
//                System.out.println("Current Money Provided: " + vm.currentMoney());
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
//                EXIT option needs to return change and also exit the system no break out
                System.out.println("Thank you, don't forget your change!");

                System.exit(0);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }


}
