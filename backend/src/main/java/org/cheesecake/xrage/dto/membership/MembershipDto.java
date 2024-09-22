package org.cheesecake.xrage.dto.membership;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembershipDto {
    private Long id;
    private String name;
    private float cost;
    private int duration;
    private String description;
    private boolean isDelete;
}
