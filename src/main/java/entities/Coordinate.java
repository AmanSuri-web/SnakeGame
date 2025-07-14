package entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Coordinate {
    private Integer x;
    private Integer y;

}
