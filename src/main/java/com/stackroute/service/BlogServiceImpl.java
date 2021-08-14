package com.stackroute.service;


import com.stackroute.domain.Blog;
import com.stackroute.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* Add annotation to declare this class as Service class.
 * Also it should implement BlogService Interface and override all the implemented methods.*/
@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        Blog newBlog = blogRepository.save(blog);
        return newBlog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.getById(id);
    }

    @Override
    public Blog deleteBlog(int id) {
        Blog blog = blogRepository.getById(id);
        if (blog != null) {
            blogRepository.deleteById(id);
        }
        return blog;
    }
    @Override
    public Blog updateBlog(Blog blog) {
        Blog blogExist = blogRepository.getById(blog.getBlogId());
        if(blogExist!=null){
            blogExist.setAuthorName(blog.getAuthorName());
            blogExist.setBlogTitle(blog.getBlogTitle());
            blogExist.setBlogContent(blog.getBlogContent());
        }
        return blogExist;
    }

}
