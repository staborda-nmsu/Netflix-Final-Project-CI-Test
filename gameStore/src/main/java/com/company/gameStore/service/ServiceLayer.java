package com.company.gameStore.service;

import com.company.gameStore.models.Game;
import com.company.gameStore.models.Invoice;
import com.company.gameStore.models.Tax;
import com.company.gameStore.repositories.FeeRepository;
import com.company.gameStore.repositories.GameRepository;
import com.company.gameStore.repositories.InvoiceRepository;
import com.company.gameStore.repositories.TaxRepository;
import com.company.gameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ServiceLayer {

    // All repos are needed

//    private InvoiceRepository invoiceRepository;
//    private GameRepository gameRepository;
//    private ConsoleRepository consoleRepository;
//    private TshirtRepository tshirtRepository;
//    private FeeRepository feeRepository;
//    private TaxRepository taxRepository;
//
//    @Autowired
//    public ServiceLayer(InvoiceRepository invoiceRepository, GameRepository gameRepository,
//                        ConsoleRepository consoleRepository, TshirtRepository tshirtRepository,
//                        FeeRepository feeRepository, TaxRepository taxRepository) {
//        this.invoiceRepository = invoiceRepository;
//        this.gameRepository = gameRepository;
//        this.consoleRepository = consoleRepository;
//        this.tshirtRepository = tshirtRepository;
//        this.feeRepository = feeRepository;
//        this.taxRepository = taxRepository;
//    }
//
//    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
//
//        Invoice invoice = new Invoice();
//        invoice.setName(invoiceViewModel.getName());
//        invoice.setStreet(invoiceViewModel.getStreet());
//        invoice.setCity(invoiceViewModel.getCity());
//        invoice.setState(invoiceViewModel.getState());
//        invoice.setZipcode(invoiceViewModel.getZipcode());
//        invoice.setItemType(invoiceViewModel.getItemType());
//        invoice.setItemId(invoiceViewModel.getItemId());
//        invoice.setQuantity(invoiceViewModel.getQuantity());
//
//        if (invoiceViewModel.getItemType().equals("Game")) {
//            Optional<Game> gameContainer = gameRepository.findById(invoiceViewModel.getItemId());
//
//            if (gameContainer.isPresent()) {
//                Game game = gameContainer.get();
//                double price = game.getPrice();
//                double subtotal = price * invoiceViewModel.getQuantity();
//                Tax tax = taxRepository.findByState(invoiceViewModel.getState());
//                double taxRate = tax.getRate().doubleValue();
//                double totalTax = taxRate * subtotal;
//
//            } else {
//                return null;
//            }
//
//        } else if (invoiceViewModel.getItemType().equals("T-Shirt")) {
//
//        } else if (invoiceViewModel.getItemType().equals("Console")) {
//
//        }
//
//    }
}
