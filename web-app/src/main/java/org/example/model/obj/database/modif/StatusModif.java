package org.example.model.obj.database.modif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.obj.database.model.UserOrder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatusModif {
    private Long id;
    private String status;
    private List<UserOrder> userOrderList;
}
