package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    User user;

    @Autowired
    Blog blog;

    public List<Blog> showBlogs(){
        //find all blogs
        List<Blog> blogList = blogRepository.findAll();
        return blogList;
    }

    public void createAndReturnBlog(Integer userId, String title, String content)
    {
        //create a blog at the current time
        //updating the blog details
        //Updating the userInformation and changing its blogs
        Blog b = new Blog();

        User user = userRepository.findById(userId).get();

        b.setUser(user);
        b.setTitle(title);
        b.setContent(content);
        b.setPubDate(new Date());

        List<Blog> li = user.getBlogList();
        li.add(b);
        user.setBlogList(li);

        userRepository.save(user);

    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it

        Blog b = blogRepository.findById(blogId).get();

        Image image = imageService.createAndReturn(b,description,dimensions);

        List<Image> li = blog.getImageList();
        li.add(image);
        blog.setImageList(li);

        blogRepository.save(b);

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository.deleteById(blogId);
    }

    public int getAllBlogs() {
        List<Blog> blogList = blogRepository.findAll();
        return blogList.size();
    }
}
