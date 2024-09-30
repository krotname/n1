package name.krot.n2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@Entity
@BatchSize(size = 3)
public class Book {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Getter
    @ToString.Include
    private String name;

    @Getter
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;
}
