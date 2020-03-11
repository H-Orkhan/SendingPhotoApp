package com.sendPhoto.SendingPhotoApp.repo;
import com.sendPhoto.SendingPhotoApp.models.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDb extends CrudRepository<Photo,Integer> {
}
