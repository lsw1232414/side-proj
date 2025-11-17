package com.lsw.onbid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsw.onbid.model.History;
import com.lsw.onbid.model.Item;
import com.lsw.onbid.service.HistoryService;
import com.lsw.onbid.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/onbid")
public class ItemDetailController {

    private final ItemService itemService;
    private final HistoryService historyService;

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {

        Item item = itemService.findById(id);
        if (item == null) return "redirect:/onbid/list";

        History history = null;
        if (item.getCltrNo() != null) {
            history = historyService.findLatest(item.getCltrNo());
        }

        model.addAttribute("item", item);
        model.addAttribute("history", history);

        return "onbid/detail";   // detail.html
    }

}
