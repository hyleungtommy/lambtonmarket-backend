package ca.lambtoncollege.JavaEEProject.Services;

import org.springframework.data.repository.CrudRepository;

import ca.lambtoncollege.JavaEEProject.model.MarketPost;
public interface MarketPostRepo extends CrudRepository<MarketPost, Integer>{

}
