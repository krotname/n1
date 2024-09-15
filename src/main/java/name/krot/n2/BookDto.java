package name.krot.n2;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookDto {
    private Long id;
    private String name;
}
