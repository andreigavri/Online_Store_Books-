package com.example.project2.services;
import com.example.project2.entities.AuthorEntity;
import com.example.project2.models.Author;
import com.example.project2.models.Product;
import com.example.project2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        AuthorEntity authorEntityToSaveInDb = AuthorEntity.builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();
        authorRepository.save(authorEntityToSaveInDb);
        author.setId(authorEntityToSaveInDb.getId());
        return author;
    }

    @Override
    public Author getAuthorById(Integer id) {
        Optional<AuthorEntity> optionalEntity = authorRepository.findById(id);
        if (optionalEntity.isPresent()) {
            AuthorEntity entity = optionalEntity.get();
            return Author.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .build();
        }
        return null;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorByLastName(String lastName) {
        AuthorEntity entity = authorRepository.findByLastName(lastName);
        Author authorToReturnFromDb = Author.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
        return authorToReturnFromDb;
    }

    @Override
    public Author updateAuthor(Integer id, Author author) {
        Optional<AuthorEntity> foundAuthor = authorRepository.findById(id);
        if (foundAuthor.isPresent()) {
            AuthorEntity authorToUpdate = foundAuthor.get();
            authorToUpdate.setFirstName(author.getFirstName());
            authorToUpdate.setLastName(author.getLastName());
            authorRepository.save(authorToUpdate);
            return author;
        }
        return null;
    }

    @Override
    public void deleteAuthorById(Integer id) { authorRepository.deleteById(id);

    }
    @Override
    public void deleteAllAuthors() {authorRepository.deleteAll();
    }
}
