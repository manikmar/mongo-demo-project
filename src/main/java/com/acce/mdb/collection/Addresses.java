package com.acce.mdb.collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Addresses {
    private String address1;
    private String address2;
    private String city;
}
