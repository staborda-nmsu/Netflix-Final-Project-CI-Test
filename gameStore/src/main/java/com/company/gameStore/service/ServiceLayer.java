package com.company.gameStore.service;

import com.company.gameStore.repositories.GameRepository;
import com.company.gameStore.repositories.InvoiceRepository;
import com.company.gameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    private InvoiceRepository invoiceRepository;
    private GameRepository gameRepository;
    private ConsoleRepository consoleRepository;
    private TshirtRepository tshirtRepository;

    @Autowired
    public ServiceLayer(InvoiceRepository invoiceRepository, GameRepository gameRepository,
                        ConsoleRepository consoleRepository, TshirtRepository tshirtRepository) {
        this.invoiceRepository = invoiceRepository;
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
        this.tshirtRepository = tshirtRepository;

    }

    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {

    }
}
