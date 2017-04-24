package be.hogent.data.service;

import be.hogent.data.model.Price;
import be.hogent.data.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ModificationLogService modificationLogService;

    public Price findOne(Long id) {
        return priceRepository.findOne(id);
    }

    public void save(Price price) {
        modificationLogService.create(price);
        priceRepository.save(price);
    }

    public void save(List<Price> priceList) {
        if (priceList != null) {
            priceList.forEach(this::save);
        }
    }
}
