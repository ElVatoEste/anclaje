package customidentifiers;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
@Getter
@Setter
public class Identificator {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(length = 32)
    private String id;

}