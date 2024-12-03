package com.example.BasicSpringBootApi.service;
import com.example.BasicSpringBootApi.model.Photo;
import com.example.BasicSpringBootApi.repository.PhotoRepository;
import org.springframework.stereotype.Service;

//@Component
@Service
public class PhotoService {

//    Injecting the database to Access data
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> getAllPhotos(){
        return photoRepository.findAll();
    }

    public Photo getPhotoById(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void removePhoto(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo savePhoto(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();

        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photoRepository.save(photo); // Save photo to database
        return photo;
    }
}

// private List<User> db = List.of(new User("1", "Hart", "Chikanma", "hart@gmail.com"));

// Demo DataBase
//    private Map<String, Photo> db = new HashMap<String, Photo>();
//    {
//        db.put("1", new Photo("1", "hart.png"));
//    }