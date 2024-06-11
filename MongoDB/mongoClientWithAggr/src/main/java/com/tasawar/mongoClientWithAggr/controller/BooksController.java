package com.tasawar.mongoClientWithAggr.controller;

import com.tasawar.mongoClientWithAggr.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BooksController {

    private final BooksService booksService;


    @GetMapping
    public List<Object> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PostMapping
    public String addBook(@RequestBody Map<String, Object> book) {
        return booksService.addBook(book);
    }

    @PutMapping
    public String updateBook(@RequestBody Map<String, Object> book) {
        return booksService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return booksService.deleteBook(id);
    }

    @GetMapping("/page")
    public Map<String, Object> getAllBooksByPage(
            @RequestParam( value = "pageNo",defaultValue = "0") int pageNo,
            @RequestParam( value = "pageSize",defaultValue = "10") int pageSize,
            @RequestParam( value = "sortBy",defaultValue = "id") String sortBy,
            @RequestParam( value = "fields",defaultValue = "title,pageCount") List<String> fields

    ) {
        System.out.println(fields);
        return booksService.getAllBooksByPage(pageNo,pageSize,sortBy,fields);
    }

    @GetMapping("/count-page")
    public Map<String,Object> countPage() {
        return booksService.countPage();
    }
}
