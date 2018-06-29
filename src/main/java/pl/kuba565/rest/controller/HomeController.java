package pl.kuba565.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kuba565.rest.model.News;
import pl.kuba565.rest.repository.NewsRepository;

import java.util.List;

@RestController
@RequestMapping("/news")
public class HomeController {

    private NewsRepository newsRepository;

    @Autowired
    HomeController (NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/{id}")
    public News getNews(@PathVariable String id) {
        return newsRepository.getOne(Long.valueOf(id));
    }

    @PostMapping("/")
    public void addNews(@RequestBody News news){
        newsRepository.save(news);
    }

    @GetMapping("/")
    public List<News> getAllNews (){
        return newsRepository.findAll();
    }

    @PutMapping("/{id}")
    public void editNews(@PathVariable String id, News news){
        news.setId(Long.valueOf(id));
        newsRepository.save(news);
    }

    @DeleteMapping("/{id}")
    public void deleteNewsById(@PathVariable String id){
        newsRepository.deleteById(Long.valueOf(id));
    }
}
