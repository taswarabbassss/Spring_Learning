package com.tasawar.mongoClientWithAggr.service;

import com.tasawar.mongoClientWithAggr.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BooksService {
    private final BooksRepository booksRepository;

    public List<Object> getAllBooks() {
       return booksRepository.getAllBooks();
    }

    public String addBook(Map<String, Object> book) {
        Document bookDocument = new Document(book);
        return booksRepository.add(bookDocument);

    }

    public String updateBook(Map<String, Object> book) {
        Document bookDocument = new Document(book);
        String id  = bookDocument.getString("id");
        return booksRepository.updateBook(bookDocument,id);
    }

    public String deleteBook(String id) {
       return booksRepository.deleteBook(id);
    }

    public Map<String, Object> getAllBooksByPage(int pageNo, int pageSize, String sortBy, List<String> fields) {
        Map<String,Object> response = new HashMap<>();
        List<Object> allBooksByPage = booksRepository.getAllBooksByPage(pageNo, pageSize, sortBy, fields);
        response.put("data",allBooksByPage);
        long count = booksRepository.countTotalNoOfElements();
        response.put("No of Books", count);
        response.put("No of Pages",Math.ceil(count/pageSize));
        return response;
    }

    public Map<String, Object> countPage() {
        Map<String,Object> response = new HashMap<>();
response.put("Total No. of pages", booksRepository.countPage());
        return response;
    }
}
