package name.krot.n2;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class BookDto {
    private Long id;
    private String name;
    private Set<Autor> autors;
}
