package com.dp3.web.controller;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.ListRepository;
import com.dp3.dao.StockRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.PriceList;
import com.dp3.domain.Stock;
import com.dp3.domain.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/lists")
@CrossOrigin("*")
public class PriceListController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ListRepository listRepository;

    @GetMapping("/all")
    public ModelAndView stock(Model model){
        ModelAndView list = new ModelAndView("pricelist");
        model.addAttribute("lists", listRepository.findAll());
        model.addAttribute("stockList",stockRepository.findAll());
        return list;
    }



    @PostMapping("/createList")
    public ModelAndView createWine(Model model, PriceList priceList){
        model.addAttribute("stockList", stockRepository.findAll());
        model.addAttribute("lists", listRepository.findAll());
        listRepository.save(priceList);
        return new ModelAndView("redirect:/lists/all");
    }

    @GetMapping(value = "/{listCode}")
    public ResponseEntity<PriceList> getPriceListByListCode(@PathVariable("listCode") String listCode){
        PriceList priceList = listRepository.findOne(listCode);
        if(priceList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(priceList, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/edit/{listCode}")
    public ResponseEntity<PriceList> updatePriceList(@PathVariable("listCode") String listCode,
                                             @Valid @RequestBody PriceList priceList){
        PriceList listData = listRepository.findOne(listCode);
        if(listData == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        listData.setListName(priceList.getListName());
        listData.setProductName(priceList.getProductName());
        listData.setListPrice(priceList.getListPrice());
        listData.setListPriceFinal(priceList.getListPriceFinal());
        PriceList updatePriceList = listRepository.save(listData);
        return new ResponseEntity<>(updatePriceList,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{listCode}")
    public ModelAndView deleteStock(Model model,@PathVariable("listCode") String listCode){
        model.addAttribute("lists", listRepository.findAll());
        listRepository.delete(listCode);
        return new ModelAndView("redirect:/lists/all");
    }

}

