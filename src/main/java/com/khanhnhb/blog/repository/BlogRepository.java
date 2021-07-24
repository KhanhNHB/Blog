package com.khanhnhb.blog.repository;

import com.khanhnhb.blog.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
