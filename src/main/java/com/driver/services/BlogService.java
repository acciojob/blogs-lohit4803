package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog> blogList = blogRepository1.findAll();
        return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        //updating the blog details
        //Updating the userInformation and changing its blogs
        User currentUser = userRepository1.findById(userId).get();
        List<Blog> blogListByUser = currentUser.getBlogList();
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blogListByUser.add(blog);
        currentUser.setBlogList(blogListByUser);
        blog.setUser(currentUser);
        userRepository1.save(currentUser);


    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Blog blog = blogRepository1.findById(blogId).get();
        Image image= imageService1.createAndReturn(blog,description,dimensions);
        image.setBlog(blog);
        blogRepository1.save(blog);

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }

    public int getAllBlogs() {
        List<Blog> blogList = blogRepository1.findAll();
        return blogList.size();
    }
}
