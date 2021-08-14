package com.stackroute.controller;


import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import com.stackroute.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/* Add annotation to declare this class as REST Controller */
@RestController
@RequestMapping("api/v1/blog")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }
    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    @PostMapping
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog)
    {
        return new ResponseEntity<>(blogService.saveBlog(blog) , HttpStatus.CREATED);
    }

    /*This method should fetch all blogs and return the list of all blogs */
    @GetMapping
    public ResponseEntity<Blog> getAllBlogs() {
        return new ResponseEntity(blogService.getAllBlogs() , HttpStatus.FOUND);
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        return new ResponseEntity<>(blogService.getBlogById(id) , HttpStatus.FOUND);
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    @DeleteMapping("{id}")
    public ResponseEntity<?> getBlogAfterDeleting(@PathVariable int id) {
        return new ResponseEntity<>(blogService.deleteBlog(id) , HttpStatus.OK);
    }

    /*This method should update blog and return the updatedBlog */
    @PutMapping
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.updateBlog(blog) , HttpStatus.CREATED);
    }
}