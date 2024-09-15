package name.krot.n2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


// http://localhost:8080/swagger-ui/index.html#/controller/getAutors
// http://localhost:8080/h2-console

@RestController
@RequiredArgsConstructor
public class Controller {

    private final BookRepository bookRepository;
    private final AutorRepository autorRepository;

    @GetMapping("/books")
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books
                .stream()
                .map(b -> BookDto.builder()
                        .id(b.getId())
                        .name(b.getName())
                        .build())
                .toList();
    }

    @GetMapping("/book/{id}")
    public BookDto getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book
                .map(b -> BookDto.builder()
                        .id(id)
                        .name(b.getName())
                        .autors(b.getAutors())
                        .build())
                .orElseThrow();
    }

    @GetMapping("/autors")
    public List<Autor> getAutors() {
        return autorRepository.findAll();
    }

    @GetMapping("/autor/{id}")
    public Optional<Autor> getAutor(Long id) {
        return autorRepository.findById(id);
    }
}
