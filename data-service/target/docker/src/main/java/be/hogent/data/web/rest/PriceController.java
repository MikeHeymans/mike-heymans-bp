package be.hogent.data.web.rest;

import be.hogent.data.model.Price;
import be.hogent.data.model.Product;
import be.hogent.data.service.PriceService;
import be.hogent.data.web.dto.PriceDTO;
import be.hogent.data.web.dto.ProductDTO;
import be.hogent.data.web.dto.mapper.PriceDTOMapper;
import be.hogent.data.web.dto.mapper.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody PriceDTO priceDTO) {
        priceService.save(PriceDTOMapper.toEntity(priceDTO));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/bulk", method = RequestMethod.POST)
    public ResponseEntity saveBulk(@RequestBody List<PriceDTO> productDTOList) {
        List<Price> priceList = productDTOList.stream()
                .map(dto -> PriceDTOMapper.toEntity(dto))
                .collect(Collectors.toList());
        priceService.save(priceList);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PriceDTO> findOne(@PathVariable("id") Long id) {
        ResponseEntity<PriceDTO> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Price price = priceService.findOne(id);
        if (price != null) {
            responseEntity = new ResponseEntity<>(PriceDTOMapper.toDto(price), HttpStatus.OK);
        }
        return responseEntity;
    }
}
