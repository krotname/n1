package name.krot.n2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/autors")
    public List<Autor> getAutors() {
        return autorRepository.findAll();
    }
}
