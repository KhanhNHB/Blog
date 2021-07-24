package com.khanhnhb.blog.controller;

import com.khanhnhb.blog.model.Blog;
import com.khanhnhb.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping()
    public @ResponseBody Blog createBlog(@RequestBody Blog newBlog) {
        return blogRepository.save(newBlog);
    }

    @GetMapping()
    public @ResponseBody Iterable<Blog> getAll() {
        return blogRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Blog getOne(@PathVariable Integer id) {
        return blogRepository.findById(id).get();
    }

    @PutMapping(path = "{id}")
    public @ResponseBody Blog updateBlog(@PathVariable Integer id, @RequestBody Blog updateBlog) {
        Blog blog = blogRepository.findById(id).get();

        blog.setTitle(updateBlog.getTitle());
        blog.setContent(updateBlog.getContent());

        return blogRepository.save(blog);

    }

    @DeleteMapping(path = "{id}")
    public @ResponseBody Integer deleteBlog(@PathVariable Integer id) {
        Blog blog = blogRepository.findById(id).get();
        blogRepository.delete(blog);
        return blog.getId();
    }
}
